package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import shape.AShape;
import shape.Circle;
import shape.CompositeShape;
import shape.Oval;
import shape.Rectangle;

public class MainFrame extends JFrame {
	/**
	 * shapesToPaint contains all the shapes to be painted
	 */
	private AShape shapeToPaint = new Circle(new Point(150, 150), 20, Color.BLUE);
	/**
	 * The position of the shape to paint
	 */
	private Point shapePosition = new Point(150, 150);
	private static final long serialVersionUID = 6609680027612102654L;
	private JPanel contentPane;
	private final JPanel centerPanel = new JPanel(){
		private static final long serialVersionUID = -872444218515942499L;

		/**
		* Overridden paintComponent method to paint a shape in the panel.
		* @param g The Graphics object to paint on.
		**/
		public void paintComponent(Graphics g) {
			/**
			 * Do everything normally done first, e.g. clear the screen.
			 */
		    super.paintComponent(g);   
		    
			/**
			 * Set the color to use when drawing
			 */
		    g.setColor(Color.RED);
			/**
			 * Paint a filled 20x40 red ellipse whose upper left corner is at (75, 100)
			 */
		    g.fillOval(75, 100, 20, 40);  
			/**
			 * Paint all shapes
			 */
		    shapeToPaint.paint(g);
		}
	};
	private final JPanel northPanel = new JPanel();
	private final JLabel lblInput = new JLabel("Hello");
	private final JButton btnSetInput = new JButton("Click");
	private final JTextField txtNorth = new JTextField();
	private final JPanel southPanel = new JPanel();
	private final JButton btnRectangle = new JButton("Rectangle");
	private final JButton btnFiveRings = new JButton("5 Rings");
	private final JButton btnCircle = new JButton("Circle");
	private final JButton btnOval = new JButton("Oval");
	private final JTextField txtPosition = new JTextField();
	private final JLabel lblCurrentPosition = new JLabel("(150, 150)");
	private final JButton btnSetPosition = new JButton("Set Position");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initGUI();
	}
	private void initGUI() {
		txtPosition.setText("e.g. \"20 30\"");
		txtPosition.setColumns(10);
		txtNorth.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		centerPanel.setToolTipText("This is a tool tip");
		centerPanel.setBackground(Color.ORANGE);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		centerPanel.add(txtPosition);
		
		centerPanel.add(lblCurrentPosition);
		btnSetPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the input position
				String positionInput = txtPosition.getText();
				// Process the input position and set it up
				String[] positionValues = positionInput.split("\\s+");
				if(positionValues.length != 2){
					lblCurrentPosition.setText("Invalid input");
					return;
				}else{
					try{
						shapePosition.setLocation(Integer.parseInt(positionValues[0]), Integer.parseInt(positionValues[1]));
					}catch(Exception ex){
						lblCurrentPosition.setText("Invalid input");
						return;
					}
					// If the input position is valid
					lblCurrentPosition.setText(String.format("(%d, %d)", shapePosition.x, shapePosition.y));
				}
			}
		});
		
		centerPanel.add(btnSetPosition);
		northPanel.setBackground(Color.BLACK);
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		northPanel.add(txtNorth);
		lblInput.setForeground(Color.WHITE);
		
		northPanel.add(lblInput);
		btnSetInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Get the input text
				 */
				String inputText = txtNorth.getText();
				/**
				 * Set the label to the same as the input text
				 */
				lblInput.setText(inputText);
			}
		});
		
		northPanel.add(btnSetInput);
		southPanel.setBackground(Color.BLACK);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Substitute the circle with a rectangle and repaint
				shapeToPaint = new Rectangle(shapePosition, new Point(20, 30), Color.CYAN);
				centerPanel.repaint();
			}
		});
		btnFiveRings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// The absolute location of the rings
				Point base = shapePosition;
				// The radius of each ring
				int radius = 30;
				
				/**
				 * Building the Olympic rings
				 */
				AShape blueCircle = new Circle(base, radius, Color.BLUE);
				AShape blackCircle = new Circle(new Point(base.x + 40, base.y), radius, Color.BLACK);
				AShape combo = new CompositeShape(blueCircle, blackCircle);
				
				AShape redCircle = new Circle(new Point(base.x + 80, base.y), radius, Color.RED);
				AShape combo2 = new CompositeShape(redCircle, combo);
				
				AShape yellowCircle = new Circle(new Point(base.x + 20, base.y + 15), radius, Color.YELLOW);
				AShape combo3 = new CompositeShape(yellowCircle, combo2);
				
				AShape greenCircle = new Circle(new Point(base.x + 60, base.y + 15), radius, Color.GREEN);
				AShape combo4 = new CompositeShape(greenCircle, combo3);
				
				/**
				 * Add Olympic rings to the shapes and paint them on the panel
				 */
				shapeToPaint = combo4;
				centerPanel.repaint();
			}
		});
		
		southPanel.add(btnFiveRings);
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Substitute the shape to paint with a circle and repaint the center panel
				shapeToPaint = new Circle(shapePosition, 20, Color.BLUE);
				centerPanel.repaint();
			}
		});
		
		southPanel.add(btnCircle);
		southPanel.add(btnRectangle);
		btnOval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Substitute the shape to paint with a oval and repaint the center panel
				shapeToPaint = new Oval(shapePosition, new Point(40, 20), Color.green);
				centerPanel.repaint();
			}
		});
		
		southPanel.add(btnOval);
	}

	private void start(){
		setVisible(true);
	}
}
