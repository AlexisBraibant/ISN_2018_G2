package projetLabyrinthe;

// Monstre qui se déplace de la meme maniere que le heros

public class Zombie extends Monstre
{
	public Zombie(int x, int y, int h, int v, LabyFichier Lab)
	{
		super(x, y, h, v, Lab);
		this.tilePerso = 'Z';
		Lab.setMap(x, y, this.tilePerso);
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
