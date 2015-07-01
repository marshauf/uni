package com.marcelhauf.irrlicht.renderer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Disposable;
import com.marcelhauf.irrlicht.world.map.Cell;
import com.marcelhauf.irrlicht.world.map.Map;
import com.marcelhauf.irrlicht.world.map.Cell.Model;

public class MapRenderer {
	
	private TextureRegion floor;
	private TextureRegion wall;
	private Map map;
	
	public MapRenderer(Map map, TextureRegion floor, TextureRegion wall) {
		this.map = map;
		this.floor = floor;
		this.wall = wall;
	}
	
	public void addToBatch(SpriteBatch batch) {
		Cell[][] cells = map.getCells();
		
		float cellRadius = 32; 
		float cellSize = cellRadius * 2;
		float x = 0;
		float y = 0;
				
		for(int n = 0; n < cells.length; n++) {
			Cell[] hCells = cells[n];
			for(int m = 0; m < hCells.length; m++) {
				Cell.Model t = hCells[m].getModel();
				x = m * cellSize;
				y = n * cellSize;
				switch (t) {
				case WALL:
					Sprite wallSprite = new Sprite(wall);
					wallSprite.setBounds(x - cellRadius, y - cellRadius, cellSize, cellSize);
					wallSprite.draw(batch);
					break;
				case EMPTY_FLOOR:	
					Sprite floorSprite = new Sprite(floor);
					floorSprite.setBounds(x - cellRadius, y - cellRadius, cellSize, cellSize);
					floorSprite.draw(batch);
					break;
				}
			}
		}
	}
}
