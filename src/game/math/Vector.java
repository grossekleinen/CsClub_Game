package game.math;

public class Vector {

	/**
	 * @param a array of data
	 * @param b array of data
	 * @param out output array
	 * out sets out to a + b
	 */
	public static void add(double[] a, double[] b, double[] out) {
		for (int i = 0; i < Math.min(a.length, b.length); i++) {
			out[i] = a[i] + b[i];
		}
	}

	/**
	 * @param a array of data
	 * @param b array of data
	 * @param out output array
	 * out sets out to a - b
	 */
	public static void subtract(double[] a, double[] b, double[] out) {
		for (int i = 0; i < Math.min(a.length, b.length); i++) {
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

}
