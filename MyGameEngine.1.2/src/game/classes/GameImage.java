package game.classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GameImage extends Elements {

	BufferedImage image;
	private BufferedImage image_flip;
	
	public GameImage(String image_name, int x, int y, int width, int height) {

		try {
			String folder = System.getProperty("user.dir");

			if (new File(folder + "\\images\\" + image_name + ".png").exists()) {

				image = ImageIO.read((new File(folder + "\\images\\" + image_name + ".png")));
			} else {
				image = ImageIO.read((new File(folder + "\\images\\" + image_name)));
			}

			
			super.x = x;
			super.y = y;
			super.width = width;
			super.height = height;
			super.name = image_name;
			
			AffineTransform tx  = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-image.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			image_flip = op.filter((BufferedImage) image, null);
			
		} catch (IOException e) {
			System.out.println("Arquivo não reconhecido ou erro no diretório.");
			e.printStackTrace();
		}

	}
	
	public GameImage(String image_name) {
		try {
			String folder = System.getProperty("user.dir");

			if (new File(folder + "\\images\\" + image_name + ".png").exists()) {

				image = ImageIO.read((new File(folder + "\\images\\" + image_name + ".png")));
			} else {
				image = ImageIO.read((new File(folder + "\\images\\" + image_name)));
			}
			
			super.x = 0;
			super.y = 0;
			super.width = image.getWidth();
			super.height = image.getHeight();
			super.name = image_name;
			
			AffineTransform tx  = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-image.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			image_flip = op.filter((BufferedImage) image, null);
			
		} catch (IOException e) {
			System.out.println("/nArquivo não reconhecido ou erro no diretório./n");
			e.printStackTrace();
		}
	}




	public void render(Graphics g) {

		g.drawImage(image, x, y, width*Engine.SCALE, height*Engine.SCALE, null);
	//	return image;

	}

	public void renderFlip(Graphics g) {
		/**Exibe, renderiza a imagem inversa na horizontal*/
		g.drawImage(image_flip, x, y, width*Engine.SCALE, height*Engine.SCALE, null);
		//	return image;
		
	}

	public BufferedImage crop(int x, int y, int width, int height) {
		/**Costa a imagem no pixels de inicio x,y até o final width,height*/
		return image.getSubimage(x, y, width, height);
	}

	public BufferedImage getImage() {
		 
		return image;
	}

	
	
	
	
	
}
