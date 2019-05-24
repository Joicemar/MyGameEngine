package game.player;

import java.awt.Graphics;

import game.Game;
import game.classes.Elements;
import game.classes.GameImage;

public class Player extends Elements{
	
	GameImage player;
	Game game;
	
	public Player() {
		game = new Game();
		player = new GameImage("icon", 20, 20, 33,33);
	
	}
	
	
	
	public void update() {
		//game.update();
		if (right) {
			moveX(speed);
		}
		if (left) {
			moveX(-speed);
		}
		if (up) {
			moveY(-speed);
		}
		if (down) {
			moveY(speed);
		}else {
			System.out.println("pass");
		}
	}
	
	public void render(Graphics g) {

		//player.render(g);
	}

}
