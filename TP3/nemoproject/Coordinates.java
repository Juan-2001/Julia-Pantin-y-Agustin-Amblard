package nemoproject;

public class Coordinates {
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
