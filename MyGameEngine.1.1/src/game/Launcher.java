package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.display.Display;
import game.display.Sprite;

public class Launcher extends Canvas implements Runnable{
	
	Display display = new Display();
	
	private BufferStrategy bs;
	private Graphics g;
	Launcher(){
		
		run();
	}
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Sprite image = new Sprite("icon.png", 33,33,65,65);
		image.draw(getGraphics());
		bs.show();
		
		
	}
	
	public static void main(String[] args) {
		Sprite image;
		image = new Sprite("icon.png", 43,43, 100, 100);
		
		Display display = new Display();
	
	}

	@Override
	public void run() {
		
		while(true) {
			System.out.println("run");
			render();
		}
		
	}
	
	
	
}








// %