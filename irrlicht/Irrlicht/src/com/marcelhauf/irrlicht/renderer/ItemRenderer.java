package com.marcelhauf.irrlicht.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.marcelhauf.irrlicht.world.Item;
import com.marcelhauf.irrlicht.world.World;

public class ItemRenderer {
	private World world;
	private final TextureRegion manaOrb;
	private final TextureRegion powerOrb;
	public ShaderProgram shader;
	private ShaderProgram defaultShader;
	
	public ItemRenderer(World world, TextureRegion manaOrbTexture, TextureRegion powerOrbTexture) {
		this.world = world;
		manaOrb = manaOrbTexture;
		powerOrb = powerOrbTexture;
	}
	
	
	
	public void addToBatch(SpriteBatch batch) {
		Array<Item> items = world.getItems();
		
		batch.enableBlending();
		
		if (shader != null) {
			batch.setShader(shader);
		}
		
		Rectangle bounds = new Rectangle();
		for(Item item : items) {
			switch(item.getType()) {
			case MANA:
				item.getBounds(bounds);
				batch.draw(manaOrb, bounds.x, bounds.y, bounds.width, bounds.height);
				break;
			case POWER:
				item.getBounds(bounds);
				batch.draw(powerOrb, bounds.x, bounds.y, bounds.width, bounds.height);
				break;
			case NONE:
			default:
			}
		}
		
		batch.disableBlending();
		
		if (shader != null) {
			if (defaultShader == null) defaultShader = SpriteBatch.createDefaultShader();
			batch.setShader(defaultShader);
		}
	}
}
