package nemoproject;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class NemoTest {
   private static final String EL_SUBMARINO_EXPLOTA = "El submarino explota.";




@Test public void test00WheresNemo() {
       assertEquals(0, nemoAtSurfaceAndOrigin().getDepth());
       assertArrayEquals(new int[]{0, 0}, nemoAtSurfaceAndOrigin().getPosition());
       assertEquals("norte" , nemoAtSurfaceAndOrigin().getDirection());
   }

  @Test public void test01NoMovement() {
         assertEquals(0, nemoAtSurfaceAndOrigin().move("").getDepth());
         assertArrayEquals(new int[] {0,0},nemoAtSurfaceAndOrigin().move("").getPosition());
         assertEquals("norte" , nemoAtSurfaceAndOrigin().move("").getDirection());
   }
<<<<<<< Updated upstream
  
=======

>>>>>>> Stashed changes
  @Test public void test02MovesDown() {
        assertEquals(-1, nemoAtSurfaceAndOrigin().move("d").getDepth());
  }
  @Test public void test03MovesUp() {
         assertEquals(0, nemoAtBelowSurfaceAndOrigin().move("u").getDepth());
  }


@Test public void test04RotatesRight() {
         assertEquals("este", nemoAtSurfaceAndOrigin().move("r").getDirection());
   }
@Test public void test05RotatesLeft() {
         assertEquals("oeste", nemoAtSurfaceAndOrigin().move("l").getDirection());
   }
   @Test public void test06MovesForward() {
<<<<<<< Updated upstream
         assertArrayEquals(new int[] {0,1},nemoAtSurfaceAndOrigin().move("f").getPosition());
   }
   @Test public void test07ReleaseCapsuleInSurfaceDoesNotExplodeNemo() {
	   assertNotEquals(EL_SUBMARINO_EXPLOTA, nemoAtSurfaceAndOrigin().move("m"));
   }
   @Test public void test08ReleaseCapsuleInBelowSurfaceDoesNotExplodeNemo() {
	   assertNotEquals(EL_SUBMARINO_EXPLOTA, nemoAtSurfaceAndOrigin().move("dm"));
   }
   @Test public void test09ReleaseCapsuleInSubmergedExplodesNemo() {
	    assertEquals("El submarino explota.",
	            assertThrows(RuntimeException.class,
	                    () -> nemoAtSurfaceAndOrigin().move("ddm").releaseCapsule()).getMessage());
	}
   @Test public void test11NemoDoesNotGoAboveSurface() {
	   assertEquals(0, nemoAtSurfaceAndOrigin().move("u").getDepth());
   }
  @Test public void test11RotationChangesForward() {
	  assertArrayEquals(new int[] {1,1}, nemoAtSurfaceAndOrigin().move("frf").getPosition());
   }
   @Test public void test12CompoundMovement() {
       String command = "ddudflflr";
       assertEquals(-2, nemoAtSurfaceAndOrigin().move(command).getDepth());
       assertEquals("oeste", nemoAtSurfaceAndOrigin().move(command).getDirection());
       assertArrayEquals(new int[]{-1, 1},nemoAtSurfaceAndOrigin().move(command).getPosition());
   }
   



public Nemo nemoAtSurfaceAndOrigin() {
	return new Nemo (0,0,new Surface(),new North());
}
public Nemo nemoAtBelowSurfaceAndOrigin() {
	return new Nemo (0,0,new BelowSurface(),new North());
}
}
=======
         assertArrayEquals(new int[] {0,1}, new Nemo().move("f").getPosition());
   }
         
  @Test public void test07RotationChangesForward() {
	  assertArrayEquals(new int[] {1,1}, new Nemo().move("frf").getPosition());
   }
   @Test public void test08CompoundMovement() {
       String command = "ddudflflr";
       assertEquals(-2, new Nemo().move(command).getDepth());
       assertEquals("oeste", new Nemo().move(command).getDirection());
       assertArrayEquals(new int[]{-1, 1}, new Nemo().move(command).getPosition());
   }}
>>>>>>> Stashed changes
