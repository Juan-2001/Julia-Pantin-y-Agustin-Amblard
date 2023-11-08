package nemoproject;

public class Left extends Commands {
    public Character character = 'l';

    public Nemo execute(Nemo nemo) {
        return nemo.turnLeft();
    }

    public boolean validCharacter(Character c) {
        return character == c;
    }
}