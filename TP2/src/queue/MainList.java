package queue;

public abstract class MainList {
	public MainList NotEmptyList( Object cargo, MainList next ) {
		return new NotEmptyList( cargo, next );
	}

	public abstract  MainList add(Object cargo);
	public abstract MainList remove_head();
	public abstract Object head();
	public abstract int size();

	}