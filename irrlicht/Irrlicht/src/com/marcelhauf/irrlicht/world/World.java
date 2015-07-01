package com.marcelhauf.irrlicht.world;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.marcelhauf.irrlicht.world.events.ItemPickup;
import com.marcelhauf.irrlicht.world.manager.WorldState;
import com.marcelhauf.irrlicht.world.map.Cell;
import com.marcelhauf.irrlicht.world.map.Cell.Model;
import com.marcelhauf.irrlicht.world.map.Map;

public class World {
	Player player = new Player(new Vector2());
	public Player getPlayer() { return player; }
	public void setPlayer(Player player) { this.player = player; }
	
	private Array<Enemy> enemies = new Array<Enemy>();
	private Array<Item> items = new Array<Item>();
	
	public ItemPickup onItemPickup;
	
	Map map;
	
	public World(WorldState state) {
		this.map = new Map(state.map);
		this.items.addAll(state.items);
		this.enemies.addAll(state.enemies);
	}
	
	public Map getMap() { return map; }
	public Array<Item> getItems() { return items; }
	public Array<Enemy> getEnemies() { return enemies; }
	
	public void update(float deltaTime) {
		player.update(deltaTime);
		
		for(Enemy enemy : enemies) {
			enemy.update(deltaTime);
		}
		
		for(Item item : items) {
			item.update(deltaTime);
		}
		
		float cellRadius = 32.0f; // TODO Remove hardcoded value
		float cellSize = cellRadius * 2.0f;
		Rectangle cellBounds = new Rectangle(0,0, cellSize, cellSize);
		Rectangle playerBounds = new Rectangle();
		Rectangle intersection = new Rectangle();
		Rectangle enemyBounds = new Rectangle();
		Vector2 center = new Vector2();
		Vector2 dir = new Vector2();
		player.getBounds(playerBounds);
		Cell[][] cellMap = map.getCells();
		
		for(int y = 0; y < cellMap.length; y++) {
			Cell[] cells = cellMap[y];
			cellBounds.y = y * cellSize - cellRadius;
			for(int x = 0; x < cells.length; x++) {
				if (cells[x].getModel() == Model.WALL) {
					cellBounds.x = x * cellSize - cellRadius;
					if (Intersector.intersectRectangles(playerBounds, cellBounds, intersection)) {
						// TODO Collect all intersection and form a repulsion vector from all intersection
						// At the moment multiple collisions/intersections per update cause the object to go through the collided objects or "hang" on one of them
						
						playerBounds.getCenter(center);
						intersection.getCenter(dir);
						dir.sub(center).nor();
						dir.scl(intersection.width, intersection.height);
						center.sub(dir);
						player.setPosition(center);
						player.setVelocity(new Vector2(0,0));
					}
					
					// Enemies collision with walls
					for(Enemy enemy : enemies) {
						enemy.getBounds(enemyBounds);
						if(Intersector.intersectRectangles(enemyBounds, cellBounds, intersection)) {
							enemyBounds.getCenter(center);
							intersection.getCenter(dir);
							dir.sub(center).nor();
							dir.scl(intersection.width, intersection.height);
							center.sub(dir);
							enemy.setPosition(center);
							enemy.setVelocity(new Vector2(0,0));
						}
					}
					
				}
			}
		}
		
		// Items
		Rectangle itemBounds = new Rectangle();
		Iterator<Item> itemIter = items.iterator();
		Item item = null;
		while(itemIter.hasNext()) {
			item = itemIter.next();
			item.getBounds(itemBounds);
			if (itemBounds.overlaps(playerBounds)) {
				switch(item.getType()) {
				case MANA:
					if (onItemPickup != null) onItemPickup.onItemPickup(item);
					itemIter.remove();
					player.score.collectedManaOrbs++;
					break;
				case POWER:
					if (onItemPickup != null) onItemPickup.onItemPickup(item);
					itemIter.remove();
					player.empower(10.0f); // TODO Remove hardcoded time of 10 seconds
					break;
				}
			}
		}
		
		// Enemy collisions with player
		for(Enemy enemy : enemies) {
			enemy.getBounds(enemyBounds);
			if (enemyBounds.overlaps(playerBounds)) {
				Gdx.app.exit(); // TODO Display a scoreboard and don't hard exit on win
			}
		}
	}
}
