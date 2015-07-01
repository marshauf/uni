package com.marcelhauf.irrlicht.world.manager;

import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.marcelhauf.irrlicht.world.Enemy;
import com.marcelhauf.irrlicht.world.Item;
import com.marcelhauf.irrlicht.world.Player;
import com.marcelhauf.irrlicht.world.map.Map;

/*
Map:
+ Walls

Objects:
+ Player
	+ Position
	+ Direction
+ Items
	+ Type
	+ Position
+ Enemies
	+ Type
	+ Position
	+ Direction
	
json:
{
	"map": "W",
	"cell_radius": 32.0,
	"items": [
		{
			"x": 64.0,
			"y": 64.0,
			"type":"MANA",
		},
	],
	"player": {
		"name" : "",
		"dir": {
			"x": 0.0,
			"y": 0.0,
		},
		"speed": 0.0,
		"bounds": {
			"x": 0.0,
			"y": 0.0,
			"width": 0.0,
			"height": 0.0,
		}
	}
}
*/

public class WorldState implements Serializable{
	public String map;
	public float cellRadius = 32.0f;
	public Item[] items;
	public Enemy[] enemies;
	public Player player = new Player(new Vector2());
	
	@Override
	public void write(Json json) {
		json.writeValue("map", map);
		json.writeValue("cell_radius", cellRadius);
		
		json.writeArrayStart("items");
		if (items != null) {
			for (Item item : items) {
				item.write(json);
			}
		}
		json.writeArrayEnd();
		
		json.writeArrayStart("enemies");
		if (enemies != null) {
			for (Enemy enemy : enemies) {
				enemy.write(json);
			}
		}
		json.writeArrayEnd();
		
		json.writeObjectStart("player");
		if (player != null ) {
			player.write(json);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		map = jsonData.getString("map");
		cellRadius = jsonData.getFloat("cell_radius");
		player.read(json, jsonData.get("player"));
		
		JsonValue jsonItems = jsonData.get("items");
		if (jsonItems != null) {
			items = new Item[jsonItems.size];
			for(int i = 0; i < jsonItems.size; i++) {
				items[i] = new Item();
				items[i].read(json, jsonItems.get(i));
			}
		}
		
		JsonValue jsonEnemies = jsonData.get("enemies");
		if (jsonEnemies!= null) {
			enemies = new Enemy[jsonEnemies.size];
			for(int i = 0; i < jsonEnemies.size; i++) {
				enemies[i] = new Enemy();
				enemies[i].read(json, jsonEnemies.get(i));
			}
		}
	}
}
