package com.marcelhauf.irrlicht.world;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Score implements Serializable {
	
	public int collectedManaOrbs = 0;
	public int lives = 0;
	
	@Override
	public void write(Json json) {
		json.writeValue("mana_orbs", collectedManaOrbs);
		json.writeValue("lives", lives);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		collectedManaOrbs = jsonData.get("mana_orbs").asInt();
		lives = jsonData.get("lives").asInt();
	}
}
