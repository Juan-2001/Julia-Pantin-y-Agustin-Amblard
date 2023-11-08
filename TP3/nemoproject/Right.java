package nemoproject;

public class Right extends Commands {
    public Character character = 'r';

    public Nemo execute(Nemo nemo) {
        return nemo.turnRight();
    }

    public boolean validCharacter(Character c) {
        return character == c;
    }
}