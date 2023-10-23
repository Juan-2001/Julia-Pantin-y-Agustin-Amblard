package nemoproject;

public class Up extends Commands {
    public Character character = 'u';

    public Nemo execute(Nemo nemo) {
        return nemo.ascend();
    }

    public boolean validCharacter(Character c) {
        return character == c;
    }
}