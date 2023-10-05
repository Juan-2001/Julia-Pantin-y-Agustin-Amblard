package nemoproject;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
  
  
  @Test public void test02Movement() {
        assertEquals(-1, new Nemo().move("d").getDepth());
         assertEquals(1, new Nemo().move("u").getDepth());
         assertEquals("este", new Nemo().move("r").getDirection());
         assertEquals("oeste", new Nemo().move("l").getDirection());
         assertArrayEquals(new int[] {0,1}, new Nemo().move("f").getPosition());
   }
  
}
