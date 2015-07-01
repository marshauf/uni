package com.marcelhauf.irrlicht.world;

import java.util.EnumSet;
import java.util.Iterator;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Player extends PhysicsObject implements CollideableObject, Serializable {
	public enum Command {
		MoveNone,
		MoveUp,
		MoveDown,
		MoveLeft,
		MoveRight,
	}
	public String name = "";
	
	public final EnumSet<Command> cmds = EnumSet.noneOf(Command.class);
	
	private float speed = 10.0f;
	private final Vector2 dir = new Vector2();
	private final Rectangle bounds = new Rectangle();
	public final Score score = new Score();
	private float timeLeftOnEmpowered = 0.0f; // in seconds
	
	public float getTimeLeftOnEmpowered() { return timeLeftOnEmpowered; }
	public boolean isEmpowered() { return timeLeftOnEmpowered > 0.0f; }
	public void empower(float time) {
		timeLeftOnEmpowered += time;
	}
	
	public Player(Vector2 startPosition) {
		bounds.width = 4;
		bounds.height = 4;
		setPosition(startPosition);
	}
	
	@Override
	public void update(float deltaTime) {
		// Compute player input direction
		if (cmds.isEmpty() == false) {
			dir.x = 0;
			dir.y = 0;
			if (cmds.contains(Command.MoveUp)) {
				dir.y += 1;
			}
			if (cmds.contains(Command.MoveDown)) {
				dir.y -= 1;
			}
			if (cmds.contains(Command.MoveLeft)) {
				dir.x -= 1;
			}
			if (cmds.contains(Command.MoveRight)) {
				dir.x += 1;
			}
			dir.nor();
			// Set the velocity of the player object to the direction * speed
			// This enables immediate turns
			super.setVelocity(dir.scl(speed));
			
			super.position.x += velocity.x * deltaTime;
			super.position.y += velocity.y * deltaTime;
			bounds.setCenter(super.position);
			
			System.out.println(position.toString());
		}
		
		if (timeLeftOnEmpowered > 0.0f) {
			timeLeftOnEmpowered -= deltaTime;
			if (timeLeftOnEmpowered < 0.0f) {
				timeLeftOnEmpowered = 0.0f;
			}
		}
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

	@Override
	public void write(Json json) {
		json.writeValue("name", name);
		
		json.writeObjectStart("dir");
		json.writeValue("x", dir.x);
		json.writeValue("y", dir.y);
		json.writeObjectEnd();
		
		json.writeValue("speed", speed);
		
		json.writeObjectStart("bounds");
		json.writeValue("x", bounds.x);
		json.writeValue("y", bounds.y);
		json.writeValue("width", bounds.width);
		json.writeValue("height", bounds.height);
		json.writeObjectEnd();
		
		json.writeObjectStart("score");
		score.write(json);
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		Iterator<JsonValue> iter = jsonData.iterator();
		JsonValue value;
		while(iter.hasNext()) {
			value = iter.next();
			switch(value.name()) {
			case "name":
				name = value.asString();
				break;
			case "dir":
				dir.x = value.get("x").asFloat();
				dir.y = value.get("x").asFloat();
				break;
			case "speed":
				speed = value.asFloat();
				break;
			case "bounds":
				bounds.width = value.getFloat("width");
				bounds.height = value.getFloat("height");
				setPosition(new Vector2(value.getFloat("x") + bounds.width / 2,value.getFloat("y") + bounds.height / 2));
				break;
			case "score":
				score.read(json, value);
				break;
			}
		}
	}
}
