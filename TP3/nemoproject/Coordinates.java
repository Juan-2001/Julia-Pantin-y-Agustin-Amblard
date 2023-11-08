package nemoproject;

public class Coordinates {
	
	private int x;
	private int y;
	
	public Coordinates(int i, int j) {
		x= i;
		y= j;
	}
	
	public Coordinates add(Coordinates coordinate) {
		x+= coordinate.x;
		y+=coordinate.y;
		return this;
	}

	public int[] getPosition() {
	    return new int[]{x, y};
	}
}