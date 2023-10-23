package nemoproject;

public class South extends Direction{
	
	public String getDirection() {
		return "sur";
	}
	public Direction turnLeft() {
		return new East();
	}
	public Direction turnRight() {
		return new West();
	}
	public Coordinates moveForward() {
		return new Coordinates(0,-1);
	}
	
	
	
	
	
}