package engine.event.meta;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseInterfacer implements MouseMotionListener, MouseWheelListener {

	private EventCoordinator ec;
	private double weight;
	
	/**
	 * 
	 * @param ec
	 * @param pxToUn ratio of pixels to in-game units
	 */
	public MouseInterfacer(EventCoordinator ec, double visualRatio) {
		this.ec = ec;
		weight = visualRatio;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}
	
	@Override public void mouseDragged(MouseEvent e) {}
}
