package nemoproject;


import java.util.LinkedList;
import java.util.List;

public class Nemo {
<<<<<<< Updated upstream
	private DepthStatus depthStatus;
    private Coordinates position;
    private Direction direction;
    public LinkedList<Commands> commandList = new LinkedList<>(List.of(new Up(), new Forward(), new Down(), new Left(), new Right(), new ReleaseCapsule()));


    public Nemo( int x, int y, DepthStatus depthStatus, Direction direction ) {
        this.position = new Coordinates(x, y);
        this.direction = direction;
        this.depthStatus = depthStatus;
=======
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
>>>>>>> Stashed changes
    }

    public int getDepth() {
        return this.depthStatus.getDepth();
    }

    public int[] getPosition() {
        return this.position.getPosition();
    }

    public String getDirection() {
        return this.direction.getDirection();
    }
    
    public Nemo forward() {
        this.position = this.position.add(this.direction.moveForward());
        return this;
    }
    public Nemo ascend() {
        this.depthStatus = this.depthStatus.ascend();
        return this;
    }

    public Nemo descend() {
        this.depthStatus = this.depthStatus.descend();
        return this;
    }

    
    public Nemo move(String message) {
        message.chars().forEach(x-> executeCommand((char) x) );
        return this;
    }
private void executeCommand(char c) {
	    commandList.stream()
	            .filter(command -> command.validCharacter(c))
	            .findFirst()
	            .ifPresent(command -> command.execute(this));
	
	}

public Nemo turnLeft() {
	this.direction = this.direction.turnLeft();
		return null;
}

public Nemo turnRight() {
	this.direction = this.direction.turnRight();
	return this;
}

public Nemo releaseCapsule() {
	 this.depthStatus.releaseCapsule();
	return this;
}
        }