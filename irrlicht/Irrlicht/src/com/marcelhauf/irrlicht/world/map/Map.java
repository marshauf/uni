package com.marcelhauf.irrlicht.world.map;

import com.marcelhauf.irrlicht.math.Size;

public class Map {
	
	private Cell[][] cells;
	
	public Map(String rawMapData) {
		Size size = computeMapSize(rawMapData);
		this.cells = new Cell[size.height][];
		for(int i = 0; i < this.cells.length; i++) {
			this.cells[i] = new Cell[size.width];
		}
		populateMap(rawMapData, this.cells);
	}
	
	public Cell[][] getCells() { return cells; }
	
	private static String lineSeparator = System.getProperty("line.separator");
	
	private static void populateMap(String rawMapData, Cell[][] map) {
		int x = 0;
		int y = 0;
		char c = ' ';
		for(int i = 0; i < rawMapData.length(); i++) {
			c = rawMapData.charAt(i);
			if (c == lineSeparator.charAt(0)) {
				x = 0;
				y++;
			} else {
				map[y][x] = new Cell(Cell.Model.getModel(c));
				x++;
			}
		}
	}
	
	private static Size computeMapSize(String rawMapData) {
		int width = 0;
		int height = 1;
		int tmpWidth = 0;
		for(int i = 0; i < rawMapData.length(); i++) {
			if (rawMapData.substring(i, i + 1).equals(lineSeparator)) {
				if (tmpWidth > width) {
					width = tmpWidth;
				}
				tmpWidth = 0;
				height++;
			} else {
				tmpWidth++;
			}
		}
		return new Size(width, height);
	}
}
