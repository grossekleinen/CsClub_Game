package engine.event;

import engine.event.meta.IEvent;

public class ButtonInputEvent implements IEvent {

	public enum Input {
		K_ESC	("Escape"),
		K_F1	("F1"),
		K_F2	("F2"),
		K_F3	("F3"),
		K_F4	("F4"),
		K_F5	("F5"),
		K_F6	("F6"),
		K_F7	("F7"),
		K_F8	("F8"),
		K_F9	("F9"),
		K_F10	("F10"),
		K_F11	("F11"),
		K_F12	("F12"),
		K_F13	("F13"),
		K_F14	("F14"),
		K_F15	("F15"),
		K_F16	("F16"),
		K_F17	("F17"),
		K_F18	("F18"),
		K_F19	("F19"),
		K_F20	("F20"),
		K_F21	("F21"),
		K_F22	("F22"),
		K_TILDE	("Tilde"),
		K_1		("1"),
		K_2		("2"),
		K_3		("3"),
		K_4		("4"),
		K_5		("5"),
		K_6		("6"),
		K_7		("7"),
		K_8		("8"),
		K_9		("9"),
		K_0		("0"),
		K_MINUS	("-"),
		K_PLUS	("+"),
		K_DELETE	("Dete"),
		K_TAB	("Tab"),
		K_Q		("Q"),
		K_W		("W"),
		K_E		("E"),
		K_R		("R"),
		K_T		("T"),
		K_Y		("Y"),
		K_U		("U"),
		K_I		("I"),
		K_O		("O"),
		K_P		("P"),
		K_LEFT_BRACKET	("Left Bracket"),
		K_RIGHT_BRACKET	("Right Bracket"),
		K_BACKSLASH	("Black Slash"),
		K_CAPS_LOCK		("Caps Lock"),
		K_A		("A"),
		K_S		("S"),
		K_D		("D"),
		K_F		("F"),
		K_G		("G"),
		K_H		("H"),
		K_J		("J"),
		K_K		("K"),
		K_L		("L"),
		K_SEMICOLON	(";"),
		K_QUOTE	("\""),
		K_ENTER	("Enter"),
		K_SHIFT	("Shift"),
		K_Z		("Z"),
		K_X		("X"),
		K_C		("C"),
		K_V		("V"),
		K_B		("B"),
		K_N		("N"),
		K_M		("M"),
		K_COMMA	("Comma"),
		K_PERIOD	("Period"),
		K_SLASH	("Forward Slash"),
		K_FN	("Function"),
		K_CONTROL	("Control"),
		K_ALT	("Alt"),
		K_SPACE	("Space"),
		K_UP	("Up Arrow"),
		K_LEFT	("Left Arrow"),
		K_DOWN	("Down Arrow"),
		K_RIGHT	("Right Arrow"),
		M_1		("Mouse Primary"),
		M_2		("Mouse Secondary"),
		M_3		("Mouse Tertiary"),
		M_4		("Fourth Mouse Button"),
		M_5		("Fifth Mouse Button"),
		M_6		("Sixth Mouse Button"),
		INVALID	("UNKOWN");

		private final String name;

		Input(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	private final Input input;
	private final boolean press;

	/**
	 * @param input the button pressed or released in this event
	 * @param press whether this event is for a button being pressed; false is if this is a release event
	 */
	public ButtonInputEvent(Input input, boolean press) {
		this.input = input;
		this.press = press;
	}

	/**
	 * @return the button pressed or released in this event
	 */
	public Input getInput() {
		return input;
	}

	/**
	 * @return whether this event is for a button being pressed; false is if this is a release event
	 */
	public boolean isPressEvent() {
		return press;
	}

	/**
	 * @return whether this event is for a button being release; false is if this is a press event
	 */
	public boolean isReleaseEvent() {
		return !press;
	}

	@Override
	public String getName() {
		return "BUTTON_INPUT";
	}

}