package Partie;

import java.io.IOException;

import projetLabyrinthe.Fenetre;
import projetLabyrinthe.Heros;
import projetLabyrinthe.LabyFichier;
import utilensemjava.Lecture;

public class Principale
{
	public static void main(String[] args) throws IOException
	{
		testSprint2_AffichageLaby();
	}
	
	private static void testSprint1() throws IOException {
		System.out.println("--- testSprint1: affichage console du laby + d�placement h�ros ---");
		boolean jouer = true;

		LabyFichier Labyrinthe = new LabyFichier("laby_special.txt");
		Heros H = new Heros(Labyrinthe);

		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			char direction = Lecture.lireCaractere("Dans quel direction aller?(zqsd) : ");
			H.deplacement(direction, Labyrinthe, jouer);
		}
	}
	
	private static void testSprint2_AffichageLaby() throws IOException {
		System.out.println("--- testSprint2_AffichageLaby ---");
		Fenetre fen = new Fenetre("laby_special.txt");
		
				
	}
}
