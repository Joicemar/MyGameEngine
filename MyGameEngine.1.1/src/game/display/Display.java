package game.classes;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.Game;
import game.input.Input;
import game.player.Player;
import game.utils.TimerClock;
/**
 * @author Joicemar da Silva Morais
 * 07/05/2019  
 */
public class Engine extends Canvas implements Runnable, KeyListener, MouseListener {

	
	private static final long serialVersionUID = 1L;

	JFrame frame;
	private Thread thread;
	private boolean isRunning;

	private static int width = 800;
	private static int height = 510 ;
	public static int SCALE = 1;
	private static String title = "J Engine";

	private BufferedImage image;
	public Game game;
	private Input input;
	
	public Imagen imagem;// = new Sprite("icon.png", 0,0,32,32);
	//Image icon = Toolkit.getDefaultToolkit().getImage("images\\icon.png");
	
	
	public Engine() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		createDisplay();
		game = new Game();
		input = new Input();
	}

	public Engine(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		game = new Game();
		input = new Input();

		createDisplay();
	}

	public Engine(String title, int width, int height, int scale) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.SCALE = scale;
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		game = new Game();
		input = new Input();

		createDisplay();
	}

	public void tick() {
		/**
		 * @return Usado para atualizar a lógica matemática que esta com esta classe
		 */
		game.update();
		
	}

	public void render() {
		/**
		 * @return É criado uma variavel que pega o BufferStrategy desta classe, se ele
		 *         for nulo é criado com o número 2 ou 3 de parâmetros no
		 *         this.createBufferStrategy(3); Variavel g recebe uma referência ao
		 *         método que cria as bufferedImage ou Image Depois ele recebe uma
		 *         referência a variável que desenha as imagens e o bs.show() ativa todas
		 *         as imagens que estão no banco de memória
		 */
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.createGraphics();

		g = bs.getDrawGraphics(); // Cria um contexto gráfico para o desenho buffe
		g.setColor(new Color(33, 33, 33));
		g.fillRect(0, 0, width*SCALE, height*SCALE);
		
		game.render(g);
		
		bs.show();
		g.dispose();
//		bs.dispose(); // somente se for 2 e de buffer
	}
	/**Responsavel por criar a janela JFrame e suas configurações**/
	public void createDisplay() {
		frame = new JFrame();
		addKeyListener(this);
		addMouseListener(this);
		frame.add(this);
		frame.setSize(width * SCALE, height * SCALE);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle(title);
		frame.setIconImage(new ImageIcon("images/icon.png").getImage());
	}
	/**Método que contém o ciclo loop que atualiza todo o jogo em 60-frames por segundos**/
	@Override
	public void run() {

		int fps = 60;
		double timePerTick = 1000000000 / fps; // = 1.6666666E7

		long lastTime = System.nanoTime();
		long now;
		double delta = 0;

		while (isRunning) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				delta--;
			}

		}

		if (!isRunning) {
			stop();
		}

	}

	public synchronized void start() {
		thread = new Thread(this); // A thead verifica se extendemos a classe Runnable. ela "caça" o método run.
		isRunning = true;
		/**
		 * Faz com que esse segmento inicie a execução; a máquina virtual Java chama o
		 * método run deste encadeamento (desta classe).
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Input.MousePressed = true;
		Input.setX( e.getX()  );
		input.setY( e.getY() );
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Input.MousePressed = false;
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		//////////////////////////////////
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Input.RIGHT = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Input.LEFT = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Input.UP = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Input.DOWN = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Input.W = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Input.A = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Input.S = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Input.D = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Input.SPACE = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			Input.RIGHT = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			Input.ESCAPE = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Input.ENTER = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Input.RIGHT = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Input.LEFT = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Input.UP = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Input.DOWN = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Input.W = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Input.A = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Input.S = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Input.D = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Input.SPACE = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			Input.RIGHT = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			Input.ESCAPE = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Input.ENTER = false;
		}
		

	}



}

/**
 * Ordem de execucão: Construtor, Display, método createDisplay, método start,
 * método run, métodos chamados
 */
