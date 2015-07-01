package de.hsrm.cs.oose13;

public class Ellipse extends GeometricObject {
	
	public Ellipse(Vertex corner, double a, double b) {
		super(new Vertex(0,0), corner, a, b);
	}
	
	public Ellipse(Vertex velocity, Vertex corner, double a, double b) {
		super(velocity, corner, a, b);
	}
	
	@Override
	public double size() {
		return Math.PI * width * height;
	}
	
	@Override
	public String toString() {
		return "Ellipse (velocity:" + velocity + " corner:" + corner + ",a:" + width + ",b:" + height + ")";
	}
}