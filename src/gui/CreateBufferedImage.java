package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CreateBufferedImage {
	
	private BufferedImage bufferedImage;
	
	public CreateBufferedImage(String path){
		try {
			this.bufferedImage = ImageIO.read(new File(path));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

}
