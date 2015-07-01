package de.hsrm.cs.oose13;

import javax.swing.*;

public class Test {
	public static void main(String[] args) {
		int width = 1280;
		int height = 720;
		
		int n = 10;
		double minWidth = 10;
		double minHeight = 10;
		double sizeAlternation = 40;
		double speed = 10;
		
		GeometricObject[] objects = new GeometricObject[n];
		for (int i = 0; i < n; i++) {
			objects[i] = new GeometricObject(
				new Vertex(Math.random() * speed, Math.random() * speed),
				new Vertex(Math.random() * width, Math.random() * height),
				minWidth + Math.random() * sizeAlternation,
				minHeight + Math.random() * sizeAlternation);
		}
		GeometricObjectsScene scene = new GeometricObjectsScene(objects);
		scene.width = width;
		scene.height = height;
		
		StartStopScenePanel panel = new StartStopScenePanel(scene);
		//ScenePanel panel = new ScenePanel(scene);
		
		JFrame f = new JFrame();
		f.add(panel);
		f.pack();
		f.setVisible(true);
	}
}