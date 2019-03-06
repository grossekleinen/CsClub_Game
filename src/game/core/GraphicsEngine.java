package game.core;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import game.character.ICharacter;

public class GraphicsEngine implements Runnable {

	private JFrame frame;
	private List<ICharacter> chars;
	private long tpf;//time per frame
	private boolean running;

	public GraphicsEngine(String title, int width, int height, double framerate) {

		running = false;

		frame = new JFrame("Game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(true);
		frame.setFocusable(false);
		frame.setTitle(title);

		tpf = (long) (1000/framerate);

		chars = new ArrayList<ICharacter>();
	}

	@Override
	public void run() {

		System.out.println("Graphics engine starting");

		if (running) {
			System.err.println("ERR: Graphics engine attempted to be started while already running");
			Thread.dumpStack();
			return;
		}

		running = true;

		frame.setVisible(true);
		frame.createBufferStrategy(2);//TODO check if manually double buffering is necessary or only this is required

		double posWeight = Math.sqrt(frame.getWidth()*frame.getWidth() + frame.getHeight()*frame.getHeight())/100.0;

		while (running) {

			Graphics g = frame.getGraphics();

			synchronized (chars) {
				for (ICharacter c : chars) {
					g.drawImage(c.getImage(), (int) (c.getPos()[0]*posWeight), (int) (c.getPos()[1]*posWeight), null);
				}
			}

			try {
				Thread.sleep(tpf);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void stop() {
		running = false;
	}

	public void addCharacter() {

	}

	public JFrame getFrame() {
		return frame;
	}

}
