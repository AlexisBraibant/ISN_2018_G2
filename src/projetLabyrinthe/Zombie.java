package projetLabyrinthe;

import java.util.ArrayList;

// Monstre qui se déplace de la meme maniere que le heros

public class Zombie extends Monstre
{
	public Zombie(int h, int v, LabyFichier Lab, ArrayList<Zombie> listeZombie, ArrayList<Personnage> listePersonnages)
	{
		super(h, v, Lab);

		int x = 0;
		int y = 0;

		do
		{
			x = (int) (Math.random() * Lab.HAUTEUR);
			y = (int) (Math.random() * Lab.LARGEUR);

		} while (!(Lab.getMap()[x][y] != '#' && Lab.getMap()[x][y] != 'H' && Lab.getMap()[x][y] != 'Z'
				&& Lab.getMap()[x][y] != 'F'));

		this.tilePerso = 'Z';

		this.coorX = x;
		this.coorY = y;

		this.tile = Lab.getMap()[coorX][coorY];
		Lab.setMap(x, y, this.tilePerso);

		listeZombie.add(this);
		listePersonnages.add(this);
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
