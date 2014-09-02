package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * A composite shape 
 */
public class CompositeShape extends AShape {

	private AShape shapeA;
	private AShape shapeB;

	/**
	 * Constructor
	 * @param shapeA the first AShape object
	 * @param shapeB the second AShape object
	 */
	public CompositeShape(Point location, Color color, AShape shapeA, AShape shapeB) {
		super(location, color);
		this.shapeA = shapeA;
		this.shapeB = shapeB;
	}

	/**
	 * Constructor two
	 * @param shapeA the first AShape object
	 * @param shapeB the second AShape object
	 */
	public CompositeShape(AShape shapeA, AShape shapeB) {
		super(null, null);
		this.shapeA = shapeA;
		this.shapeB = shapeB;
	}

	@Override
	public void paint(Graphics g) {
		/**
		 * Paint each of the two AShape objects
		 */
		shapeA.paint(g);
		shapeB.paint(g);
	}
}
