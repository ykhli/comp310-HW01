package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Abstract class of shape
 */
public abstract class AShape {
	// The location of the shape
	private Point location;
	// The color of the shape
	private Color color;

	/**
	 * Location getter
	 * @return the location of the shape
	 */
	public Point getLocation() {
		return location;
	}
	
	/**
	 * Color getter
	 * @return the color of the shape
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Constructor
	 * @param location: the location of the shape
	 * @param color: the color of the shape
	 */
	public AShape(Point location, Color color) {
		this.location = location;
		this.color = color;
	}

	/**
	 * Paint the shape on the canvas
	 * @param g The Graphics object to paint on.
	 */
	public abstract void paint(Graphics g);
}
