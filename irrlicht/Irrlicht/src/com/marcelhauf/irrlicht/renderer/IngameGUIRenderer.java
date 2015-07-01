package com.marcelhauf.irrlicht.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.marcelhauf.irrlicht.world.Player;
import com.marcelhauf.irrlicht.world.Score;

public class IngameGUIRenderer {
	private final Player player;
	private final BitmapFont font;
	
	public IngameGUIRenderer(BitmapFont font, Player player) {
		this.player = player;
		this.font = font;
	}
	
	public void addToBatch(SpriteBatch batch) {
		Float empowerTime = player.getTimeLeftOnEmpowered();
		
		batch.enableBlending();
		font.draw(batch, String.format("Mana orbs collected: %d", player.score.collectedManaOrbs), (float)Gdx.graphics.getWidth() * -0.5f, 0.0f);
		font.draw(batch, String.format("Lives: %d", player.score.lives), (float)Gdx.graphics.getWidth() * -0.5f, 25.0f);
		font.draw(batch, String.format("Empowered: %.3f seconds", empowerTime), (float)Gdx.graphics.getWidth() * -0.5f, 50.0f);
		font.draw(batch, String.format("Playername: %s", player.name), (float)Gdx.graphics.getWidth() * -0.5f, 75.0f);
		batch.disableBlending();
	}
}
