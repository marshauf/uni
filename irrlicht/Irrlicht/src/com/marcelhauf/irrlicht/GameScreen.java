package com.marcelhauf.irrlicht;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.marcelhauf.irrlicht.renderer.DebugRenderer;
import com.marcelhauf.irrlicht.renderer.IngameGUIRenderer;
import com.marcelhauf.irrlicht.renderer.ItemRenderer;
import com.marcelhauf.irrlicht.renderer.MapRenderer;
import com.marcelhauf.irrlicht.renderer.PlayerRenderer;
import com.marcelhauf.irrlicht.renderer.UnitRenderer;
import com.marcelhauf.irrlicht.settings.Settings;
import com.marcelhauf.irrlicht.sound.SoundPlayer;
import com.marcelhauf.irrlicht.world.Player;
import com.marcelhauf.irrlicht.world.World;

public class GameScreen implements Screen {
	private OrthographicCamera camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	private World world;
	private MapRenderer mapRenderer;
	private ItemRenderer itemRenderer;
	private IngameGUIRenderer ingameGUIRenderer;
	private UnitRenderer unitRenderer;
	private PlayerRenderer playerRenderer;
	private PlayerController playerController;
	private SoundPlayer soundPlayer;
	private final Vector2 playerPosition = new Vector2();
	private final SpriteBatch batch = new SpriteBatch(); 
	private final Matrix4 transform = new Matrix4();
	private final BitmapFont font;
	
	private final ShapeRenderer shapeRenderer = new ShapeRenderer();
	private DebugRenderer debugRenderer;
	
	public GameScreen(World world, AssetManager manager, BitmapFont font) {
		// Queue up files to be loaded
		manager.load("sounds/mana_orb_pickup.wav", Sound.class);
		manager.load("sounds/power_orb_pickup.wav", Sound.class);
		manager.load("map.atlas", TextureAtlas.class);
		manager.load("objects.atlas", TextureAtlas.class);
		manager.load("settings.json", Settings.class);
		manager.finishLoading(); // Wait until all files are loaded
		
		// Get required assets from the asset manager
		TextureAtlas mapAtlas = manager.get("map.atlas", TextureAtlas.class);
		TextureAtlas objectAtlas = manager.get("objects.atlas", TextureAtlas.class);
		TextureRegion floor = mapAtlas.findRegion("floor_stones1");
		TextureRegion wall = mapAtlas.findRegion("wall_stone_brown0");
		TextureRegion manaOrb = objectAtlas.findRegion("mana_orb");
		TextureRegion powerOrb = objectAtlas.findRegion("power_orb");
		TextureRegion enemyWisp = objectAtlas.findRegion("enemy_wisp");
		Sound manaOrbPickupSound = manager.get("sounds/mana_orb_pickup.wav", Sound.class);
		Sound powerOrbPickupSound = manager.get("sounds/power_orb_pickup.wav", Sound.class);
		Settings settings = manager.get("settings.json", Settings.class);
		
		this.font = font;
		this.world = world;
		
		// Settings
		Gdx.graphics.setVSync(settings.vsync);
		
		// Create renders
		this.mapRenderer = new MapRenderer(this.world.getMap(), floor, wall);
		this.playerRenderer =  new PlayerRenderer(this.world.getPlayer(), objectAtlas.createSprite("wisp"));
		this.itemRenderer = new ItemRenderer(this.world, manaOrb, powerOrb);
		this.ingameGUIRenderer = new IngameGUIRenderer(this.font, this.world.getPlayer());
		this.unitRenderer = new UnitRenderer(this.world, enemyWisp);
		
		if (settings.music) {
			this.soundPlayer = new SoundPlayer(manaOrbPickupSound, powerOrbPickupSound);
			this.world.onItemPickup = this.soundPlayer;
		}
		
		// DEBUG
		debugRenderer = new DebugRenderer(this.world);
		
		// Create input controllers
		this.playerController = new PlayerController(this.world.getPlayer());
		Gdx.input.setInputProcessor(this.playerController);
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// Update motion, collision, ...
		world.update(delta);
		
		if (world.getItems().size < 1) {
			Gdx.app.exit(); // TODO Display a scoreboard and don't hard exit on win
		}
		
		Player player = world.getPlayer();
		player.getPosition(playerPosition);
		
		// Move the world with the inverted player position vector
		transform.setToTranslation(-playerPosition.x, -playerPosition.y,0);
		batch.setTransformMatrix(transform);
		
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.setTransformMatrix(transform);
		shapeRenderer.begin(ShapeType.Line);
		
		batch.begin();
		mapRenderer.addToBatch(batch);
		itemRenderer.addToBatch(batch);
		unitRenderer.addToBatch(batch);
		
		// Move the camera to the player character to render the character on the center of the screen
		transform.setToTranslation(0, 0, 0);
		batch.setTransformMatrix(transform);
		
		playerRenderer.addToBatch(batch);
		
		ingameGUIRenderer.addToBatch(batch);
		
		batch.end();
		
		if (debugRenderer != null) debugRenderer.addToBatch(shapeRenderer);
		
		shapeRenderer.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false, width, height);
		camera.zoom = 1.0f;
		camera.update();
		batch.setProjectionMatrix(camera.projection);
		shapeRenderer.setProjectionMatrix(camera.projection);
	}

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {
		// TODO Dispose of resources created in this screen
	}

}
