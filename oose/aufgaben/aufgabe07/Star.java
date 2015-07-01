package de.hsrm.cs.oose13;

import java.awt.Graphics;
import java.awt.Polygon;

public class Star extends GeometricObject {
	
	public int rays;
	
	// rays >= 0
	public Star(Vertex pos, double ir, double or, int rays) {
		super(new Vertex(0,0), pos, ir, or);
		if (rays < 0) {
			rays = -rays;
		}
		this.rays = rays;
	}
	
	@Override
	public String toString() {
		return "Star (velocity:" + velocity + " position:" + corner + ", inner radius:" + width + ", outer radius:" + height + ", rays:" + rays + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Star) {
			GeometricObject g = (GeometricObject)obj;
			Star s = (Star)obj;
			return super.equals(g) && rays == s.rays;
		}
		return false;
	}
	
	private Polygon computePolygon() {
		int nPoints = 3 * rays;
		int[] xPoints = new int[nPoints];
		int[] yPoints = new int[nPoints];
		
		double slice = 2 * Math.PI / nPoints;
		double angle = 0;
		boolean drawInner = true;
		
		for (int i = 0; i < nPoints; i++) {
			angle = slice * i;
			if (drawInner) {
				xPoints[i] = (int)(corner.x + width * Math.cos(angle));
				yPoints[i] = (int)(corner.y + width * Math.sin(angle));
			} else {
				xPoints[i] = (int)(corner.x + height * Math.cos(angle));
				yPoints[i] = (int)(corner.y + height * Math.sin(angle));
			}
			drawInner = !drawInner;
		}
		return new Polygon(xPoints, yPoints, nPoints);
	}
	
	@Override
	public void paintMeTo(Graphics g) {
		// computePolygon could be cached, to avoid recalculation of the same object
		g.fillPolygon(computePolygon());
	}
}