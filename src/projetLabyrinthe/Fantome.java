package projetLabyrinthe;

// Monstre qui se deplace en passant à travers les murs

public class Fantome extends Monstre
{
	// A refaire propre
	public Fantome(int xx, int yy, int h, int v, LabyFichier Lab)
	{
		super(xx,yy,h,v,Lab);
		this.tilePerso='F';
	}

	/*// Edit du deplacement de Personnage
	public boolean deplacementPossible(char direction, LabyFichier Labyrinthe)
	{

	}*/

	// A faire
	/*public char deplacementIntelligent()
	{

	}*/
}
