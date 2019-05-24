package game.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.classes.GameImage;

public class Entity {
	
	
	public int heightMask;
	public int whidthMask;
	protected String ID;
	
	protected double x;
	protected double y;
	protected int width;
	protected int height;

	GameImage image;

	public Entity(int x, int y, int width, int heigh, GameImage name) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}
	
	public double calculateDistance( int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1 - x2) * ( x1 - x2) + ( y1 - y2) * ( y1 - y2)  );
	}
	
	public void tick() {
		
		
	}
	
	public void render(Graphics g) {
		
	}
	
	public String getID() {
		return ID;
	}
	
	
	
	public void setID(String iD) {
		ID = iD;
	}

	public double getX() {
		return x;
	}



	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}





}
