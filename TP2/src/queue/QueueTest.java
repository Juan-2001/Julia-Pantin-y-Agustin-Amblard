package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class QueueTest {

@Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( queueWithSomethingElement().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( somethingElement, queueWithSomethingElement().head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = queueWithSomethingElement();
    queue.take();
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = queueWithSomethingElement();
    assertEquals( somethingElement, queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = queueWithFirstAndSecondObject();
    assertEquals( queue.take(), firstObject );
    assertEquals( queue.take(), secondObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = queueWithFirstAndSecondObject();
    assertEquals( queue.head(), firstObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = queueWithSomethingElement();
    sizeEquals1(queue);
    queue.head();
    sizeEquals1(queue);
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new Queue().add( firstObject ).add( secondObject ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    tryTakingOrCatchingError(queue);
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = queueWithSomethingElement();
    queue.take();
    tryTakingOrCatchingError(queue);
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
  assertEquals(queueIsEmpty,
          assertThrows(Error.class,
                  ()->new Queue().head()).getMessage());
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
  
  Queue queueWithSomethingElement() {
		return new Queue().add( somethingElement );
	}
  
  void tryTakingOrCatchingError(Queue queue) {
    Error e = assertThrows(Error.class, ()-> queue.take());
	}
  private static Queue queueWithFirstAndSecondObject() {
    Queue queue = new Queue();
    queue.add( firstObject );
    queue.add( secondObject );
    return queue;
  }
}