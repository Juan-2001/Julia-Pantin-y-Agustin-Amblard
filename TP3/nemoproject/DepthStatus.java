package nemoproject;

public abstract class DepthStatus{
	public abstract int getDepth();
	public abstract DepthStatus ascend();
	public abstract DepthStatus descend();
	public abstract void releaseCapsule();
}