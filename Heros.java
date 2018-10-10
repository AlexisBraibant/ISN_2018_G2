package projetLabyrinthe;

public class Heros
{
	int pointDeVie;
	int degat;

	boolean enVie;

	int coorX;
	int coorY;

	public Heros()
	{
		this.pointDeVie = 3;
		this.degat = 1;
		this.enVie = true;
		this.coorX = 0;
		this.coorY = 0;
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
		return true;
	}
}
