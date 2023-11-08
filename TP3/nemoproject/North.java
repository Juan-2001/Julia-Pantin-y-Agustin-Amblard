package nemoproject;

public class North extends Direction{
	
	public String getDirection() {
		return "norte";
	}
	public Direction turnLeft() {
		return new West();
	}
	public Direction turnRight() {
		return new East();
	}
	public Coordinates moveForward() {
		return new Coordinates(0,1);
	}
	
	
	
	
	
}