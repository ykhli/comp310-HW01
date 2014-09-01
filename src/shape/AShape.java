package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AShape {
	private Point location;
	private Color color;

	public Point getLocation() {
		return location;
	}
	
	public AShape(Point location, Color color) {
		this.location = location;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public abstract void paint(Graphics g);
}
