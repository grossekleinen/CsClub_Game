package engine.math;

public class Vector {

	/**
	 * @param a array of data
	 * @param b array of data
	 * @param out output array
	 * out sets out to a + b
	 */
	public static void add(double[] a, double[] b, double[] out) {
		for (int i = 0; i < out.length; i++) {
			out[i] = a[i] + b[i];
		}
	}

	/**
	 * @param a array of data
	 * @param b array of data
	 * @return a + b
	 */
	public static double[] add(double[] a, double[] b) {
		double[] out = new double[Math.min(a.length, b.length)];
		add(a, b, out);
		return out;
	}

	/**
	 * @param a array of data
	 * @param b array of data
	 * @param out output array
	 * out sets out to a - b
	 */
	public static void subtract(double[] a, double[] b, double[] out) {
		for (int i = 0; i < out.length; i++) {
			out[i] = a[i] - b[i];
		}
	}

	/**
	 * @param a array of data
	 * @param b array of data
	 * @return dot product of a and b
	 */
	public static double dot(double[] a, double[] b) {
		double sum = 0;
		for (int i = 0; i < Math.min(a.length, b.length); i++) {
			sum += a[i]*b[i];
		}
		return sum;
	}

	/**
	 * sets out to a scaled by scale
	 * @param a vector to be scaled
	 * @param scale multiplier for scaling
	 * @param out output array
	 */
	public static void scale(double[] a, double scale, double[] out) {
		for (int i = 0; i < out.length; i++) {
			out[i] = a[i]*scale;
		}
	}

	/**
	 * scales a by scale
	 * @param a vector to be scaled
	 * @param scale multiplier for scaling
	 * @return a scaled by scale
	 */
	public static double[] scale(double[] a, double scale) {
		double[] out = new double[a.length];
		scale(a, scale, out);
		return out;
	}

	/**
	 * gets magnitude of a vector
	 * @param a vector to get magnitude of
	 * @return magnitude of a
	 */
	public static double magnitude(double[] a) {
		return Math.sqrt(a[0]*a[0] + a[1]*a[1]);
	}

	/**
	 * gets the squared magnitude of a vector
	 * @param a vector to get squared magnitude of
	 * @return squared magnitude of a
	 */
	public static double magnitude2(double[] a) {
		return a[0]*a[0] + a[1]*a[1];
	}

}
