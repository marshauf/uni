package de.hsrm.cs.oose13;

import java.awt.Graphics;

public interface CollisionScene {
	void collisions();
	void move();
	void paintAll(Graphics g);
	
	int getWidth();
	int getHeight();
}