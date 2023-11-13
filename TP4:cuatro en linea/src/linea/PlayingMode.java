package linea;


import java.util.ArrayList;
import java.util.Arrays;

public abstract class PlayingMode {
    protected char symbol;

    public static ArrayList<PlayingMode> playingModes = new ArrayList<PlayingMode>(Arrays.asList(new ModeA(), new ModeB(), new ModeC()));

    public static PlayingMode getModoDeJuegoFor( char aGameMode ){
        return playingModes.stream()
                .filter(gameMode -> gameMode.isSymbol(aGameMode))
                .findFirst()
                .orElseThrow( () -> new RuntimeException("Gamemode must be A, B or C.") );
    }

    public boolean isSymbol( char mode ) {
        return symbol == mode; }

    public abstract boolean checkWin(char slotSymbol, Linea game);
}
