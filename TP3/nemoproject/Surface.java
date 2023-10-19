package nemoproject;

public class Surface extends DepthStatus{
	public int getDepth() {
		return 0;
	}
    public DepthStatus ascend() {
        return new Surface();
    }
	public DepthStatus descend() {
		return new BelowSurface();
	}
	public void releaseCapsule(){
	}
}
