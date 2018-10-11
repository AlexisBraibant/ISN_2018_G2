package Partie;

import java.io.IOException;

import projetLabyrinthe.Heros;
import projetLabyrinthe.LabyFichier;
import utilensemjava.Lecture;

public class Principale
{
	public static void main(String[] args) throws IOException
	{
		boolean jouer = true;

		LabyFichier Labyrinthe = new LabyFichier("../../laby1.txt");

		Heros H = new Heros(Labyrinthe);
		Labyrinthe.afficheLaby();

		while (!H.isDead() || jouer)
		{
			System.out.println("");
			char direction = Lecture.lireCaractere("Dans quel direction aller?(zqsd) : ");
			if (direction == 'm') // Retourner sur le menu, dans un premier quitte le jeu
				jouer = false;
			H.deplacement(direction, Labyrinthe, jouer);
			Labyrinthe.afficheLaby();
		}
	}
}
