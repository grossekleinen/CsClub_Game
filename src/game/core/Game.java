package game.core;

import javax.swing.JFrame;

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
		
		//TODO double-buffering

		//set var x
	}
	public JFrame getFrame() {
	    return frame;
	    
	}
	
}
