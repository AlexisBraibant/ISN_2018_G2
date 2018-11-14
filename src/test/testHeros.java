package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.udl.acl.conteneur.ErreurConteneur;
import projetLabyrinthe.Heros;
import projetLabyrinthe.LabyFichier;

public class testHeros {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetHp() throws IOException {
		LabyFichier Labyrinthe = new LabyFichier("laby_special.txt");
		Heros H = new Heros(Labyrinthe);
		try {
			//H.setVie(0);
			H.setHp(0);
			assertTrue(H.isDead());
		}catch (ErreurHeros e) {
			fail();
		}
	}

}
