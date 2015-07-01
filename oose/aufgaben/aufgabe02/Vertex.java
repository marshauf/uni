class Vertex {
	protected double x;
	protected double y;
	Vertex(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	void move(Vertex v) {
		x += v.x;
		y += v.y;
	}
	
	void moveTo(Vertex v) {
		x = v.x;
		y = v.y;
	}

	@Override
	public String toString() {
		return "Vertex(x:" + x + ",y:" + y + ")";
	}
}
