package shape;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends AShape {
	/**
	 * x is width, y is height
	 */
	private Point size;

	public Rectangle(Point location, Point size) {
		super(location);
		this.size = size;
	}

	@Override
	public void paint(Graphics g) {
		Point loc = super.getLocation();
		g.drawRect(loc.x, loc.y, size.x, size.y);
	}
}
