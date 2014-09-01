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
import java.util.ArrayList;

import javax.swing.JTextField;

import shape.AShape;
import shape.Circle;
import shape.CompositeShape;
import shape.Rectangle;

public class MainFrame extends JFrame {
	// All the shapes to be painted
	private ArrayList<AShape> shapesToPaint = new ArrayList<AShape>() {
		private static final long serialVersionUID = -5115571127496690007L;
	{
		// Initialize a circle to paint
		add(new Circle(new Point(150, 150), 20, Color.BLUE));
	}};
	private static final long serialVersionUID = 6609680027612102654L;
	private JPanel contentPane;
	private final JPanel centerPanel = new JPanel(){
		private static final long serialVersionUID = -872444218515942499L;

		/**
		* Overridden paintComponent method to paint a shape in the panel.
		* @param g The Graphics object to paint on.
		**/
		public void paintComponent(Graphics g) {
		    super.paintComponent(g);   // Do everything normally done first, e.g. clear the screen.
		    g.setColor(Color.RED);  // Set the color to use when drawing
		    g.fillOval(75, 100, 20, 40);  // paint a filled 20x40 red ellipse whose upper left corner is at (75, 100)
		    // Paint all the shapes
		    for(AShape shape: shapesToPaint) {
		    	shape.paint(g);
		    }
		}
	};
	private final JPanel northPanel = new JPanel();
	private final JLabel northLabel = new JLabel("What up");
	private final JButton northButton = new JButton("Click");
	private final JTextField northTextField = new JTextField();
	private final JPanel southPanel = new JPanel();
	private final JButton btnChangeRect = new JButton("Change to Rectangle");
	private final JButton btnShowCompositeShape = new JButton("Show Composite Shape");

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
				// Get the input text
				String inputText = northTextField.getText();
				// Set the label the same as the input text
				northLabel.setText(inputText);
			}
		});
		
		northPanel.add(northButton);
		southPanel.setBackground(Color.BLACK);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		btnChangeRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Substitute the circle with a rectangle and repaint
				AShape someShape = new Rectangle(new Point(150, 150), new Point(20, 30), Color.CYAN);
				shapesToPaint.set(0, someShape);
				centerPanel.repaint();
			}
		});
		btnShowCompositeShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Build Olympic rings
				AShape blueCircle = new Circle(new Point(0,0), 30, Color.BLUE);
				AShape blackCircle = new Circle(new Point(40,0), 30, Color.BLACK);
				AShape combo = new CompositeShape(blueCircle, blackCircle);
				
				AShape redCircle = new Circle(new Point(80,0), 30, Color.RED);
				AShape combo2 = new CompositeShape(redCircle, combo);
				
				AShape yellowCircle = new Circle(new Point(20,15), 30, Color.YELLOW);
				AShape combo3 = new CompositeShape(yellowCircle, combo2);
				
				AShape greenCircle = new Circle(new Point(60,15), 30, Color.GREEN);
				AShape combo4 = new CompositeShape(greenCircle, combo3);
				
				// Add the olympic rings to the shapes to paint
				shapesToPaint.add(combo4);
				centerPanel.repaint();
			}
		});
		
		southPanel.add(btnShowCompositeShape);
		southPanel.add(btnChangeRect);
	}

	private void start(){
		setVisible(true);
	}
}
