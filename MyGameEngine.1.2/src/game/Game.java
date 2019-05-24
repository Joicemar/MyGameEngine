package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import game.classes.Engine;
import game.classes.GameImage;
import game.classes.Sprite;
import game.input.Input;
import game.player.Player;


public class Game extends Input{
	
	public GameImage jogador;
	Sprite sprite;
	

	public Game() {
		sprite = new Sprite(0,0,120,120, 8);
		//jogador = new GameImage("icon",0,0,120,120);
		sprite.AddSprite( "frente1");
		sprite.AddSprite( "frente2");
		sprite.AddSprite( "frente3");
		sprite.AddSprite( "frente4");
	
	
	}

	
	public void update( ) {
		if( D ) {
			sprite.moveX(3 );
		}
		if( A ) {
			sprite.moveX(-3);
		}
		if( W ) {
			sprite.moveY( -3 );
		}
		if ( S ) {
			sprite.moveY(3);
		}
		if( MousePressed ) {

			//			if( jogador.getX() < in.getX()) {
//				jogador.moveX(3);
//				if( jogador.getY() < getY() ) {
//					jogador.moveY(3);
//				}
//				if( jogador.getY() > getY() ) {
//					jogador.moveY( - 3);
//				}
//			}
//			if( jogador.getY() < getY() ) {
//				jogador.moveY(3);
//				if( jogador.getX() < in.getX()) {
//					jogador.moveX(3);
//				}
//				if( jogador.getX() > in.getX()) {
//					jogador.moveX( - 3);
//				}
//			}
//			if( jogador.getX() > in.getX()) {
//				jogador.moveX( - 3);
//				if( jogador.getY() < getY() ) {
//					jogador.moveY(3);
//				}
//				if( jogador.getY() > getY() ) {
//					jogador.moveY( - 3);
//				}
//			}
//			if( jogador.getY() > getY() ) {
//				jogador.moveY( - 3);
//				if( jogador.getX() < in.getX()) {
//					jogador.moveX(3);
//				}
//				if( jogador.getX() > in.getX()) {
//					jogador.moveX( - 3);
//				}
//			}
			
		}
		
	}
	
	public void render(Graphics g) {

		//jogador.render(g);
		int x = 3;
		
		sprite.render(g, true);
		 
	}
	
	
}
