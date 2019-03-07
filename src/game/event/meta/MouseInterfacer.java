package game.event.meta;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseInterfacer implements MouseMotionListener, MouseWheelListener {

	private EventCoordinator ec;
	private double weight;
	
	public MouseInterfacer(EventCoordinator ec, double diagLen) {
		this.ec = ec;
		weight = 100/diagLen;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}
	
	@Override public void mouseDragged(MouseEvent e) {}
}
