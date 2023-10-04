package nemoproject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class NemoTest {
   @Test public void test00WheresNemo() {
       // ( profundidad , posicion , rotacion )
       // rotacion : norte (0) sur(180) este() oeste
       // public int profundidad;
       assertEquals(0, new Nemo().getDepth());
       assertEquals(0, new Nemo().getPosition());
       assertEquals("norte" , new Nemo().getDirection());
      // esta en la superficie?
       // en que posicion esta?
       // para donde esta mirando?
   }
   @Test public void test01NoMovement() {
         assertEquals(0, new Nemo().move("").getDepth());
         assertEquals(0, new Nemo().move("").getPosition());
         assertEquals("norte" , new Nemo().move("").getDirection());
   }
   @Test public void test02Down() {
        assertEquals(-1, new Nemo().move("d").getDepth());
   }
   @Test public void test03Up() {
         assertEquals(1, new Nemo().move("u").getDepth());
   }
   @Test public void test04Right() {
         assertEquals("este", new Nemo().move("r").getDirection());
   }
   @Test public void test05Left() {
         assertEquals("oeste", new Nemo().move("l").getDirection());
   }
   @Test public void test06Forward() {
         assertEquals(1, new Nemo().move("f").getPosition());
   }
}
