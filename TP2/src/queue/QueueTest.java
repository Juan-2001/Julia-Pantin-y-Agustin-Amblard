package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class QueueTest {

@Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( addSomethingElement().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( somethingElement, addSomethingElement().head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = addSomethingElement();
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = new Queue();
    String addedObject = somethingElement;
    queue.add( addedObject );
    
    assertEquals( addedObject, queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = new Queue();
    String firstAddedObject = firstObject;
    String secondAddedObject = secondObject;

    queue.add( firstAddedObject );
    queue.add( secondAddedObject );

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = new Queue();
    String firstAddedObject = firstObject;

    queue.add( firstAddedObject );
    queue.add( secondObject );

    assertEquals( queue.head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = new Queue();
    queue.add( somethingElement );
    sizeEquals1(queue);
    queue.head();
    sizeEquals1(queue);
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new Queue().add( firstObject ).add( secondObject ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    tryTakeOrCatchError(queue);
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = new Queue();
    queue.add( somethingElement );
    queue.take();
    tryTakeOrCatchError(queue);
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    try {
      queue.head();
      fail( expectedErrorNotThrown );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( queueIsEmpty ) );
    }
  }
  // Method and Constants extracted
  private static final String queueIsEmpty = "Queue is empty";
  private static final String expectedErrorNotThrown = "Expected Error was not thrown.";
  private static final String secondObject = "Second";
  private static final String firstObject = "First";
  private static final String somethingElement = "Something";
  
  void sizeEquals1(Queue queue) {
		assertEquals( 1, queue.size() );
	}
  
  Queue addSomethingElement() {
		return new Queue().add( somethingElement );
	}
  
  void tryTakeOrCatchError(Queue queue) {
		try {
	      queue.take();
	      fail( expectedErrorNotThrown );
	    } catch (Error e) {
	      assertTrue( e.getMessage().equals( queueIsEmpty ) );
	    }
	}

}