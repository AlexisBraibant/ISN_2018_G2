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

		for (int i = 0; i < Lab.getMap().length; i++)
		{
			for (int j = 0; j < Lab.getMap()[0].length; j++)
			{
				if (Lab.getMap()[i][j] == 'E')
				{
					this.coorX = i;
					this.coorY = j;

					tile = Lab.getMap()[i][j];
					Lab.setMap(i, j, 'H');
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

	public void deplacement(char direction, LabyFichier Labyrinthe, boolean jouer)
	{
		char[][] map = Labyrinthe.getMap();

		if (deplacementPossible(direction, Labyrinthe))
		{
			switch (direction)
			{
				case 'z':
					map[this.coorX][this.coorY] = tile;
					coorX += -1;
					tile = map[this.coorX][this.coorY];
					map[this.coorX][this.coorY] = 'H';
					break;
				case 's':
					map[this.coorX][this.coorY] = tile;
					coorX += 1;
					tile = map[this.coorX][this.coorY];
					map[this.coorX][this.coorY] = 'H';
					break;
				case 'q':
					map[this.coorX][this.coorY] = tile;
					coorY += -1;
					tile = map[this.coorX][this.coorY];
					map[this.coorX][this.coorY] = 'H';
					break;
				case 'd':
					map[this.coorX][this.coorY] = tile;
					coorY += +1;
					tile = map[this.coorX][this.coorY];
					map[this.coorX][this.coorY] = 'H';
					break;
				case 'm':
					this.enVie = false;
					System.out.println("\n\nLa partie est terminée");
					break;
				default:
					System.out.println("~~~ Mauvais input ~~~\n");
					Labyrinthe.setMap(map);
			}
		}
	}

	private boolean deplacementPossible(char direction, LabyFichier Labyrinthe)
	{
		int xApres = this.coorX;
		int yApres = this.coorY;

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
		if (Labyrinthe.getMap()[xApres][yApres] == '#')
		{
			System.out.println("Collision mur");
			return false;
		}
		return true;
	}
}
