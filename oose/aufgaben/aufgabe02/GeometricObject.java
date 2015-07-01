class GeometricObject {
	Vertex corner;
	double width;
	double height;
	
	GeometricObject(Vertex corner, double width, double height) {
		this.corner = corner;
		this.width = width;
		this.height = height;
	} 
	
	@Override
	public String toString() {
		return "GeometricObject(corner:" + corner + ",width:" + width + ",height:" + height + ")";
	}
}
