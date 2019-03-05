package game.character;

import java.util.List;

public class Hitbox {
	
	double[][] boxes;//arr[ arr[xmin, xmax, ymin, ymax], ... ]
	double[] size;//arr[xmax, ymax]; (0,0) is the min

	public Hitbox(List<double[]> boxes) {
		
		this.boxes = new double[boxes.size()][];
		
		size = new double[2];
		for (int c = 0; c < size.length; c++) {
			size[c] = 0;
		}
		
		for (int i = 0; i < boxes.size(); i++) {
			this.boxes[i] = boxes.get(i);
			
			for (int c = 0; c < size.length; c++) {
				if (this.boxes[i][c] > size[c]) {
					size[c] = this.boxes[i][c];
				}
			}
			
		}
	}
	
	public boolean isTouching(double[] thisbias, Hitbox other, double[] otherbias) {
		return isTouching(other, new double[] {
			otherbias[0] - thisbias[0],
			otherbias[1] - thisbias[1]
		});
	}

	public boolean isTouching(Hitbox other, double[] bias) {
		
		if (size[0] > bias[0] && size[1] > bias[1] && bias[0] + other.size[0] > size[0] && bias[1] + other.size[1] > size[1]) {
			return false;
		}
		
		for (double[] box : boxes) {
			for (double[] obox: other.boxes) {
				if (box[1] - bias[0] > obox[0] && obox[1] + bias[0] > box[0] && box[3] - bias[1] > obox[2] && obox[3] + bias[1] > box[2]) {
					return true;
				}
			}
		}
		return false;
	}

}
