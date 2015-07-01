package com.marcelhauf.irrlicht;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class ObserverController implements InputProcessor {

	private Vector2 position;
	private float zoom = 1.0f;
	private float zoomMax = 2.0f;
	private float zoomMin = 0.5f;
	private float zoomDelta = 0.25f;
	
	public ObserverController(Vector2 startPosition) {
		position = startPosition;
	}
	
	public Vector2 getPosition() { return position; }
	public float getZoom() { return zoom; }
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	private Vector2 lastPosition = new Vector2();
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		lastPosition.x = screenX;
		lastPosition.y = screenY;
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		Vector2 pos = new Vector2(screenX, screenY);
		Vector2 delta = pos.sub(lastPosition);
		delta = delta.scl(zoom);
		delta.y = -delta.y;
		position = position.add(delta);
		return true;
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
		zoom += zoomDelta * amount;
		if (zoom < zoomMin) {
			zoom = zoomMin;
		} else if (zoom > zoomMax) {
			zoom = zoomMax;
		}
		return true;
	}

}
