package drawing.view;

import javax.swing.*;
import drawing.controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel
{
	private SpringLayout baseLayout;
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
	private JButton rectangleButton;
	private JButton triangleButton;
	private JButton circleButton;
	private JButton ellipseButton;
	private JButton polygonButton;
	private JButton resetButton;
	private DrawingController baseController;

	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		graphPanel = new GraphPanel();
		shapePanel = new ShapePanel(baseController);
		rectangleButton = new JButton("Draw rectangles");
		triangleButton = new JButton("Draw triangles");
		circleButton = new JButton("Draw circles");
		ellipseButton = new JButton("Draw ellipse");
		polygonButton = new JButton("Draw polygon");
		resetButton = new JButton("Reset");
		

		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.setMinimumSize(new Dimension(600, 600));
		
		this.add(rectangleButton);
		this.add(triangleButton);
		this.add(circleButton);
		this.add(ellipseButton);
		this.add(polygonButton);
		this.add(resetButton);
		this.add(shapePanel);
		this.add(graphPanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, -533, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 6, SpringLayout.SOUTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, 191, SpringLayout.SOUTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 221, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 26, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 11, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, triangleButton, 12, SpringLayout.SOUTH, rectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, circleButton, 6, SpringLayout.SOUTH, triangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 0, SpringLayout.SOUTH, resetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, resetButton, 6, SpringLayout.SOUTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 35, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, polygonButton, 6, SpringLayout.SOUTH, ellipseButton);
		baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, ellipseButton, 6, SpringLayout.SOUTH, circleButton);
		baseLayout.putConstraint(SpringLayout.WEST, ellipseButton, 0, SpringLayout.WEST, rectangleButton);
	}
	
	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangles();
			}
				});
		
		triangleButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangles();
			}
				});
		
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircles();
			}
		});
	
		
		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipses();
			}
		});
	
		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygons();
			}
		});
		
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.reset();
			}
		});
	
	}

}
