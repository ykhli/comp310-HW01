package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends AShape {
	private int radius;

	public Circle(Point location, int radius, Color color) {
		super(location, color);
		this.radius = radius;
	}

	@Override
	public void paint(Graphics g) {
		Point loc = super.getLocation();
		g.setColor(super.getColor());
		g.drawOval(loc.x, loc.y, radius, radius);
	}
}
