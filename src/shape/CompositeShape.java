package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class CompositeShape extends AShape {
	private ArrayList<AShape> shapeList;
	public CompositeShape(Point location, Color color) {
		super(location, color);
		shapeList = new ArrayList<>();
	}

	
	
	public void addShape(AShape shape) {
		shapeList.add(shape);
	}
	
	public void removeShape(AShape shape) {
		shapeList.remove(shapeList.size()-1);
	}

	@Override
	public void paint(Graphics g) {
		for(AShape shape: shapeList){
			shape.paint(g);			
		}		
	}
	
}
