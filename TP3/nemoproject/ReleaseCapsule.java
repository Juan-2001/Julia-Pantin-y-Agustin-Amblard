package nemoproject;

public class ReleaseCapsule extends Commands {
    public Character character = 'm';

    public Nemo execute(Nemo nemo) {
        return nemo.releaseCapsule();
    }

    public boolean validCharacter(Character c) {
        return character == c;
    }
}