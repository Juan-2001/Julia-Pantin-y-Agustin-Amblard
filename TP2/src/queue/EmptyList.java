package queue;


public class EmptyList extends MainList {
	public static final String QUEUE_IS_EMPTY = "Queue is empty";

	public MainList add(Object cargo) {
		return NotEmptyList( cargo, this );
	}

	public MainList remove_head() {
		throw new Error(QUEUE_IS_EMPTY);
	}

	public Object head() {
		throw new Error(QUEUE_IS_EMPTY);
	}

	public int size() {
		return 0;
	}
}
