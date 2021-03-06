package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import projetLabyrinthe.LabyFichier;
import utilensemjava.Fichier;

public class testLabyFichier {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("début du test");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("fin du test");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//Test qui dit si le fichier vide est bien pris en compte 
	@Test 
	public void TestFichierVide() {
		String lecture_f;
		try {
			lecture_f = LabyFichier.lireFichier("./Map/laby_vide.txt");
			assertEquals(lecture_f.length(),0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	//tester quand fichier n'existe pas
	@Test (expected = java.io.FileNotFoundException.class)
	public void TestFichierNonExist() throws FileNotFoundException {
		File f = new File("laby_nonex");
		BufferedReader fR = new BufferedReader(new FileReader(f));	
	}
	
	
	//taille non valide
	@Test ( expected = java.lang.AssertionError.class )
	public void testTailleNonValide() {
		String lecture_f;
		try {
			lecture_f = LabyFichier.lireFichier("laby_taille_nonval.txt");
			int [] taille = new int [lecture_f.length()];
			String [] toutes_lignes = lecture_f.split("\n");
			for (int i=0; i<toutes_lignes.length ;i++) {
				taille[i]=toutes_lignes[i].length();
			}
			for (int i=1; i<toutes_lignes.length ;i++) {
				assertEquals(taille[i-1], taille[i]);
			}
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test ( expected = java.lang.AssertionError.class )
	public void testCaracteresNonValides() throws Exception {
		String lecture_f;
		try {
			lecture_f = LabyFichier.lireFichier("labynonval.txt");
			boolean test=true;
			for (int i=0; i<lecture_f.length() ;i++) {
				if ((lecture_f.charAt(i)!='0')||(lecture_f.charAt(i)!='1')||(lecture_f.charAt(i)!='2')||(lecture_f.charAt(i)!='3')||(lecture_f.charAt(i)!='4')||(lecture_f.charAt(i)!='5')||(lecture_f.charAt(i)!='6')||(lecture_f.charAt(i)!='\n')) {
					test=false;
				}
			}
			assertTrue(test);
		} catch ( Exception e) {
			fail();
		}
	}
	
	@Test ( expected = java.lang.AssertionError.class )
	//retourne une erreur PREVENIR Alexis
	public void testCaracteresValides() {
		String lecture_f;
		try {
			lecture_f = LabyFichier.lireFichier("laby_special.txt");
			boolean test=true;
			for (int i=0; i<lecture_f.length() ;i++) {
				if ((lecture_f.charAt(i)!='0')||(lecture_f.charAt(i)!='1')||(lecture_f.charAt(i)!='2')||(lecture_f.charAt(i)!='3')||(lecture_f.charAt(i)!='4')||(lecture_f.charAt(i)!='5')||(lecture_f.charAt(i)!='6')||(lecture_f.charAt(i)!='\n')) {
					test=false;
				}
			}
			assertTrue(test);
		} catch (Exception e) {
			fail();
		}
	}

	
	//cases speciales == tests spécifiques
	//creer un laby qui regarde si c'est bien une case spé dans un fichier
	
}


