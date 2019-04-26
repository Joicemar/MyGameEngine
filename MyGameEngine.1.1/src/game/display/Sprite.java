package game.display;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	BufferedImage image;

	private int x, y, width, height;
	private String name;

	public Sprite(String image_name) {
		try {
			String folder = System.getProperty("user.dir");
			
			image = ImageIO.read((new File(folder + "\\images\\" + image_name)));
			
		} catch (IOException e) {
			System.out.println("/nArquivo não reconhecido ou erro no diretório./n");
			e.printStackTrace();
		}
	}

	public Sprite(String image_name, int x, int y, int width, int height) {

		try {
			String folder = System.getProperty("user.dir");

			image = ImageIO.read((new File(folder + "\\images\\" + image_name)));

//			AffineTransform tx  = AffineTransform.getScaleInstance(-1, 1);
//			tx.translate(-image.getWidth(null), 0);
//			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			// image_flip = op.filter((BufferedImage) image, null);
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.name = image_name;
		} catch (IOException e) {
			System.out.println("Arquivo não reconhecido ou erro no diretório.");
			e.printStackTrace();
		}

	}

	// @Override
	public void draw(Graphics g) {

		g.drawImage(image, x, y, width, height, null);

	}

	public BufferedImage crop(int x, int y, int width, int height) {
		return image.getSubimage(x, y, width, height);
	}

}
