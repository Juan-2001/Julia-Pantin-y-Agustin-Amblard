package nemoproject;

public class BelowSurface extends DepthStatus{
	public int getDepth() {
		return -1;
	}
    public DepthStatus ascend() {
        return new Surface();
    }
	public DepthStatus descend() {
		return new Submerged(-2, new BelowSurface());
	}
	public void releaseCapsule(){
	}
}
