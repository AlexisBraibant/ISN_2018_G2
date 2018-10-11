package projetLabyrinthe;

public class Heros
{
	private int pointDeVie;
	private int degat;

	private boolean enVie;

	private int coorX = -1;
	private int coorY = -1;

	private char tile;

	public Heros(LabyFichier Lab)
	{
		this.pointDeVie = 3;
		this.degat = 1;
		this.enVie = true;

		for (int i = 0; i < Lab.map.length; i++)
		{
			for (int j = 0; j < Lab.map[0].length; j++)
			{

				System.out.println(i + "\n" + j);
				if (Lab.map[i][j] == 2)
				{
					this.coorX = i;
					this.coorY = j;

					tile = Lab.map[i][j];
					Lab.map[i][j] = 'H';
				}
			}
		}
	}

	public boolean isDead()
	{
		return !this.enVie;
	}

	public char getTile()
	{
		return this.tile;
	}

	public void deplacement(char direction, LabyFichier Labyrinthe)
	{
		if (deplacementPossible(direction, Labyrinthe))
		{
			switch (direction)
			{
				case 'z':
					Labyrinthe.map[this.coorX][this.coorY] = tile;
					coorY += 1;
					tile = Labyrinthe.map[this.coorX][this.coorY];
					Labyrinthe.map[this.coorX][this.coorY] = 'H';
					break;
				case 's':
					Labyrinthe.map[this.coorX][this.coorY] = tile;
					coorY += -1;
					tile = Labyrinthe.map[this.coorX][this.coorY];
					Labyrinthe.map[this.coorX][this.coorY] = 'H';
					break;
				case 'q':
					Labyrinthe.map[this.coorX][this.coorY] = tile;
					coorX += -1;
					tile = Labyrinthe.map[this.coorX][this.coorY];
					Labyrinthe.map[this.coorX][this.coorY] = 'H';
					break;
				case 'd':
					Labyrinthe.map[this.coorX][this.coorY] = tile;
					coorX += +1;
					tile = Labyrinthe.map[this.coorX][this.coorY];
					Labyrinthe.map[this.coorX][this.coorY] = 'H';
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

		if (Labyrinthe.map[xApres][yApres] == 1 || xApres < 0
				|| xApres > Labyrinthe.LARGEUR || yApres < 0
				|| yApres > Labyrinthe.HAUTEUR)
			return false;
		return true;
	}
}
