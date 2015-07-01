package com.marcelhauf.irrlicht.renderer;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.marcelhauf.irrlicht.world.Enemy;
import com.marcelhauf.irrlicht.world.Item;
import com.marcelhauf.irrlicht.world.Player;
import com.marcelhauf.irrlicht.world.World;
import com.marcelhauf.irrlicht.world.map.Cell;
import com.marcelhauf.irrlicht.world.map.Map;

public class DebugRenderer {
	private World world;
	private Map map;
	private Player player;
	private Array<Item> items;
	private Array<Enemy> enemies;
	private final Rectangle playerBounds = new Rectangle();
	
	public DebugRenderer(World world) {
		this.world = world;
	}
	
	public void addToBatch(ShapeRenderer renderer) {
		player = world.getPlayer();
		map = world.getMap();
		
		// Debug draw player
		player.getBounds(playerBounds);
		renderer.rect(playerBounds.x, playerBounds.y, playerBounds.width, playerBounds.height);

		// Debug draw map walls
		Cell[][] cells = map.getCells();
		
		float cellRadius = 32; 
		float cellSize = cellRadius * 2;
		float x = 0;
		float y = 0;
				
		for(int n = 0; n < cells.length; n++) {
			Cell[] hCells = cells[n];
			for(int m = 0; m < hCells.length; m++) {
				Cell.Model t = hCells[m].getModel();
				x = m * cellSize;
				y = n * cellSize;
				switch (t) {
				case WALL:
					renderer.rect(x - cellRadius, y - cellRadius, cellRadius * 2, cellRadius * 2);
				}
			}
		}
		
		// Debug draw items
		Vector2 position = new Vector2();
		items = world.getItems();
		for(Item item : items) {
			switch(item.getType()) {
			case MANA: case POWER:
				item.getPosition(position);
				position.sub(Item.manaOrbRadius, Item.manaOrbRadius);
				renderer.rect(position.x, position.y, Item.manaOrbSize, Item.manaOrbSize);
				break;
			case NONE:
			default:
			}
		}
		
		Rectangle bounds = new Rectangle();
		enemies = world.getEnemies();
		for(Enemy enemy : enemies) {
			enemy.getBounds(bounds);
			renderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
	}
}
