class GeometricObject {
	Vertex velocity;
	Vertex corner;
	double width;
	double height;
	
	GeometricObject(Vertex corner, double width, double height) {
		this(new Vertex(0,0), corner, width, height);
	}
	
	GeometricObject(Vertex velocity, Vertex corner, double width, double height) {
		this.velocity = velocity;
		this.corner = corner;
		this.width = width;
		this.height = height;
	} 
	
	double size() {
		return width * height;
	}
	
	boolean isLargerThan(GeometricObject that) {
		return size() > that.size();
	}
	
	boolean isAbove(GeometricObject that) {
		return that.corner.y > corner.y + height;
	}
	
	boolean isUnderneath(GeometricObject that) {
		return that.corner.y + that.height < corner.y;
	}
	
	boolean isLeftOf(GeometricObject that) {
		return corner.x < that.corner.x;
	}
	
	boolean isRightOf(GeometricObject that) {
		return corner.x > that.corner.x;
	}
	
	boolean touches(GeometricObject that) {
		
		return corner.x <= that.corner.x+that.width && corner.x+width >= that.corner.x && corner.y <= that.corner.y + that.height && corner.y + height >= that.corner.y;
	}
	
	void move() {
		corner.x += velocity.x;
		corner.y += velocity.y;
	}
	
	@Override
	public String toString() {
		return "GeometricObject(corner:" + corner + ",width:" + width + ",height:" + height + ")";
	}
}
