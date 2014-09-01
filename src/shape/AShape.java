package shape;

import java.awt.Graphics;
import java.awt.Point;

public abstract class AShape {
	private Point location;

	public Point getLocation() {
		return location;
	}
	
	public AShape(Point location) {
		this.location = location;
	}

	public abstract void paint(Graphics g);
}
