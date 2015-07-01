package com.marcelhauf.irrlicht.world;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Enemy extends PhysicsObject implements Serializable, CollideableObject {
	public static final float enemyRadius = 16.0f;
	public static final float enemySize = enemyRadius * 2.0f;
	
	private final Random rand = new Random();
	private final Rectangle bounds = new Rectangle(-enemyRadius, -enemyRadius, enemySize, enemySize);
	
	@Override
	public void update(float deltaTime) {
		velocity.x += acceleration.x * deltaTime;
		velocity.y += acceleration.y * deltaTime;
		
		setPosition(position.add(velocity.cpy().scl(deltaTime)));
		
		if (velocity.x == 0.0f && velocity.y == 0.0f) {
			moveRandom();			
		}
	}
	
	private void moveRandom() {
		Vector2 dir = new Vector2(1.0f - rand.nextFloat() * 2.0f, 1.0f - rand.nextFloat() * 2.0f);
		dir.nor();
		float speed = 100.0f;
		setVelocity(dir.scl(speed));
	}
	
	@Override
	public void write(Json json) {
		json.writeValue("x", position.x);
		json.writeValue("y", position.y);
	}
	@Override
	public void read(Json json, JsonValue jsonData) {
		setPosition(new Vector2(jsonData.get("x").asFloat() - enemyRadius, position.y = jsonData.get("y").asFloat() - enemyRadius));
	}
	
	@Override
	public void setPosition(Vector2 value) {
		super.setPosition(value);
		bounds.setCenter(value);
	}
	
	@Override
	public Rectangle getBounds(Rectangle bounds) {
		return bounds.set(this.bounds);
	}
	
	// TODO Enemy type t with AI a
}
