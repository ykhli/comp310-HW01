package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * An oval shape
 */
public class Oval extends AShape{
	/**
	 * Point(x,y), in which x is defined as width, and y as height
	 */
	private Point size;
	
	/**
	 * Constructor
	 * @param location the location of the oval
	 * @param size the size of the oval. x is width, y is height
	 * @param color the color of the oval
	 */
	public Oval(Point location, Point size, Color color) {
		super(location, color);
		this.size = size;
	}

	@Override
	public void paint(Graphics g) {
		/**
		 * Paint the oval at the specified location with the specified color and size
		 */
		Point loc = super.getLocation();
		g.setColor(super.getColor());
		g.fillOval(loc.x, loc.y, size.x, size.y);
	}
}
