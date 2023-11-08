package nemoproject;

public class Submerged extends DepthStatus {

    public int depth;
    public DepthStatus previousStatus;

    public Submerged(int depth, DepthStatus previousStatus) {
        this.depth = depth;
        this.previousStatus = previousStatus;
    }

    public int getDepth() {
        return this.depth;
    }

    public DepthStatus ascend() {
        return this.previousStatus;
    }

    public DepthStatus descend() {
    	this.previousStatus = new Submerged(this.depth , this.previousStatus);
    	this.depth -=1;
    	return new Submerged(this.depth, this.previousStatus);
    	
    }

    public void releaseCapsule() {
        throw new RuntimeException("El submarino explota.");
    }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
