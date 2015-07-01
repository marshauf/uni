package com.marcelhauf.irrlicht.world;

import java.util.HashMap;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Item extends PhysicsObject implements Serializable, CollideableObject {
	
	public final static float manaOrbRadius = 16.0f;
	public final static float manaOrbSize = manaOrbRadius * 2.0f;
	public final static float powerOrbRadius = 16.0f;
	public final static float powerOrbSize = powerOrbRadius * 2.0f;
	
	public enum ItemType {
		NONE("NONE"), MANA("MANA"), POWER("POWER");
		
		private String value;
		
		private ItemType(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
		
		private static HashMap<String, ItemType> codeToItemTypeMapping;
		
		 private static void initMapping() {
			 codeToItemTypeMapping = new HashMap<String, ItemType>();
	        for (ItemType s : values()) {
	        	codeToItemTypeMapping.put(s.value, s);
	        }
	    }
		
		public static ItemType parseItemType(String v) {
			if (codeToItemTypeMapping == null) { 
				initMapping();
			}
			return codeToItemTypeMapping.get(v);
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
	
	private final Rectangle bounds = new Rectangle();
	private ItemType type;
	
	public Item() {
		this(ItemType.NONE);
	}
	
	public Item(ItemType t) {
		setType(t);
	}
	
	public void setType(ItemType t) {
		type = t;
		switch (type) {
		case MANA: case POWER:
			bounds.setSize(manaOrbSize, manaOrbSize);
			return;
		case NONE:
		default:
		}
	}
	
	public ItemType getType() { return type; }
	
	@Override
	public void update(float deltaTime) {}
	
	@Override
	public void write(Json json) {
		json.writeValue("x", position.x);
		json.writeValue("y", position.y);
		json.writeValue("type", type.toString());
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		setType(ItemType.parseItemType(jsonData.get("type").asString()));
		setPosition(new Vector2(position.x = jsonData.get("x").asFloat() - bounds.width / 2, position.y = jsonData.get("y").asFloat() - bounds.height / 2));
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
	
}
