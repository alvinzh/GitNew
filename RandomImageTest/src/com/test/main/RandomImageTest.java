package com.test.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class RandomImageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomImageTest test = new RandomImageTest();
		test.createImage(100, 40);
	}

	public void createImage(int width, int height) {
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, width - 1, height - 1);

		g.setColor(Color.RED);
		g.drawRect(0, 0, width - 1, height - 1);

		g.setColor(getRandomColor());
		Random ran = new Random();
		for (int i = 0; i < 50; i++) {
			int x = ran.nextInt(width - 1);
			int y = ran.nextInt(height - 1);

			int x1 = ran.nextInt(30) + 1;
			int y1 = ran.nextInt(10) + 1;
			g.drawLine(x, y, x + x1, y + y1);
		}
		for (int i = 0; i < 50; i++) {
			int x = ran.nextInt(width - 1);
			int y = ran.nextInt(height - 1);

			int x1 = ran.nextInt(10) + 1;
			int y1 = ran.nextInt(30) + 1;
			g.drawLine(x, y, x - x1, y - y1);
		}
		
		
		Font font = new Font("Arial Black", Font.PLAIN, 20);
		g.setFont(font);
		
		String showWord = "";
		for (int i = 0; i < 6; i ++) {
			g.setColor(getRandomColor());
			showWord = getRandomChar();
			int y = 40+((int)(Math.random()*10)-20);
			g.drawString(showWord, 15*i, y);
		}


		try {
			ImageIO.write(image, "JPEG", new File("c:/test.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Color getRandomColor() {
		return new Color((int)(Math.random()*110)+20, (int)(Math.random()*110)+20,(int)(Math.random()*110)+20);
	}
	
	private String getRandomChar() {
		String result = "";

		int type = (int) Math.round(Math.random() * 2);
		long iChar = 0;
		char word = '\u0000';
		switch (type) {
		case 1:
			iChar = Math.round(Math.random() * 25 + 65);
			word = (char) iChar;
			result = String.valueOf(word);
			break;
		case 2:
			iChar = Math.round(Math.random() * 25 + 97);
			word = (char) iChar;
			result = String.valueOf(word);
			break;
		default:
			iChar = Math.round(Math.random() * 9);
			result = String.valueOf(iChar);
		}
		return result;
	}
}
