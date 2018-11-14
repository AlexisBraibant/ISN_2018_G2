package projetLabyrinthe;

// Monstre qui se déplace de la meme maniere que le heros

public class Zombie extends Monstre
{
	Zombie(LabyFichier Lab)
	{
		super(1, 1, 2, 2, Lab);
		this.tilePerso = 'Z';
	}

	public char deplacementAleatoire(LabyFichier Lab)
	{
		char dir_al;
		boolean deplPoss;
		do
		{
			dir_al = this.directionAleatoire();
			deplPoss = this.deplacementPossible(dir_al, Lab);
		} while (!deplPoss);
		return dir_al;
	}
}
