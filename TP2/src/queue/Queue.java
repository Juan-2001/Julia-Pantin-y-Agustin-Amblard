package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	public MainList myMainList = new EmptyList();

    public boolean isEmpty() {
        return myMainList.isEmpty();
    }

    public Queue add(Object object) {
        myMainList = myMainList.add(object);
        return this;
    }

    public Object take() {
        Object removedObject = myMainList.head();
        myMainList = myMainList.take();
        return removedObject;
    }

	public Object head() {
		return myMainList.head();
	}

	public int size() {
		return myMainList.size();
	}
}
