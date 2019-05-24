package game.classes;

import java.awt.Graphics;
import java.util.ArrayList;

public class Sprite extends Elements{

	
	private ArrayList<GameImage> sprite = new ArrayList<>();
	
	private int frames = 0, maxFrames, index = 0;

//	private int x, y, width, height;

	
	public Sprite( int x, int y, int width, int height, int maxFrames) {
		super.x = x;
		super.y = y;
		super.width = width;
		super.height = height;
		this.maxFrames = maxFrames;
	}
	
	
	public void AddSprite( String name) {
		
		sprite.add( new GameImage( name, x , y , width, height ));
		
	}
	
	public void tick() {
		
	}
	
	@Override
	public void moveX(double speed) {
		for( int index = 0; index < sprite.size(); index++) {
			sprite.get(index).moveX(speed);
		}
	}
	
	@Override
	public void moveY(double speed) {
		for( int index = 0; index < sprite.size(); index++) {
			sprite.get(index).moveY(speed);
		}
	}
	
	public void render(Graphics g, boolean isTrue) {
		
		if( isTrue ) {
			frames++;
			if( frames >= maxFrames) {
				frames = 0;
				index++;
				if ( index == sprite.size() ) {
					
					index = 0;
				}
			}
			sprite.get(index).render(g);
		}
		else {
			sprite.get( 0 ).render(g);
			
		}
	}
	
	
}
