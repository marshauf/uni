package com.marcelhauf.irrlicht.world.map;

import java.util.HashMap;

public class Cell {
	public enum Model {
		WALL('W'), EMPTY_FLOOR(' ');
		
		private char rawCellChar;
		
		private Model(char rawCellChar) {
			this.rawCellChar = rawCellChar;
		}
		
		public char getRawCellChar() {
			return rawCellChar;
		}
		
		private static HashMap<Character, Model> codeToModelMapping;
		
		 private static void initMapping() {
	        codeToModelMapping = new HashMap<Character, Model>();
	        for (Model s : values()) {
	            codeToModelMapping.put(s.rawCellChar, s);
	        }
	    }
		
		public static Model getModel(char c) {
			if (codeToModelMapping == null) { 
				initMapping();
			}
			return codeToModelMapping.get(c);
		}
	}
	
	private Cell.Model model;
	
	public Cell(Cell.Model t) {
		this.model = t;
	}
	
	public Cell.Model getModel() { return model; }
}
