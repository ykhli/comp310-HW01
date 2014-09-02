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
	private final JLabel northLabel = new JLabel("What up");
	private final JButton northButton = new JButton("Click");
	private final JTextField northTextField = new JTextField();
	private final JPanel southPanel = new JPanel();
	private final JButton btnRectangle = new JButton("Rectangle");
	private final JButton btnFiveRings = new JButton("5 Rings");
	private final JButton btnCircle = new JButton("Circle");
	private final JButton btnOval = new JButton("Oval");

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
		northTextField.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		centerPanel.setToolTipText("This is a tool tip");
		centerPanel.setBackground(Color.ORANGE);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		northPanel.setBackground(Color.BLACK);
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		northPanel.add(northTextField);
		northLabel.setForeground(Color.WHITE);
		
		northPanel.add(northLabel);
		northButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Get the input text
				 */
				String inputText = northTextField.getText();
				/**
				 * Set the label to the same as the input text
				 */
				northLabel.setText(inputText);
			}
		});
		
		northPanel.add(northButton);
		southPanel.setBackground(Color.BLACK);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Substitute the circle with a rectangle and repaint
				shapeToPaint = new Rectangle(new Point(150, 150), new Point(20, 30), Color.CYAN);
				centerPanel.repaint();
			}
		});
		btnFiveRings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Building the Olympic rings
				 */
				
				// The absolute location of the rings
				Point base = new Point(150, 150);
				// The radius of each ring
				int radius = 30;
				
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
				shapeToPaint = new Circle(new Point(150, 150), 20, Color.BLUE);
				centerPanel.repaint();
			}
		});
		
		southPanel.add(btnCircle);
		southPanel.add(btnRectangle);
		btnOval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeToPaint = new Oval(new Point(150, 150), new Point(40, 20), Color.green);
				centerPanel.repaint();
			}
		});
		
		southPanel.add(btnOval);
	}

	private void start(){
		setVisible(true);
	}
}
