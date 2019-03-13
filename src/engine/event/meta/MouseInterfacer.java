package engine.event.meta;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import engine.event.MouseInputEvent;
import engine.event.MouseWheelInputEvent;

public class MouseInterfacer implements MouseMotionListener, MouseWheelListener {

	private EventCoordinator ec;
	private double weight;
	private static double[] loc;
	
	/**
	 * constructs a MouseInterfacer
	 * @param ec
	 * @param pxToUn ratio of pixels to in-game units
	 */
	public MouseInterfacer(EventCoordinator ec, double visualRatio) {
		this.ec = ec;
		weight = visualRatio;
	}
	
	/**
	 * get the current location of the mouse
	 * @return the current location of the mouse cursor in in-game coordinates
	 */
	public static double[] getMouseLocation() {
		return loc;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		loc = new double[]{e.getX()*weight, e.getY()*weight};
		ec.fire(new MouseInputEvent(loc));
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		ec.fire(new MouseWheelInputEvent(e.getWheelRotation()));
	}
	
	@Override public void mouseDragged(MouseEvent e) {}
}
