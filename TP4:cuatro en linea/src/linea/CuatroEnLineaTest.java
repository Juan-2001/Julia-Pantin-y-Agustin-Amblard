package linea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class CuatroEnLineaTest {
    @Test
    public void test01GameStartsFineWithA() {
        Linea game = createGame(6, 7, 'A');
        assertEquals(6, game.getFilas());
        assertEquals(7, game.getColumnas());
        assertFalse(game.finished());
        assertEquals("> Playing Red <", game.getEstadoActual().jugadorActual()); // Comprobar que las rojas comienzan
    }

    @Test
    public void test02GameStartsFineWithB() {
        Linea game = createGame(6, 7, 'B');
        assertEquals(6, game.getFilas());
        assertEquals(7, game.getColumnas());
        assertFalse(game.finished());
        assertEquals("> Playing Red <", game.getEstadoActual().jugadorActual()); // Comprobar que las rojas comienzan
    }

    @Test
    public void test03GameStartsFineWithC() {
        Linea game = createGame(6, 7, 'C');
        assertEquals(6, game.getFilas());
        assertEquals(7, game.getColumnas());
        assertFalse(game.finished());
        assertEquals("> Playing Red <", game.getEstadoActual().jugadorActual()); // Comprobar que las rojas comienzan
    }

    @Test
    public void test04PlayUntilWin() {
        Linea game = createGame(4, 4, 'A');
        assertFalse(game.finished());
        makeMoves(game, new int[]{0, 1, 0, 1, 0, 1, 0});
        assertTrue(game.finished());
        assertTrue(game.getEstadoActual() instanceof GameOver); // Comprobar que el estado es GameOver
    }


    @Test
    public void test05PlayUntilDraw() {
        Linea game = createGame(3, 3, 'C');
        assertFalse(game.finished());
        makeMoves(game, new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2});
        assertTrue(game.finished());
        assertTrue(game.getEstadoActual() instanceof GameOver); // Comprobar que el estado es GameOver
    }
    private void makeMoves(Linea game, int[] moves) {
        for (int move : moves) {
            if (game.getEstadoActual() instanceof JuegaRojo) {
                game.playRedAt(move);
            } else if (game.getEstadoActual() instanceof JuegaAzul) {
                game.playBlueAt(move);
            }
        }
    }
    // no estamos usando printBoart() pero la tenemos por si llega a ser necesaria
    private void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private Linea createGame(int filas, int columnas, char gameType) {
        return new Linea(columnas,filas, gameType);
    }
}