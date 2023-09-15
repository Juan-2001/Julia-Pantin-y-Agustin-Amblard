package queue;

public class NotEmptyList extends MainList{
	private final Object cargo;
	private final MainList next;

	public NotEmptyList(Object cargo, MainList next) {
		this.cargo = cargo;
		this.next = next;
	}
	public MainList add(Object cargo) {
		return NotEmptyList(this.cargo, next.add( cargo ));
	}
	public MainList remove_head() {
		return next;
	}
	public Object head() {
		return cargo;
	}
	public int size() {
		return 1 + next.size();
	}
}
