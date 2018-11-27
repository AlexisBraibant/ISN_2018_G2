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

	// Edit du deplacement de Personnage
		public boolean deplacementPossibleFantome(char direction, LabyFichier Labyrinthe)
	{
		int xApres = this.coorX;
		int yApres = this.coorY;

		//traitement du sens du déplacement et si c'est un mur
		if (direction == 'z') 
			xApres -= 1;
			
		
		if (direction == 's')
			xApres += 1;
			
		if (direction == 'q')
			yApres -= 1;
			
			
		if (direction == 'd')
			yApres += 1;
		
		if (xApres < 0 || xApres >= Labyrinthe.HAUTEUR || yApres < 0 || yApres >= Labyrinthe.LARGEUR)
		{
			return false;
		}
		System.out.println();
		return true;
	}
	

		public char deplacementAleatoire(LabyFichier Lab)
		{
			char dir_al;
			boolean deplPoss;
			do
			{
				dir_al = this.directionAleatoire();
				deplPoss = this.deplacementPossibleFantome(dir_al, Lab);
			} while (!deplPoss);
			return dir_al;
		}
		
		
	// A faire
	/*public char deplacementIntelligent()
	{

	}*/
}
