package projetLabyrinthe;

public class Heros
{
	int pointDeVie;
	int degat;

	boolean enVie;

	int coorX;
	int coorY;

	public Heros(int entreeX, int entreeY)
	{
		this.pointDeVie = 3;
		this.degat = 1;
		this.enVie = true;
		this.coorX = entreeX;
		this.coorY = entreeY;
	}

	public void deplacement(char direction, LabyFichier Labyrinthe)
	{
		if (deplacementPossible(direction, Labyrinthe))
		{
			switch (direction)
			{
				case 'z':
					coorY += 1;
					break;
				case 's':
					coorY += -1;
					break;
				case 'q':
					coorX += -1;
					break;
				case 'd':
					coorX += +1;
					break;
				default:
					System.out.println("Mauvais input");
			}
		}
	}

	private boolean deplacementPossible(char direction, LabyFichier Labyrinthe)
	{
		// Dimension du labyrrinthe : 7 lignes, 10 colonnes

		int largeur = Labyrinthe.LARGEUR;
		int hauteur = Labyrinthe.HAUTEUR;

		int xApres = this.coorX;
		int yApres = this.coorY;

		if (direction == 'z') yApres += 1;
		if (direction == 's') yApres -= 1;
		if (direction == 'q') xApres -= 1;
		if (direction == 'd') xApres += 1;

		if (Labyrinthe.map[xApres][yApres] == 1)
			return false;
		return true;
	}
}
