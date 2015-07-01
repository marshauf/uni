package com.marcelhauf.irrlicht;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.marcelhauf.irrlicht.settings.Settings;
import com.marcelhauf.irrlicht.settings.SettingsLoader;
import com.marcelhauf.irrlicht.world.World;
import com.marcelhauf.irrlicht.world.manager.WorldState;
import com.marcelhauf.irrlicht.world.manager.WorldStateLoader;

public class Irrlicht extends Game {
	private OrthographicCamera camera;
	private BitmapFont font;
	private AssetManager manager;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		font = new BitmapFont();
		
		manager = new AssetManager();
		manager.setLoader(WorldState.class, new WorldStateLoader(new InternalFileHandleResolver()));
		manager.setLoader(Settings.class, new SettingsLoader(new InternalFileHandleResolver()));
		
		manager.load("maps/beginning.json", WorldState.class);
		
		manager.finishLoading();
		
		WorldState state = manager.get("maps/beginning.json", WorldState.class);
		
		World world = new World(state);
		world.setPlayer(state.player);
		
		GameScreen gameScreen = new GameScreen(world, manager, font);
		setScreen(gameScreen);
	}
	
	@Override
	public void render() {
		super.render(); //important!
		camera.update();
	}
	
	@Override
	public void dispose() {
		manager.dispose();
		font.dispose();
	}
}
