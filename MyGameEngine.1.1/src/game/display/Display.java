package game.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	JFrame frame;
	Canvas canvas;
	
	private int width;
	private int height;
	private String title = "Game Engine";
	
	public Display(){
		
		createDisplay();
	}
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	public void createDisplay() {
		frame = new JFrame();
		frame.setSize(640, 480);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle(title);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
//		frame.add(canvas);
//		frame.pack();
		
	}

}
