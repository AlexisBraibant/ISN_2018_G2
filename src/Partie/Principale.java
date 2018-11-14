package Partie;

import java.io.IOException;

import projetLabyrinthe.Fenetre;
import projetLabyrinthe.Heros;
import projetLabyrinthe.LabyFichier;
import projetLabyrinthe.Monstre;
import utilensemjava.Lecture;

public class Principale
{
	public static void main(String[] args) throws IOException
	{
		testSprint2_Monstre();
	}

	private static void testSprint1() throws IOException
	{
		System.out.println("--- testSprint1: affichage console du laby + déplacement héros ---");
		boolean jouer = true;

		LabyFichier Labyrinthe = new LabyFichier("laby_special.txt");
		Heros H = new Heros(Labyrinthe);

		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			char direction = Lecture.lireCaractere("Dans quel direction aller?(zqsd) : ");
			H.deplacement(direction, Labyrinthe, jouer, 'H');
		}
	}

	private static void testSprint2_AffichageLaby() throws IOException
	{
		System.out.println("--- testSprint2_AffichageLaby ---");
		Fenetre fen = new Fenetre("laby_special.txt");

	}

	private static void testSprint2_Monstre() throws IOException
	{
		System.out.println("--- testSprint1: affichage console du laby + déplacement héros ---");
		boolean jouer = true;

		LabyFichier Labyrinthe = new LabyFichier("laby_special.txt");
		Heros H = new Heros(Labyrinthe);

		Monstre M = new Monstre(5, 5, 4, 4, Labyrinthe);

		System.out.println(H.isDead());
		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			String dir = Lecture.lireChaine("Dans quel direction aller?(zqsd) : ");
			char direction = dir.charAt(0);
			H.deplacement(direction, Labyrinthe, jouer, 'H');
			M.deplacement(M.deplacementAleatoirePo(Labyrinthe), Labyrinthe, jouer, 'M');
		}
	}
}