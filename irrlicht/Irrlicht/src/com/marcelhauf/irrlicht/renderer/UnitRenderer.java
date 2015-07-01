package com.marcelhauf.irrlicht.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.marcelhauf.irrlicht.world.Enemy;
import com.marcelhauf.irrlicht.world.World;

public class UnitRenderer {
	private final TextureRegion enemyWispTexture;
	private final World world;
	
	public UnitRenderer(World world, TextureRegion enemyWispTexture) {
		this.enemyWispTexture = enemyWispTexture;
		this.world = world;
	}
	
	public void addToBatch(SpriteBatch batch) {
		batch.enableBlending();
		
		Array<Enemy> enemies = world.getEnemies();
		Rectangle bounds = new Rectangle();
		for(Enemy enemy : enemies) {
			enemy.getBounds(bounds);
			batch.draw(enemyWispTexture, bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		batch.disableBlending();
	}
}
