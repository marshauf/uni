package com.marcelhauf.irrlicht.world;

import com.badlogic.gdx.math.Vector2;

public class PhysicsObject {
	protected final Vector2 acceleration = new Vector2(0,0);
	protected final Vector2 position = new Vector2(0,0);
	protected final Vector2 velocity = new Vector2(0,0);
	
	public Vector2 getAcceleration(Vector2 value) { return value.set(acceleration); }
	public Vector2 getPosition(Vector2 value) { return value.set(position); }
	public Vector2 getVelocity(Vector2 value) { return value.set(velocity); }
	
	public void setAcceleration(Vector2 value) { acceleration.set(value); }
	
	// Sets the center position of the physics object.
	public void setPosition(Vector2 value) { position.set(value); }
	public void setVelocity(Vector2 value) { velocity.set(value); }
	
	/* Velocity Verlet
	private final Vector2 lastPosition = new Vector2();
	private final Vector2 nextPosition = new Vector2();
	*/
	
	public void update(float deltaTime) {
		// Euler method to calculate motion over time
		velocity.x += acceleration.x * deltaTime;
		velocity.y += acceleration.y * deltaTime;
		
		position.x += velocity.x * deltaTime;
		position.y += velocity.y * deltaTime;
		
		
		// Velocity Verlet integration, second degree 
		/*
		velocity.x = position.x - lastPosition.x;
		velocity.y = position.y - lastPosition.y;
		
		nextPosition.x = position.x +  velocity.x + acceleration.x * deltaTime;
		nextPosition.y = position.y +  velocity.y + acceleration.y * deltaTime;
		
		lastPosition.set(position);
		position.set(nextPosition);
		*/
	}
}
