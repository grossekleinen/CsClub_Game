package game.core;

import javax.swing.JFrame;

public class Game {
	
	private JFrame frame;
	
	public Game() {
		frame = new JFrame("Game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		
		//TODO double-buffering
		
		frame.setVisible(true);
		//set var x to gay
	}
	
}
