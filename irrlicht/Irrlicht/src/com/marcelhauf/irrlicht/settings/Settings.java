package com.marcelhauf.irrlicht.settings;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Settings implements Serializable{

	public boolean music = true;
	public boolean vsync = false;
	
	@Override
	public void write(Json json) {
		json.writeValue("music", music);
		json.writeValue("vsync", vsync);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		music = jsonData.getBoolean("music");
		vsync = jsonData.getBoolean("vsync");
	}
}
