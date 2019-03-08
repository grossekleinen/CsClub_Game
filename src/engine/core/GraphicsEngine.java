package engine.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import engine.character.IEntity;

public class GraphicsEngine implements Runnable {

	private JFrame frame;
	private List<IEntity> ents;
	private long tpf;//time per frame
	private boolean running;
	private double posWeight;

	/**
	 * 
	 * @param title
	 * @param width
	 * @param height
	 * @param framerate
	 * @param unToPx ratio of in-game units to pixels
	 */
	public GraphicsEngine(String title, int width, int height, double framerate, double unToPx) {

		running = false;

		frame = new JFrame("Game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(true);
		frame.setFocusable(false);
		frame.setTitle(title);

		tpf = (long) (1000/framerate);

		ents = new ArrayList<IEntity>();

		posWeight = unToPx;
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

		while (running) {

			BufferedImage im = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics g = im.getGraphics();
			g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
			g.setColor(Color.WHITE);
			
			synchronized (ents) {
				for (IEntity ent : ents) {
					//g.fillRect((int)(ent.getPos()[0]*posWeight), (int)(ent.getPos()[1]*posWeight), (int)(ent.getIHitbox().getDimensions()[0]*posWeight), (int)(ent.getIHitbox().getDimensions()[1]*posWeight));
					g.drawImage(ent.getImage(), (int) (ent.getPos()[0]*posWeight), (int) (ent.getPos()[1]*posWeight), null);
				}
			}

			g.dispose();
			g = frame.getGraphics();
			g.drawImage(im, 0, 0, null);
			g.dispose();

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
