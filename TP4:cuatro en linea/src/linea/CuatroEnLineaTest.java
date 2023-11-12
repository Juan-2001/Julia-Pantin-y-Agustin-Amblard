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

    @Test
    public void test06InicializacionDiferentesDimensiones() {
        Linea juegoPequeño = createGame(4, 4, 'A');
        assertEquals(4, juegoPequeño.getFilas());
        assertEquals(4, juegoPequeño.getColumnas());

        Linea juegoGrande = new Linea(10, 10, 'B');
        assertEquals(10, juegoGrande.getFilas());
        assertEquals(10, juegoGrande.getColumnas());
    }
    @Test
    public void test07JugadorIncorrectoIntentaJugarPrimero() {
        Linea juego = createGame(6,7,'C');
        assertThrows(IllegalStateException.class, () -> juego.playBlueAt(0),
                "Debería lanzar una excepción si el jugador incorrecto intenta jugar primero");
    }

    @Test
    public void test08AlternanciaDeTurnos() {
        Linea juego = createGame(6,7,'C');
        juego.playRedAt(0);
        assertTrue(juego.getEstadoActual() instanceof JuegaAzul);

        juego.playBlueAt(1);
        assertTrue(juego.getEstadoActual() instanceof JuegaRojo);
    }

    @Test
    public void test09VictoriaHorizontal() {
        Linea juego = new Linea(7, 6, 'A');
        // Asegúrate de que esta secuencia de jugadas resulte en una victoria horizontal para Rojo
        juego.playRedAt(0); // R-------
        juego.playBlueAt(6); // R------B
        juego.playRedAt(1); // RR-----B
        juego.playBlueAt(6); // RR-----BB
        juego.playRedAt(2); // RRR----BB
        juego.playBlueAt(6); // RRR----BBB
        juego.playRedAt(3); // RRRR---BBB
        assertTrue(juego.finished());
        assertTrue(juego.getEstadoActual() instanceof GameOver);
    }

    @Test
    public void test10EmpateTableroCompleto() {
        Linea juego = createGame(3,3,'C');
        juego.playRedAt(0); // R--
        juego.playBlueAt(1); // -B-
        juego.playRedAt(2); // --R
        juego.playBlueAt(0); // RB-
        juego.playRedAt(1); // RBR
        juego.playBlueAt(2); // RBR
        juego.playRedAt(0); // RBR
        juego.playBlueAt(1); // RBB
        juego.playRedAt(2); // RBR
        assertTrue(juego.finished());
        assertTrue(juego.getEstadoActual() instanceof GameOver);
    }
    @Test
    public void test11JugadaEnColumnaLlena() {
        Linea juego = createGame(6,7,'C');
        for (int i = 0; i < 6; i++) {
            juego.playRedAt(0);
            if (juego.finished()) {
                break; // Detiene el test si el juego ha terminado
            }
            if (i < 5) {
                juego.playBlueAt(1); // Jugar en otra columna para cambiar el turno
                if (juego.finished()) {
                    break; // Detiene el test si el juego ha terminado
                }}}
        assertThrows(IllegalStateException.class, () -> juego.playRedAt(0),
                "Debería lanzar una excepción si se intenta jugar en una columna llena");
    }
    @Test
    public void test12VictoriaDiagonalDescendente() {
        //hacer el test victoria diagonal descendente
    }
    @Test
    public void test13JugarDespuesDeFinDelJuego() {
        Linea juego = createGame(6,7,'C');
        for (int i = 0; i < 6; i++) {
            juego.playRedAt(0);
            if (juego.finished()) {
                break; // Detiene el test si el juego ha terminado
            }
            if (i < 5) {
                juego.playBlueAt(1); // Jugar en otra columna para cambiar el turno
                if (juego.finished()) {
                    break; // Detiene el test si el juego ha terminado
                }}}
        assertThrows(IllegalStateException.class, () -> juego.playBlueAt(0),
                "Debería lanzar una excepción si se intenta jugar después de que el juego haya terminado");
    }
    @Test
    public void test14JugadasEnElMismoLugar() {
        Linea game = createGame(6, 7, 'A');
        game.playRedAt(0);
        assertThrows(IllegalStateException.class, () -> game.playRedAt(0)); // Cambiado a jugar rojo nuevamente en la misma columna
    }
    @Test
    public void test15JugadaInvalida() {
        Linea game = createGame(6, 7, 'A');
        assertThrows(IndexOutOfBoundsException.class, () -> game.playRedAt(8)); // Cambiado a IndexOutOfBoundsException si es más apropiado
    }
    @Test
    public void test16EmpateConEspaciosLibres() {
        //hacer el test empate con espacios libres
        
    }
    @Test
    public void test17VictoriaVertical() {
        Linea game = createGame(6, 7, 'A');
        for (int i = 0; i < 4; i++) {
            game.playRedAt(0);
            if (i < 3) {
                game.playBlueAt(1);
            }
        }
        assertTrue(game.finished());
        assertTrue(game.getEstadoActual() instanceof GameOver);
    }
    @Test
    public void test18EmpateConTableroCompleto() {
        Linea game = createGame(3, 3, 'C');
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(2);
        assertTrue(game.finished());
        assertTrue(game.getEstadoActual() instanceof GameOver);
    }

    @Test
    public void test19ConfiguracionInicialInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Linea(6, 7, 'Z'));
    }

    private void makeMoves(Linea game, int[] moves) {
        for (int move : moves) {
            if (game.getEstadoActual() instanceof JuegaRojo) {
                game.playRedAt(move);
            } else if (game.getEstadoActual() instanceof JuegaAzul) {
                game.playBlueAt(move);
            }}}
    private Linea createGame(int filas, int columnas, char gameType) {
        return new Linea(columnas,filas, gameType);
    }
}