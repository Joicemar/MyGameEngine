package game.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Display extends Canvas implements Runnable {

	JFrame frame;
	private Thread thread;
	private static int width = 150;
	private static int height = 100;
	private static int SCALE = 6;
	
	private String title = "Game Engine";

	private BufferedImage image;

	
	Sprite sprite = new Sprite("icon.png", 33, 33, 100, 100);

	public Display() {
		System.out.println("Display");
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		createDisplay();
	}

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	public void render() {
		/**
		 * @return
		 * É criado uma variavel que pega o BufferStrategy desta classe, se ele for nulo
		 * é criado com o número 2 ou 3 de parâmetros no this.createBufferStrategy(2);
		 * Variavel g recebe uma referência ao método que cria as bufferedImage ou Image
		 * Depois ele recebe uma refeência a variável que desenha as imagens
		 * e o bs.show() ativa todas as imagens que estão no banco de memória
		 */
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = image.createGraphics();

		g = bs.getDrawGraphics(); //Cria um contexto gráfico para o desenho buffe
		// bs.show();

		sprite.draw(g);
		bs.show();
		g.dispose();
	}

	public void createDisplay() {
		System.out.println("createDisplay");
		frame = new JFrame();
		frame.setSize(width * SCALE, height * SCALE);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle(title);
		frame.add(this);

	}

	@Override
	public void run() {
		System.out.println("run");
		while( true ) {
			render();
			
		}

	}

	public synchronized void start() {
		System.out.println("start");
		thread = new Thread(this); // A thead verifica se extendemos a classe Runnable. ela "caça" o método run.
		//isRunning = true;
		/**
		 * Faz com que esse segmento inicie a execução; a máquina virtual Java
     	 * chama o método run deste encadeamento.
		 */
		thread.start();
		
	}
	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Ordem de execucão:
 * Construtor Display
 * método createDisplay
 * método start
 * método run
 * método render
 */


