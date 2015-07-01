package de.hsrm.cs.oose13;

public class GeometricObject {
	public Vertex velocity;
	public Vertex corner;
	public double width;
	public double height;
	
	public GeometricObject(Vertex corner, double width, double height) {
		this(new Vertex(0,0), corner, width, height);
	}
	
	public GeometricObject(Vertex velocity, Vertex corner, double width, double height) {
		this.velocity = velocity;
		this.corner = corner;
		this.width = width;
		this.height = height;
	} 
	
	public double size() {
		return width * height;
	}
	
	public boolean isLargerThan(GeometricObject that) {
		return size() > that.size();
	}
	
	public boolean isAbove(GeometricObject that) {
		return that.corner.y > corner.y + height;
	}
	
	public boolean isUnderneath(GeometricObject that) {
		return that.corner.y + that.height < corner.y;
	}
	
	public boolean isLeftOf(GeometricObject that) {
		return corner.x < that.corner.x;
	}
	
	public boolean isRightOf(GeometricObject that) {
		return corner.x > that.corner.x;
	}
	
	public boolean touches(GeometricObject that) {
		
		return corner.x <= that.corner.x+that.width && corner.x+width >= that.corner.x && corner.y <= that.corner.y + that.height && corner.y + height >= that.corner.y;
	}
	
	public void move() {
		corner.x += velocity.x;
		corner.y += velocity.y;
	}
	
	@Override
	public String toString() {
		return "GeometricObject(velocity:" + velocity + "corner:" + corner + ",width:" + width + ",height:" + height + ")";
	}
}