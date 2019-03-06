package game.core;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import game.character.Character;

public class Game {
	
	private JFrame frame;
	
	public Game(int windowX, int windowY, String title) {
		frame = new JFrame("Game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setLocation(null);
		frame.setTitle(title);
		frame.setVisible(true);
		frame.setCursor(frame.HAND_CURSOR);
		
		//TODO double-buffering

		//set var x
	}
	public JFrame getFrame() {
	    return frame;
	    
	}
	
}
