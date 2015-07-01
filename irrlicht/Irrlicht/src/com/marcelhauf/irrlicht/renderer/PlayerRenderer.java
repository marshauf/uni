package com.marcelhauf.irrlicht.renderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.marcelhauf.irrlicht.world.Player;

public class PlayerRenderer {
	private Player player;
	
	private final Vector2 rotation = new Vector2();
	private final Sprite playerSprite = new Sprite();
	
	public PlayerRenderer(Player player, Sprite playerSprite) {
		this.player = player;
		this.playerSprite.set(playerSprite);
		
		Rectangle bounds = new Rectangle();
		player.getBounds(bounds);
		this.playerSprite.setBounds(- bounds.width / 2, - bounds.height / 2, bounds.width, bounds.height);
	}
		
	public void addToBatch(SpriteBatch batch) {
		player.getVelocity(rotation);
		
		batch.enableBlending();
		
		// TODO Rotation
		//playerSprite.setPosition(position.x, position.y);
		playerSprite.draw(batch);
		
		batch.disableBlending();
	}
}
