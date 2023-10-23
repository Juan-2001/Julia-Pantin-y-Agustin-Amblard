package nemoproject;

public abstract class Direction{
	public abstract String getDirection();
	public abstract Direction turnLeft();
	public abstract Direction turnRight();
	public abstract Coordinates moveForward();
}