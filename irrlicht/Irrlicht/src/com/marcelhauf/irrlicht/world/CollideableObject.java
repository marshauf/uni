package com.marcelhauf.irrlicht.world;

import com.badlogic.gdx.math.Rectangle;

public interface CollideableObject {
	Rectangle getBounds(Rectangle bounds);
}