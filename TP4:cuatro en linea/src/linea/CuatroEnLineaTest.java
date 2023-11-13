package linea;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuatroEnLineaTest {
    private Linea game;

    @BeforeEach
    public void commonStar() {
        game = new Linea(4, 4, 'A');
    }

    @AfterEach
    public void printGame() {
        System.out.println(game.show());
    }

    @Test
    public void test01RedStarts() {
        assertEquals(new JuegaRojo(), game.getStatus());
    }

    @Test
    public void test02CannotStartOnInvalidGameMode() {
        assertThrowsError(() -> new Linea(4, 4, 'E'), "Gamemode must be A, B or C.");
    }
    @Test
    public void test03BaseAndHeightMustBeBiggerThan3() {
        assertThrowsError(() -> new Linea(3, 4, 'A'), "Base and height have to be above 3.");
    }
    @Test
    public void test04CannotPlayOutsideTheBoard() {
        assertThrowsError(() -> game.playRedAt(5), "The column is not between 1 and 4");
    }
    @Test
    public void test05BlueCanNotPlayWhenItsRedsTurn() {
        assertThrowsError(() -> game.playBlueAt(1), "Not blue turn");
    }
    @Test
    public void test06RedCanNotPlayWhenItsBluesTurn() {
        playGame(1);
        assertThrowsError(() -> game.playRedAt(1), "Not red's turn");
    }
    @Test
    public void test07CannotPlayOnAFullColumn() {
        assertThrowsError(() -> playGame(3,3,3,3,3), "Column 3 is full.");
    }
    @Test
    public void test08ModeAPlayerWinsHorizontally() {
        assertEquals(redWins(), playGame(1, 1, 2, 2, 3, 3, 4).getStatus());
    }
    @Test
    public void test09ModeABlueWinsHorizontally() {
        assertEquals(blueWins(), playGame(1, 2, 3, 1, 4, 2, 1, 3, 2,4).getStatus());
    }
    @Test
    public void test10ModeARedWinsVertically() {
        assertEquals(redWins(), playGame(1, 2, 1, 2, 1, 2, 1).getStatus());
    }

    @Test
    public void test11ModeABlueWinsVertically() {
        assertEquals(blueWins(), playGame(1, 2, 3, 2, 4, 2, 1, 2).getStatus());
    }
    @Test
    public void test12ModeADrawIsPossible() {
        assertEquals(empate(), playGame(1, 2, 3, 4, 1, 2, 3, 4, 2, 1, 4, 3, 2, 1, 4, 3).getStatus());
    }
    @Test
    public void test13ModeBRedWinsDiagonally() {
        game = GameB();
        assertEquals(redWins(), playGame(1, 2, 2, 3, 4, 3, 3, 4, 3, 4, 4).getStatus());
    }
    @Test
    public void test14ModeBPBlueWinsDiagonally() {
        game = GameB();
        assertEquals(blueWins(), playGame(1, 2, 3, 4, 1, 3, 2, 2, 1, 1).getStatus());
    }
    @Test
    public void test15ModeBDrawIsPossible() {
        game = GameB();
        assertEquals(empate(), playGame(1, 2, 3, 4, 1, 2, 3, 4, 2, 1, 4, 3, 2, 1, 4, 3).getStatus());
    }
    @Test
    public void test16ModeCPRedWinsHorizontally() {
        game = GameC();
        assertEquals(redWins(), playGame(1, 1, 2, 2, 3, 3, 4).getStatus());
    }
    @Test
    public void test17ModeCBlueWinsHorizontally() {
        game = GameC();
        assertEquals(blueWins(),playGame(1, 2, 3, 1, 4, 2, 1, 3, 2,4).getStatus());
    }
    @Test
    public void test18ModeCRedWinsVertically() {
        game = GameC();
        assertEquals(redWins(), playGame(1, 2, 1, 2, 1, 2, 1).getStatus());
    }

    @Test
    public void test19ModeCBlueWinsVertically() {
        game = GameC();
        assertEquals(blueWins(), playGame(1, 2, 3, 2, 4, 2, 1, 2).getStatus());
    }

    @Test
    public void test20ModeCRedWinsDiagonally() {
        game = GameC();
        assertEquals(redWins(), playGame(1, 2, 2, 3, 4, 3, 3, 4, 3, 4, 4).getStatus());
    }

    @Test
    public void test21ModeCBlueWinsDiagonally() {
        game = GameC();
        assertEquals(blueWins(), playGame(1, 2, 3, 4, 1, 3, 2, 2, 1, 1).getStatus());
    }

    @Test
    public void test22ModeCDrawIsPossible() {
        game = GameC();
        assertEquals(empate(), playGame(1, 2, 3, 4, 1, 2, 3, 4, 2, 1, 4, 3, 2, 1, 4, 3).getStatus());
    }


    //Funciones

    private void assertThrowsError( Executable runnable, String expectedError ) {
        String actualError = assertThrows(RuntimeException.class, runnable, "Expected Error was not thrown.").getMessage();
        assertEquals(expectedError, actualError);
    }
    private Linea playGame(int ... jugadas) {
        for (int i = 0; i < jugadas.length; i += 2) {
            game.playRedAt(jugadas[i]);
            if (i + 1 ==  jugadas.length) break;
            game.playBlueAt(jugadas[i + 1]);
        }
        return game;
    }
    private Linea GameB() {
        return new Linea(4, 4, 'B');
    }
    private Linea GameC() {
        return new Linea(4, 4, 'C');
    }
    public EstadoJuego redWins() {
        return new GameOver('X');
    }
    public EstadoJuego blueWins() {
        return new GameOver('O');
    }
    public EstadoJuego empate() {
        return new Empate();
    }


}
