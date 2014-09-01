package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class CompositeShape extends AShape {
	private AShape shapeA;
	private AShape shapeB;

	public CompositeShape(Point location, Color color, AShape shapeA, AShape shapeB) {
		super(location, color);
		this.shapeA = shapeA;
		this.shapeB = shapeB;
	}

	public CompositeShape(AShape shapeA, AShape shapeB) {
		super(null, null);
		this.shapeA = shapeA;
		this.shapeB = shapeB;
	}

	@Override
	public void paint(Graphics g) {
		shapeA.paint(g);
		shapeB.paint(g);
	}
}
