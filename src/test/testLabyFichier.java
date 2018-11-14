package test;

import static org.junit.Assert.*;

import java.io.File;
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
			lecture_f = LabyFichier.lireFichier("laby_special.txt");
			boolean test=false;
			if (lecture_f==""){
				test=true;
			}
			assertTrue(test);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
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
		} catch (IOException e) {
			fail();
		}
	}

}


