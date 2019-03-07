package game.character;

public interface IHitbox {

	public boolean isTouching(double[] thisbias, IHitbox other, double[] otherbias);
	public boolean isTouching(IHitbox other, double[] bias);

	public double[][] getBoxes();
	public double[] getDimensions();

}
