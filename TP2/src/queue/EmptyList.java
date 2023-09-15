package queue;


public class EmptyList extends MainList {
	public MainList add(Object cargo) {
		return NotEmptyList( cargo, this );
	}

	public MainList take() {
		throw new Error(QUEUE_IS_EMPTY);
	}

	public Object head() {
		throw new Error(QUEUE_IS_EMPTY);
	}

	public int size() {
		return 0;
	}

	public static final String QUEUE_IS_EMPTY = "Queue is empty";
}
