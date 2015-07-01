package de.hsrm.cs.oose13;

public class Vertex {
	public double x;
	public double y;
	
	public Vertex(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(Vertex v) {
		x += v.x;
		y += v.y;
	}
	
	public void moveTo(Vertex v) {
		x = v.x;
		y = v.y;
	}

	@Override
	public String toString() {
		return "Vertex(x:" + x + ",y:" + y + ")";
	}
}
