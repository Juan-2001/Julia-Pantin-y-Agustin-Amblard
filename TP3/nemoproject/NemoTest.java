package nemoproject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NemoTest {
   @Test public void test00WheresNemo() {
       assertEquals(0, new Nemo().getDepth());
       assertArrayEquals(new int[]{0, 0}, new Nemo().getPosition());
       assertEquals("norte" , new Nemo().getDirection());
   }

  @Test public void test01NoMovement() {
         assertEquals(0, new Nemo().move("").getDepth());
         assertArrayEquals(new int[] {0,0}, new Nemo().move("").getPosition());
         assertEquals("norte" , new Nemo().move("").getDirection());
   }
  
  @Test public void test02MovesDown() {
        assertEquals(-1, new Nemo().move("d").getDepth());
  }
  @Test public void test03MovesUp() {
         assertEquals(1, new Nemo().move("u").getDepth());
  }
   @Test public void test04RotatesRight() {
         assertEquals("este", new Nemo().move("r").getDirection());
   }
   @Test public void test05RotatesLeft() {
         assertEquals("oeste", new Nemo().move("l").getDirection());
   }
   @Test public void test06MovesForward() {
         assertArrayEquals(new int[] {0,1}, new Nemo().move("f").getPosition());
   }
         
  @Test public void test07RotationChangesForward() {
	  assertArrayEquals(new int[] {1,1}, new Nemo().move("frf").getPosition());
   }
   @Test public void test08CompoundMovement() {
	   String command = "ddudflflr";
	   assertEquals(-2, new Nemo().move(command).getDepth());
	   assertEquals("oeste", new Nemo().move(command).getDirection());
	   assertArrayEquals(new int[] {-1,1}, new Nemo().move(command).getPosition());
   }
}
