package queue;


public class EmptyList extends MainList{
	
	public Object take(Object  object) {
		 throw new Error("Queue is empty"); // throw new RuntimeException()
		 }
	
	public Object head() {
		throw new Error("Queue is empty");
		 }
	
	public int Queue() {
		throw new Error("Queue is empty");
		}
}
