package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * A rectangle shape
 */
public class Rectangle extends AShape {
	// x is width, y is height
	private Point size;

	/**
	 * Constructor
	 * @param location the location of the rectangle
	 * @param size the size of the rectangle
	 * @param color the color of the rectangle
	 */
	public Rectangle(Point location, Point size, Color color) {
		super(location, color);
		this.size = size;
	}

	@Override
	public void paint(Graphics g) {
		// Paint the rectangle at the specified location with the specified color and size
		Point loc = super.getLocation();
		g.setColor(super.getColor());
		g.drawRect(loc.x, loc.y, size.x, size.y);
	}
}
