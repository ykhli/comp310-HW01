package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends AShape {
	/**
	 * x is width, y is height
	 */
	private Point size;

	public Rectangle(Point location, Point size, Color color) {
		super(location, color);
		this.size = size;
	}

	@Override
	public void paint(Graphics g) {
		Point loc = super.getLocation();
		g.setColor(super.getColor());
		g.drawRect(loc.x, loc.y, size.x, size.y);
	}
}
