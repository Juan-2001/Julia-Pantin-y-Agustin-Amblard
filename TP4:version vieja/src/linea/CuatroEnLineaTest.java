package linea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CuatroEnLineaTest {
    @Test
    public void test01GameStartsFineWithA() {
        Linea game = createGame(6,7,'A');
        assertEquals(6, game.filas);
        assertEquals(7, game.columnas);
        assertEquals('A', game.winningVariant);
        assertFalse(game.finished());
    }

    @Test
    public void test02GameStartsFineWithB() {
        Linea game = createGame(6,7,'B');
        assertEquals(6, game.filas);
        assertEquals(7, game.columnas);
        assertEquals('B', game.winningVariant);
        assertFalse(game.finished());
    }

    @Test
    public void test03GameStartsFineWithC() {
        Linea game = createGame(6,7,'C');
        assertEquals(6, game.filas);
        assertEquals(7, game.columnas);
        assertEquals('C', game.winningVariant);
        assertFalse(game.finished());
    }


    private Linea createGame(int filas, int columnas, char gameType) {
        return new Linea(columnas,filas, gameType);
    }
}