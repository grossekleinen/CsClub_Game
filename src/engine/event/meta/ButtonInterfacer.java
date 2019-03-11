package engine.event.meta;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import engine.event.ButtonInputEvent;
import engine.event.ButtonInputEvent.Input;

public class ButtonInterfacer implements KeyListener, MouseListener {

	private static final HashMap<Integer, Input> converter;
	private HashMap<Input, Boolean> isPressed;

	static {
		converter = new HashMap<Integer, Input>();
		converter.put(KeyEvent.VK_ESCAPE, Input.K_ESC);
		converter.put(KeyEvent.VK_F1, Input.K_F1);
		converter.put(KeyEvent.VK_F2, Input.K_F2);
		converter.put(KeyEvent.VK_F3, Input.K_F3);
		converter.put(KeyEvent.VK_F4, Input.K_F4);
		converter.put(KeyEvent.VK_F5, Input.K_F5);
		converter.put(KeyEvent.VK_F6, Input.K_F6);
		converter.put(KeyEvent.VK_F7, Input.K_F7);
		converter.put(KeyEvent.VK_F8, Input.K_F8);
		converter.put(KeyEvent.VK_F9, Input.K_F9);
		converter.put(KeyEvent.VK_F10, Input.K_F10);
		converter.put(KeyEvent.VK_F11, Input.K_F11);
		converter.put(KeyEvent.VK_F12, Input.K_F12);
		converter.put(KeyEvent.VK_F13, Input.K_F13);
		converter.put(KeyEvent.VK_F14, Input.K_F14);
		converter.put(KeyEvent.VK_F15, Input.K_F15);
		converter.put(KeyEvent.VK_F16, Input.K_F16);
		converter.put(KeyEvent.VK_F17, Input.K_F17);
		converter.put(KeyEvent.VK_F18, Input.K_F18);
		converter.put(KeyEvent.VK_F19, Input.K_F19);
		converter.put(KeyEvent.VK_F20, Input.K_F20);
		converter.put(KeyEvent.VK_F21, Input.K_F21);
		converter.put(KeyEvent.VK_F22, Input.K_F22);
		converter.put(KeyEvent.VK_DEAD_TILDE, Input.K_TILDE);
		converter.put(KeyEvent.VK_1, Input.K_1);
		converter.put(KeyEvent.VK_2, Input.K_2);
		converter.put(KeyEvent.VK_3, Input.K_3);
		converter.put(KeyEvent.VK_4, Input.K_4);
		converter.put(KeyEvent.VK_5, Input.K_5);
		converter.put(KeyEvent.VK_6, Input.K_6);
		converter.put(KeyEvent.VK_7, Input.K_7);
		converter.put(KeyEvent.VK_8, Input.K_8);
		converter.put(KeyEvent.VK_9, Input.K_9);
		converter.put(KeyEvent.VK_0, Input.K_0);
		converter.put(KeyEvent.VK_MINUS, Input.K_MINUS);
		converter.put(KeyEvent.VK_EQUALS, Input.K_PLUS);
		converter.put(KeyEvent.VK_DELETE, Input.K_DELETE);
		converter.put(KeyEvent.VK_TAB, Input.K_TAB);
		converter.put(KeyEvent.VK_Q, Input.K_Q);
		converter.put(KeyEvent.VK_W, Input.K_W);
		converter.put(KeyEvent.VK_E, Input.K_E);
		converter.put(KeyEvent.VK_R, Input.K_R);
		converter.put(KeyEvent.VK_T, Input.K_T);
		converter.put(KeyEvent.VK_Y, Input.K_Y);
		converter.put(KeyEvent.VK_U, Input.K_U);
		converter.put(KeyEvent.VK_I, Input.K_I);
		converter.put(KeyEvent.VK_O, Input.K_O);
		converter.put(KeyEvent.VK_P, Input.K_P);
		converter.put(KeyEvent.VK_BRACELEFT, Input.K_LEFT_BRACKET);
		converter.put(KeyEvent.VK_BRACERIGHT, Input.K_RIGHT_BRACKET);
		converter.put(KeyEvent.VK_BACK_SLASH, Input.K_BACKSLASH);
		converter.put(KeyEvent.VK_CAPS_LOCK, Input.K_CAPS_LOCK);
		converter.put(KeyEvent.VK_A, Input.K_A);
		converter.put(KeyEvent.VK_S, Input.K_S);
		converter.put(KeyEvent.VK_D, Input.K_D);
		converter.put(KeyEvent.VK_F, Input.K_F);
		converter.put(KeyEvent.VK_G, Input.K_G);
		converter.put(KeyEvent.VK_H, Input.K_H);
		converter.put(KeyEvent.VK_J, Input.K_J);
		converter.put(KeyEvent.VK_K, Input.K_K);
		converter.put(KeyEvent.VK_L, Input.K_L);
		converter.put(KeyEvent.VK_SEMICOLON, Input.K_SEMICOLON);
		converter.put(KeyEvent.VK_QUOTE, Input.K_QUOTE);
		converter.put(KeyEvent.VK_ENTER, Input.K_ENTER);
		converter.put(KeyEvent.VK_SHIFT, Input.K_SHIFT);
		converter.put(KeyEvent.VK_Z, Input.K_Z);
		converter.put(KeyEvent.VK_X, Input.K_X);
		converter.put(KeyEvent.VK_C, Input.K_C);
		converter.put(KeyEvent.VK_V, Input.K_V);
		converter.put(KeyEvent.VK_B, Input.K_B);
		converter.put(KeyEvent.VK_N, Input.K_N);
		converter.put(KeyEvent.VK_M, Input.K_M);
		converter.put(KeyEvent.VK_COMMA, Input.K_COMMA);
		converter.put(KeyEvent.VK_PERIOD, Input.K_PERIOD);
		converter.put(KeyEvent.VK_CONTROL, Input.K_CONTROL);
		converter.put(KeyEvent.VK_SPACE, Input.K_SPACE);
		converter.put(KeyEvent.VK_LEFT, Input.K_LEFT);
		converter.put(KeyEvent.VK_UP, Input.K_UP);
		converter.put(KeyEvent.VK_DOWN, Input.K_DOWN);
		converter.put(KeyEvent.VK_RIGHT, Input.K_RIGHT);
	}

