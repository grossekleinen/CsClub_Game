package game.core;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import game.character.IEntity;

public class GraphicsEngine implements Runnable {

	private JFrame frame;
	private List<IEntity> ents;
	private long tpf;//time per frame
	private boolean running;
	private double posWeight;

	public GraphicsEngine(String title, int width, int height, double framerate, double diagLen) {

		running = false;

		frame = new JFrame("Game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(true);
		frame.setFocusable(false);
		frame.setTitle(title);

		tpf = (long) (1000/framerate);

		ents = new ArrayList<IEntity>();

		posWeight = diagLen/100;
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

		while (running) {

			Graphics g = frame.getGraphics();

			synchronized (ents) {
				for (IEntity ent : ents) {
					g.drawImage(ent.getImage(), (int) (ent.getPos()[0]*posWeight), (int) (ent.getPos()[1]*posWeight), null);
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

	public boolean addEntity(IEntity ent) {
		return ents.add(ent);
	}

	public boolean removeEntity(IEntity ent) {
		return ents.remove(ent);
	}

	public boolean hasEntity(IEntity ent) {
		return ents.contains(ent);
	}

	public JFrame getFrame() {
		return frame;
	}

}
