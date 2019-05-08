package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import game.classes.Engine;
import game.classes.Imagen;
import game.input.Input;
import game.player.Player;


public class Game extends Input{
	
	public Imagen jogador;

	public Game() {
		
		jogador = new Imagen("icon",0,0,120,120);
	}

	
	public void update( ) {
		if( D ) {
			jogador.moveX(3 );
		}
		if( A ) {
			jogador.moveX(-3);
		}
		if( W ) {
			jogador.moveY( -3 );
		}
		if ( S ) {
			jogador.moveY(3);
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

		jogador.render(g);
		
	}
	
	
}