	private EventCoordinator ec;

	public ButtonInterfacer(EventCoordinator ec) {
		this.ec = ec;
		isPressed = new HashMap<Input, Boolean>();
	}

	public boolean isPressed(Input i) {
		Boolean ret = isPressed.get(i);
		return ret != null? ret : false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Input i = converter.get(e.getKeyCode());
		i = i != null? i : Input.INVALID;
		Boolean b = isPressed.get(i);
		if (b == null || !b) {
			ec.fire(new ButtonInputEvent(i, true));
			isPressed.put(i, true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Input i = converter.get(e.getKeyCode());
		i = i != null? i : Input.INVALID;
		Boolean b = isPressed.get(i);
		if (b == null || b) {
			ec.fire(new ButtonInputEvent(i, false));
			isPressed.put(i, false);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Input i = Input.INVALID;
		switch (e.getButton()) {
		case MouseEvent.BUTTON1:
			i = Input.M_1;
			break;
		case MouseEvent.BUTTON2://unsure why however middle mouse and mouse secondary are button2 and button3 respectively
			i = Input.M_3;
			break;
		case MouseEvent.BUTTON3://see above
			i = Input.M_2;
			break;
		}
		ec.fire(new ButtonInputEvent(i, true));
		isPressed.put(i, true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Input i = Input.INVALID;
		switch (e.getButton()) {
		case MouseEvent.BUTTON1:
			i = Input.M_1;
			break;
		case MouseEvent.BUTTON2://unsure why however middle mouse and mouse secondary are button2 and button3 respectively
			i = Input.M_3;
			break;
		case MouseEvent.BUTTON3://see above
			i = Input.M_2;
			break;
		}
		ec.fire(new ButtonInputEvent(i, false));
		isPressed.put(i, false);
	}

	@Override public void keyTyped(KeyEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mouseClicked(MouseEvent e) {}
}
