package test;

import java.io.IOException;

public class UsageTest {

	public static void main(String[] args) throws ErreurFichier, IOException {
		// TODO Auto-generated method stub

		//testLabyFichier
		boolean test_non_vide=testLabyFichier.TestFichierVide("laby1.txt");
		System.out.println("Le test pour le fichier non vide doit renvoyer False, il renvoit : "+test_non_vide);
		
		boolean test_vide=testLabyFichier.TestFichierVide("laby_vide.txt");
		System.out.println("Le test pour le fichier vide doit renvoyer une erreur, il renvoit : "+test_vide);
	}

}
