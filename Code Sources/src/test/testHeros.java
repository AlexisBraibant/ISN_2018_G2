package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

	//teste l'initialisation du héros
	@Test
	public void testSetHp() {
		
		try {
			LabyFichier Labyrinthe = new LabyFichier("laby_special.txt");
			Heros H = new Heros(Labyrinthe);
			H.setVie(0);
			H.setHp(0);
			assertTrue(H.isDead());
		}catch (IOException e) {
			fail();
		}
	}
	
	//CORRIGER POINTS DE VIE
	
	//tester attaques SPRINT 3
	
	@Test
	public void testPositionInit() {
		try {
			LabyFichier Labyrinthe = new LabyFichier("laby_special.txt");
			Heros H = new Heros(Labyrinthe);
			char position = H.getTile();
			assertTrue((position=='E'));
			}  catch (IOException e) {
				fail();
			}
	}
	

}
