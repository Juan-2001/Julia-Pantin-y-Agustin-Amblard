package queue;

import java.util.ArrayList;
import java.util.List;

public class MainList {
	public List <Object> queues = new ArrayList<>();
	
	static MainList Empty(Queue queues) {
			return new EmptyList();
	}
	static MainList NotEmpty(Queue queues) {
			return new NotEmptyList();
	}
	
	
public Object take() {
	return null;
}
public Object head() {
	return null;
	}
public MainList size() {
	return null;
}
}