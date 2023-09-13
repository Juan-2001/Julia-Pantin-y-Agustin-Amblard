package queue;

public class NotEmptyList extends MainList{
	
	public Object take(Object  object) {
		       return queues.remove(object);       
	}
	
	public Object head() {
		return queues.get(0);
	}
	
	public int Queue() {
		return queues.size();
	}
}
