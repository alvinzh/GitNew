package com.test.main;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RandomTest extends JFrame {

	public RandomTest() {
		JLabel imageLable = new JLabel();
		imageLable.setText("test");

//		JPanel panel = new JPanel();
		
		this.add(imageLable);
//		this.add(panel);


	}
	
	public void update(Graphics g) {
        super.update(g);
		g.drawLine(1, 1, 200, 200);
		g.drawString("gogo", 100, 100);
		System.out.println("into");
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomTest test = new RandomTest();
		test.setSize(400, 400);
		test.setVisible(true);

	}

}
