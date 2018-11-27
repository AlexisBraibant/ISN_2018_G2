package Partie;

import java.io.IOException;

import projetLabyrinthe.Fantome;
import projetLabyrinthe.Fenetre;
import projetLabyrinthe.Heros;
import projetLabyrinthe.LabyFichier;
import projetLabyrinthe.Zombie;
import utilensemjava.Lecture;

public class Principale
{
	public static void main(String[] args) throws IOException
	{
		//testSprint3_Zombie();
		testSprint2_AffichageLaby();
		//testSprint3_Fantome();
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
		Fenetre fen = new Fenetre();
	}

	/*private static void testSprint2_Monstre() throws IOException
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
			//M.deplacement(M.deplacementAleatoirePo(Labyrinthe), Labyrinthe, jouer, 'M');
		}
	}*/

	private static void testSprint3_Zombie() throws IOException
	{
		System.out.println(
				"--- testSprint3: affichage console du laby + déplacement héros + deplacement zombie (sans gestion de collision)");
		boolean jouer = true;

		LabyFichier Labyrinthe = new LabyFichier("niv1.txt");

		Heros H = new Heros(Labyrinthe);
		Zombie Z = new Zombie(5, 5, 4, 4, Labyrinthe);

		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			String dir = Lecture.lireChaine("Dans quel direction aller?(zqsd) : ");
			char direction = dir.charAt(0);
			H.deplacement(direction, Labyrinthe, jouer, 'H');
			Z.deplacement(Z.deplacementAleatoire(Labyrinthe), Labyrinthe, jouer, Z.getTilePerso());
		}
	}

	private static void testSprint3_Fantome() throws IOException
	{
		System.out.println(
				"--- testSprint3: affichage console du laby + déplacement héros + deplacement fantome (sans gestion de collision)");
		boolean jouer = true;

		LabyFichier Labyrinthe = new LabyFichier("niv1.txt");

		Heros H = new Heros(Labyrinthe);
		Fantome F = new Fantome(5, 5, 4, 4, Labyrinthe);

		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			String dir = Lecture.lireChaine("Dans quel direction aller?(zqsd) : ");
			char direction = dir.charAt(0);
			H.deplacement(direction, Labyrinthe, jouer, 'H');
			F.deplacement(F.deplacementAleatoire(Labyrinthe), Labyrinthe, jouer, F.getTilePerso());
		}
	}

	private static void testSprint3_1Zombie() throws IOException
	{
		// Créer une liste de monstres et tester qu'on les tue et qu'ils disparaissent.
	}
}