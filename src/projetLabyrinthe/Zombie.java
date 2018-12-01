package projetLabyrinthe;

// Monstre qui se déplace de la meme maniere que le heros

public class Zombie extends Monstre
{
	public Zombie(int h, int v, LabyFichier Lab)
	{
		super(h, v, Lab);

		int x = 0;
		int y = 0;

		do
		{
			y = (int) (Math.random() * Lab.HAUTEUR);
			x = (int) (Math.random() * Lab.LARGEUR);

		} while (Lab.getMap()[x][y] != '#' && Lab.getMap()[x][y] != 'H' && Lab.getMap()[x][y] != 'Z'
				&& Lab.getMap()[x][y] != 'F');

		this.tilePerso = 'Z';
		Lab.setMap(x, y, this.tilePerso);
	}

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

	public char deplacementIntelligent(LabyFichier Lab)
	{
		// Not yet implemented
		return (Character) null;
	}
}
