package game.utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.classes.Imagen;
import game.tiles.Entity;
/**
 * @author Joicemar da Silva Morais
 * 07/05/2019  
 */

public class Collision {
	
	
	public boolean collisionCheck(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle( (int) e1.getX() , (int) e1.getY(),e1.heightMask,e1.whidthMask);
		Rectangle e2Mask = new Rectangle( (int) e2.getX() , (int) e2.getY(),e2.heightMask,e2.whidthMask);
		
		return e1Mask.intersects(e2Mask);
		
	}

	public boolean collisionCheck(Imagen e1, Imagen e2) {
		Rectangle e1Mask = new Rectangle( (int) e1.getX() , (int) e1.getY(),e1.getWidth(),e1.getHeight() );
		Rectangle e2Mask = new Rectangle( (int) e2.getX() , (int) e2.getY(),e2.getWidth(),e2.getHeight() );
		
		return e1Mask.intersects(e2Mask);
		
	}

	public boolean collisionCheck(Imagen e1, Entity e2) {
		Rectangle e1Mask = new Rectangle( (int) e1.getX() , (int) e1.getY(),e1.getWidth(),e1.getHeight() );
		Rectangle e2Mask = new Rectangle( (int) e2.getX() , (int) e2.getY(),e2.heightMask,e2.whidthMask);		
		
		return e1Mask.intersects(e2Mask);
		
	}



}
