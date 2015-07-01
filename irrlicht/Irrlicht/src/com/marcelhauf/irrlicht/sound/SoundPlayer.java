package com.marcelhauf.irrlicht.sound;

import com.badlogic.gdx.audio.Sound;
import com.marcelhauf.irrlicht.world.Item;
import com.marcelhauf.irrlicht.world.events.ItemPickup;

public class SoundPlayer implements ItemPickup {

	private final Sound manaOrbPickupSound;
	private final Sound powerOrbPickupSound;
	
	public SoundPlayer(Sound manaOrbPickupSound, Sound powerOrbPickupSound) {
		this.manaOrbPickupSound = manaOrbPickupSound;
		this.powerOrbPickupSound = powerOrbPickupSound;
	}
	
	@Override
	public void onItemPickup(Item item) {
		switch(item.getType()) {
		case MANA:
			manaOrbPickupSound.play();
			break;
		case POWER:
			powerOrbPickupSound.play();
			break;
		}
	}
	
}
