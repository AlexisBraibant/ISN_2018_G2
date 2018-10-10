package projetLabyrinthe;

public class Heros
{
	int pointDeVie;
	int degat;

	boolean enVie;

	int coorX = -1;
	int coorY = -1;

	public Heros(LabyFichier Lab)
	{
		this.pointDeVie = 3;
		this.degat = 1;
		this.enVie = true;

		for (int i = 0; i < Lab.map.length; i++)
		{
			for (int j = 0; j < Lab.map[0].length; j++)
			{
				if (Lab.map[i][j] == 2)
				{
					this.coorX = i;
					this.coorY = j;
				}
			}
		}
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

		int xApres = this.coorX;
		int yApres = this.coorY;

		if (direction == 'z')
			yApres += 1;
		if (direction == 's')
			yApres -= 1;
		if (direction == 'q')
			xApres -= 1;
		if (direction == 'd')
			xApres += 1;

		if (Labyrinthe.map[xApres][yApres] == 1 || xApres < 0 || xApres > Labyrinthe.LARGEUR || yApres < 0
				|| yApres > Labyrinthe.HAUTEUR)
			return false;
		return true;
	}
}
