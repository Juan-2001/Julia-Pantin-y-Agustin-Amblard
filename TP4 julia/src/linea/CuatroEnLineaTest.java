package linea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class CuatroEnLineaTest {
    @Test
    public void test01GameStartsFineWithA() {
        Linea game = createGame(6,7,'A');
        assertEquals(6, game.getFilas());
        assertEquals(7, game.getColumnas());
        assertFalse(game.finished());
        assertTrue(game.isEsTurnoRojas()); // Las rojas comienzan después de la creación del juego
    }

    @Test
    public void test02GameStartsFineWithB() {
        Linea game = createGame(6,7,'B');
        assertEquals(6, game.getFilas());
        assertEquals(7, game.getColumnas());
        assertFalse(game.finished());
        assertTrue(game.isEsTurnoRojas()); // Las rojas comienzan después de la creación del juego
    }

    @Test
    public void test03GameStartsFineWithC() {
        Linea game = createGame(6,7,'C');
        assertEquals(6, game.getFilas());
        assertEquals(7, game.getColumnas());
        assertFalse(game.finished());
        assertTrue(game.isEsTurnoRojas()); // Las rojas comienzan después de la creación del juego
    }

    @Test
    public void test04PlayUntilWin() {
        Linea game = createGame(4,4,'A');
        assertFalse(game.finished());
        game.playRedAt(0);  // R---
        game.playBlueAt(1);  // -B--
        game.playRedAt(0);  // R---
        game.playBlueAt(1);  // -B--
        game.playRedAt(0);  // R---
        game.playBlueAt(1);  // -B--
        game.playRedAt(0);  // R---
        assertTrue(game.finished());
    }

    @Test
    public void test05PlayUntilDraw() {
        Linea game = createGame(3,3,'C');
        assertFalse(game.finished());
        game.playRedAt(0); // R--
        game.playBlueAt(0); // R--
        game.playRedAt(0); // R--
        game.playBlueAt(1); // -B-
        game.playRedAt(1); // -BR
        game.playBlueAt(1); // -BB
        game.playRedAt(2); // --R
        game.playBlueAt(2); // --B
        game.playRedAt(2); // --R
        assertTrue(game.finished());
    }

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