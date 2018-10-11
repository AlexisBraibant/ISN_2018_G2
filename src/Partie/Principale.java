package Partie;

import java.io.IOException;

import projetLabyrinthe.Heros;
import projetLabyrinthe.LabyFichier;
import utilensemjava.Lecture;

public class Principale
{
	public static void main(String[] args) throws IOException
	{
		LabyFichier Labyrinthe = new LabyFichier("../../laby1.txt");

		Heros H = new Heros(Labyrinthe);
		Labyrinthe.afficheLaby();

		while (!H.isDead())
		{
			System.out.println("");
			char direction = Lecture.lireCaractere("Dans quel direction aller?(zqsd) : ");
			H.deplacement(direction, Labyrinthe);
			Labyrinthe.afficheLaby();
		}
	}
}
