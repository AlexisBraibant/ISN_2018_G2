package projetLabyrinthe;

import java.util.ArrayList;

public abstract class Monstre extends Personnage
{

	public Monstre(int xx, int yy, int h, int v, LabyFichier Lab)
	{
		this.coorX = xx;
		this.coorY = yy;
		this.hp = h;
		this.vie = v;
		this.tile = Lab.getMap()[coorX][coorY];
		this.enVie = true;
		this.degat = 1;
	}

	public char directionAleatoire()
	{
		char[] liste_dir =
			{ 'z', 'q', 's', 'd' };
		int aleat = (int) (Math.random() * 4);
		return liste_dir[aleat];
	}

	public String getNom()
	{
		return "Monstre";
	}

	public static void deplacementDesMonstre(LabyFichier Labyrinthe, boolean jouer, ArrayList<Zombie> listeZombie,
			ArrayList<Fantome> listeFantome, ArrayList<Personnage> listePersonnage)
	{
		for (int i = 0; i < listeZombie.size(); i++)
		{
			Zombie temp = listeZombie.get(i);
			temp.deplacementCollision(temp.directionAleatoire(), Labyrinthe, jouer, temp.tilePerso, listePersonnage);
		}

		for (int i = 0; i < listeFantome.size(); i++)
		{
			Fantome temp = listeFantome.get(i);
			temp.deplacementCollision(temp.directionAleatoire(), Labyrinthe, jouer, temp.tilePerso, listePersonnage);
		}
	}
}
