package nemoproject;

public class East extends Direction {

	public String getDirection() {
		return "este";
	}

	public Direction turnLeft() {
		return new North();
	}

	public Direction turnRight() {
		return new South();
	}

	public Coordinates moveForward() {
		return new Coordinates(1,0);
	}

}

