package de.hsrm.cs.oose13;

public class Circle extends Ellipse {
	
	public Circle(Vertex corner, double d) {
		super(new Vertex(0,0), corner, d, d);
	}
	
	@Override
	public String toString() {
		return "Circle (velocity:" + velocity + " corner:" + corner + ",d:" + width + ")";
	}
}