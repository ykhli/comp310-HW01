package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * A circle shape
 */
public class Circle extends AShape {
	/**
	 * The radius of circle
	 */
	private int radius;

	/**
	 * Constructor
	 * @param location the location of the circle
	 * @param radius the radius of the circle
	 * @param color the color of the circle
	 */
	public Circle(Point location, int radius, Color color) {
		super(location, color);
		this.radius = radius;
	}

	@Override
	public void paint(Graphics g) {
		/**
		 * Paint the circle at the specified location with the specified radius and color
		 */
		Point loc = super.getLocation();
		g.setColor(super.getColor());
		g.fillOval(loc.x, loc.y, radius, radius);
	}
}
