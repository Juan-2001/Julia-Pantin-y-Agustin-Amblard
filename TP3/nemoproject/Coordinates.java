package nemoproject;

public class Coordinates {
<<<<<<< Updated upstream
	
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
=======
    private int depth;
    private int[] position;
    private String direction;
    private int u = 1;
    private int d = -1;
    private int r = 90;
    private int l = -90;
    private int f = 1;

    public Coordinates() {
        this.depth = 0;
        this.position = new int[]{0, 0};
        this.direction = "norte";
    }

    public int getDepth() {
    	return this.depth;
    }

    public int[] getPosition() {
        return this.position;
    }

    public String getDirection() {
        return this.direction;
    }

    /*public Coordinates move(String command) {
        command.chars()
        .mapToObj(c -> (char) c)
        .forEach(this::processCharacter);*/
}
>>>>>>> Stashed changes
