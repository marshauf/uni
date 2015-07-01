package de.hsrm.cs.oose13;

import java.awt.Graphics;

public class GeometricObjectsScene implements CollisionScene {
	
	public int width;
	public int height;
	private GeometricObject[] objects;
	
	public GeometricObjectsScene(GeometricObject[] objs) {
		this.objects = objs;
	}
	
	public void move() {
		for (GeometricObject obj : objects) {
			obj.move();
		}
	}
	
	public void paintAll(Graphics g) {
		for (GeometricObject obj : objects)  {
			obj.paintMeTo(g);
		}
	}
	
	public void collisions() {
		for (GeometricObject obj : objects) {
			if (obj.corner.x < 0 || obj.corner.x + obj.width > getWidth()) {
				obj.velocity.x *= -1;
			}
			if (obj.corner.y < 0 || obj.corner.y + obj.height > getHeight()) {
				obj.velocity.y *= -1;
			}
		}
		for (int i = 0; i < objects.length; i++) {
			for (int j = i; j < objects.length; j++) {
				if (objects[i] != objects[j]) {
					if (objects[i].touches(objects[j])) {
						objects[i].velocity.scale(-1);
						objects[j].velocity.scale(-1);
					}
				}
			}
		}
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
}
