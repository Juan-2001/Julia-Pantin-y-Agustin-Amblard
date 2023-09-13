package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	public MainList myMainList;
	public List <Object> queues = new ArrayList<>();

	public boolean isEmpty() {
		return queues.isEmpty();
	}
	
	public Queue add( Object  object ) {
		queues.add(object);
		return this;
	}

	public Object take() {
		if (isEmpty()) {
		        throw new Error(Queue_is_empty);
		 } else {
		        return queues.remove(0);
		    }
		 }

	public Object head() {
		if (isEmpty()) {
            throw new Error(Queue_is_empty);
        }
		else {
			return queues.get(0);
		}
	}

	public int size() {
		if (isEmpty()) {
			throw new Error(Queue_is_empty);
		}
		else { 
			return queues.size();
		}
	}
	private static final String Queue_is_empty = "Queue is empty";
}