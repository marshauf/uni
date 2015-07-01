package de.hsrm.cs.oose13;

public class TestShowMoveable {
	public static void main(String[] args) {
		Circle c = new Circle(new Vertex(25,100), 100);
		ShowMoveable sm = new ShowMoveable(c);
		sm.show();
		
		Ellipse e = new Ellipse(new Vertex(50,150), 100, 25);
		ShowMoveable sm2 = new ShowMoveable(e);
		sm2.show();
		
		GeometricObject geo = new GeometricObject(new Vertex(50,150), 100, 25);
		ShowMoveable sm3 = new ShowMoveable(geo);
		sm3.show();
		
		Star s = new Star(new Vertex(100,100), 20, 50, 7);
		ShowMoveable sm4 = new ShowMoveable(s);
		sm4.show();
	}
}