package nemoproject;

public class Down extends Commands {
    public Character character = 'd';

    public Nemo execute(Nemo nemo) {
        return nemo.descend();
    }

    public boolean validCharacter(Character c) {
        return character == c;
    }
}