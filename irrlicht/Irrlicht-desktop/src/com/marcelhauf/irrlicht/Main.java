package com.marcelhauf.irrlicht;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Irrlicht";
		cfg.useGL20 = true; // If false problems arise with transformation matrices
		cfg.width = 480;
		cfg.height = 320;
		
		// Development only
		/*
		Settings mapImageSettings = new Settings();
		Settings objectsImageSettings = new Settings();
		TexturePacker2.process(objectsImageSettings, "../images/objects", "../Irrlicht-android/assets", "objects");
		TexturePacker2.process(mapImageSettings, "../images/map", "../Irrlicht-android/assets", "map");
		*/
		
		new LwjglApplication(new Irrlicht(), cfg);
	}
}
