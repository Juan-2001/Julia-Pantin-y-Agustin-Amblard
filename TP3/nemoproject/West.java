package nemoproject;

public class West extends Direction {

	public String getDirection() {
		return "oeste";
	}

	@Override
	public Direction turnLeft() {
		return new South();
	}

	@Override
	public Direction turnRight() {
		return new North();
	}

	@Override
	public Coordinates moveForward() {
		return new Coordinates(-1,0);
	}

}
