package engine.entity;

import java.util.List;

public class Hitbox implements IHitbox {

	double[][] boxes;//arr[ arr[xmin, ymin, xmax, ymax], ... ]
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
				if (this.boxes[i][c + 2] > size[c]) {
					size[c] = this.boxes[i][c + 2];
				}
			}

		}
	}

	@Override
	public boolean isTouching(double[] thisbias, IHitbox other, double[] otherbias) {
		return isTouching(other, new double[] {
				otherbias[0] - thisbias[0],
				otherbias[1] - thisbias[1]
		});
	}

	@Override
	public boolean isTouching(IHitbox other, double[] bias) {

		if (size[0] <= bias[0] || size[1] <= bias[1] || bias[0] + other.getDimensions()[0] <= 0 || bias[1] + other.getDimensions()[1] <= 0) {
			return false;
		}

		for (double[] box : boxes) {
			for (double[] obox: other.getBoxes()) {
				if (box[2] > bias[0] + obox[0] && box[3] > bias[1] + obox[1] && obox[2] + bias[0] > box[0] && obox[3] + bias[1] > box[1]) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public double[][] getBoxes() {
		return boxes;
	}

	@Override
	public double[] getDimensions() {
		return size.clone();
	}

}
