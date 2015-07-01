package de.hsrm.cs.oose13;

import de.hsrm.cs.oose13.util.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.*;

public class Labyrinth extends JPanel {
	private static double rectangleLength = 20;
	private static final char rectangleChar = 'W';
	private static final char spaceChar = ' ';

	private GeometricObject[] objects;

	private int width;
	private int height;
	
	public Labyrinth(String fileName) throws Exception {
		List<GeometricObject> objs = new ArrayList<GeometricObject>();
		String[] lines = FileUtil.readTextLines(fileName);
		int nRect = 0;
		int nSpace = 0;
		int maxWidth = 0;
		for (int y = 0; y < lines.length; y++) {
			char[] line = lines[y].toCharArray();
			if (maxWidth < line.length) { maxWidth = line.length; }
			for(int x = 0; x < line.length; x++) {
				switch (line[x]) {
				case rectangleChar:
					objs.add(new GeometricObject(new Vertex(rectangleLength * x, rectangleLength * y), rectangleLength, rectangleLength));
					nRect++;
					break;
				case spaceChar:
					nSpace++;
					break;
				default:
					throw new Exception("Unsupported char:" + line[x] + " in file:" + fileName);
				}
			}
		}
		this.objects = objs.toArray(new GeometricObject[0]);
		this.width = maxWidth * (int)rectangleLength;
		this.height = lines.length * (int)rectangleLength;
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(GeometricObject obj : objects) obj.paintMeTo(g);
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			printHelp();
			return;
		}
		if (args[0] == "-h" || args[0] == "--help") {
			printHelp();
			return;
		}
		try{
			Labyrinth labyrinth = new Labyrinth(args[0]);
			System.out.println("Labyrinth width: " + labyrinth.getWidth() + " height: " + labyrinth.getHeight());
			JFrame f = new JFrame();
			f.add(labyrinth);
			f.pack();
			f.setVisible(true);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private static void printHelp() {
		System.out.println("Labyrinth - Copyright Marcel Hauf");
		System.out.println("usage: de.hsrm.cs.oose13.Labyrinth file \tparse specified file");
	}
}
