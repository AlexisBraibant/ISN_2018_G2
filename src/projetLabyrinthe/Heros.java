package projetLabyrinthe;

import java.util.ArrayList;

public class Heros extends Personnage
{

	public int bourse;

	public Heros(LabyFichier Lab)
	{
		super(-1, -1, 10, 10); // On met le héros au position -1 -1 et apres on le remet sur l'entrée du niveau
								// qui est un E (ici ligne 18)
		this.degat = 1;
		this.enVie = true;
		this.tilePerso = 'H';

		for (int i = 0; i < Lab.getMap().length; i++)
		{
			for (int j = 0; j < Lab.getMap()[0].length; j++)
			{
				if (Lab.getMap()[i][j] == 'E')
				{
					this.coorX = i;
					this.coorY = j;

					this.tile = Lab.getMap()[i][j];
					Lab.setMap(i, j, tilePerso);
				}
			}
		}
	}

	public Heros(LabyFichier Lab, int hp, int vie)
	{
		super(-1, -1, hp, vie); // On met le héros au position -1 -1 et apres on le remet sur l'entrée du niveau
								// qui est un E (ici ligne 18)
		this.degat = 1;
		this.enVie = true;
		this.tilePerso = 'H';

		for (int i = 0; i < Lab.getMap().length; i++)
		{
			for (int j = 0; j < Lab.getMap()[0].length; j++)
			{
				if (Lab.getMap()[i][j] == 'E')
				{
					this.coorX = i;
					this.coorY = j;

					this.tile = Lab.getMap()[i][j];
					Lab.setMap(i, j, tilePerso);
				}
			}
		}
	}

	public Heros(LabyFichier Lab, int hp, int vie, int bourse, ArrayList<Personnage> listePersonnages)
	{
		super(-1, -1, hp, vie); // On met le héros au position -1 -1 et apres on le remet sur l'entrée du niveau
								// qui est un E (ici ligne 18)
		this.degat = 1;
		this.enVie = true;
		this.tilePerso = 'H';
		this.bourse = bourse;

		for (int i = 0; i < Lab.getMap().length; i++)
		{
			for (int j = 0; j < Lab.getMap()[0].length; j++)
			{
				if (Lab.getMap()[i][j] == 'E')
				{
					this.coorX = i;
					this.coorY = j;

					this.tile = Lab.getMap()[i][j];
					Lab.setMap(i, j, tilePerso);
				}
			}
		}
		listePersonnages.add(this);
	}

	public String getNom()
	{
		return "Heros";
	}
}
