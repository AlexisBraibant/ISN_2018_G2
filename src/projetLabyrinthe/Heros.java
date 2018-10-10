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

	public void deplacement(char direction)
	{
		if (deplacementPossible(direction))
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

	private boolean deplacementPossible(char direction)
	{
		// Dimension du labyrrinthe : 7 lignes, 10 colonnes
		if ((direction == 'z' && this.coorY + 1 < 7) && (direction == 's' && this.coorY - 1 > 0)
				&& (direction == 'q' && this.coorX - 1 > 0) && (direction == 'd' && this.coorX < 10))
			return true;
		return false;
	}
}
