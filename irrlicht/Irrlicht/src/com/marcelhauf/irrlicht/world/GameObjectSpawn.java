package com.marcelhauf.irrlicht.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class GameObjectSpawn implements Serializable {
	public final Vector2 position = new Vector2();

	@Override
	public void write(Json json) {
		json.writeValue("x", position.x);
		json.writeValue("y", position.y);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		switch(jsonData.child().name()) {
		case "x":
			position.x = jsonData.child().asFloat();
		case "y":
			position.y = jsonData.child().asFloat();
		}
		
	}
	
	
}