package projetLabyrinthe;

public class Heros extends Personnage
{


	public Heros(LabyFichier Lab)
	{
		super(-1,-1,10,10);
		this.degat = 1;

		for (int i = 0; i < Lab.getMap().length; i++)
		{
			for (int j = 0; j < Lab.getMap()[0].length; j++)
			{
				if (Lab.getMap()[i][j] == 'E')
				{
					this.coorX = i;
					this.coorY = j;

					this.tile = Lab.getMap()[i][j];
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

	

	
}
