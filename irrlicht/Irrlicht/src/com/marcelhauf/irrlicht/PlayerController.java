package com.marcelhauf.irrlicht;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.marcelhauf.irrlicht.world.Player;
import com.marcelhauf.irrlicht.world.Player.Command;

public class PlayerController implements InputProcessor {

	private Player player;
	
	public PlayerController(Player player) {
		this.player = player; 
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		case Input.Keys.W:
			player.cmds.add(Command.MoveUp);
			return true;
		case Input.Keys.A:
			player.cmds.add(Command.MoveLeft);
			return true;
		case Input.Keys.S:
			player.cmds.add(Command.MoveDown);
			return true;
		case Input.Keys.D:
			player.cmds.add(Command.MoveRight);
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
		case Input.Keys.W:
			player.cmds.remove(Command.MoveUp);
			return true;
		case Input.Keys.A:
			player.cmds.remove(Command.MoveLeft);
			return true;
		case Input.Keys.S:
			player.cmds.remove(Command.MoveDown);
			return true;
		case Input.Keys.D:
			player.cmds.remove(Command.MoveRight);
			return true;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
