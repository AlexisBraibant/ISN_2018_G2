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
	public boolean TestFichierVide(String nomFichier) throws ErreurFichier, IOException {
		String lecture_f=LabyFichier.lireFichier(nomFichier);
		boolean test=false;
		if (lecture_f==""){
			test=true;
		}
		return test;
	}

}


