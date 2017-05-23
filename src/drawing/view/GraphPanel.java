package drawing.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.ArrayList;

public class GraphPanel extends JPanel
{
	private int [] data;
	private int width;
	private ArrayList<Rectangle> graph;
	
	public GraphPanel()
	{
		data = new int[] {20, 36, 43, 125, 178};
		setupPanel();
	}
	
	private void setupPanel()
	{
		
	}
	
	@Override
	protected void paintComponent(Graphics basic)
	{
		super.paintComponent(basic);
		
		Graphics2D drawing = (Graphics2D) basic;
		
		for(int index = 0; index < data.length; index++)
		{
			int height = this.getHeight()/data.length;
			int width = data[index];
			int xPosition = 0;
			int yPosition = height * index;
			
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int alpha = (int) (Math.random() * 256);
			
			drawing.setColor(new Color(red, green, blue, alpha));
			
			drawing.fill(new Rectangle(xPosition, yPosition, width, height));
		}
	}
	
	public void setData(int [] data)
	{
		this.data = data;
		repaint();
	}
	
	public void sortData()
	{
		Arrays.sort(data);
		repaint();
	}
	

}
