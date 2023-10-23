package nemoproject;

public class Forward extends Commands{
	public Character character = 'f';
	
	public Nemo execute(Nemo nemo) {
		nemo.forward();
		return nemo;
	}
	public boolean validCharacter(Character c) {
		return character ==c;
	}
}