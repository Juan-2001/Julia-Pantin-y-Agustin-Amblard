package nemoproject;

public class Nemo {
    private int depth;
    private int[] position;
    private String direction;
    private int u = 1;
    private int d = -1;
    private int r = 90;
    private int l = -90;
    private int f = 1;

    public Nemo() {
        this.depth = new Coordinates().getDepth();
        this.position = new Coordinates().getPosition();
        this.direction = new Coordinates().getDirection();
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
    
    public Nemo move(String command) {
        command.chars()
        .mapToObj(c -> (char) c)
        .forEach(this::processCharacter);
return this;
}
private void processCharacter(char c) {
String command = String.valueOf(c);
		if (command.equals("u")) {
			this.depth += 1;
		}
        if (command.equals("d")) {
            this.depth -= 1;
        }
        if (command.equals("r")) {
            switch (this.direction) {
                case "norte":
                    this.direction = "este";
                    break;
                case "este":
                    this.direction = "sur";
                    break;
                case "sur":
                    this.direction = "oeste";
                    break;
                case "oeste":
                    this.direction = "norte";
                    break;
            }
        }
        if (command.equals("l")) {
            switch (this.direction) {
                case "norte":
                    this.direction = "oeste";
                    break;
                case "oeste":
                    this.direction = "sur";
                    break;
                case "sur":
                    this.direction = "este";
                    break;
                case "este":
                    this.direction = "norte";
                    break;
            }
        }

        if (command.equals("f")) {
            switch (this.direction) {
                case "norte":
                    this.position[1] += 1;
                    break;
                case "sur":
                    this.position[1] -= 1;
                    break;
                case "este":
                    this.position[0] += 1;
                    break;
                case "oeste":
                    this.position[0] -= 1;
                    break;
            }
        }}}
