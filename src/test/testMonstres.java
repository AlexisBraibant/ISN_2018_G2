package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projetLabyrinthe.Fantome;
import projetLabyrinthe.LabyFichier;
import projetLabyrinthe.Monstre;

public class testMonstres
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	// Pas de coor négative
	// pas de coor > au borne du terrain
	// Pas être sur un mur (faire experes d'être sur un mur)
	// test de ce qui ne devrait pas être normal

	@Test
	public void testConstructeurDefault()
	{
		Monstre monstreTest = new Monstre();
		assertTrue(monstreTest.getHp() == 0);
		assertTrue(monstreTest.getVie() == 0);
		/*assertTrue(monstreTest.coorX() == 0);
		assertTrue(monstreTest.coorY() == 0);
		assertTrue(!monstreTest.fantome);*/
		// On ne peut pas vérifier les positions du monstres, ni si c'est un fantôme
	}

	@Test
	public void testConstructeurFaible()
	{
		Monstre monstreTest = new Monstre(8, 10, true);
		assertTrue(monstreTest.getHp() == 8);
		assertTrue(monstreTest.getVie() == 10);
		// assertTrue(monstreTest.fantome);
		// On ne peut pas vérifier l'état du monstre (fantome ou non)
	}

	@Test
	public void testConstructeurFort()
	{
		Monstre monstreTest = new Monstre(5, 7, 8, 10, true);
		assertTrue(monstreTest.getHp() == 8);
		assertTrue(monstreTest.getVie() == 10);
		/*assertTrue(monstreTest.coorX() == 5);
		assertTrue(monstreTest.coorY() == 7);
		assertTrue(monstreTest.fantome);*/
		// On ne peut pas vérifier les positions du monstres, ni si c'est un fantôme
	}
	
	//2 tests pour fantomes mur bord et mur laby
	@Test
	public void testPassageMurLabyFantome() throws IOException 
	{
		LabyFichier laby = new LabyFichier("niv1.txt");
		Fantome fantomeTest = new Fantome(3, 4, 8, 10, laby);
		char[][] Maplb = laby.getMap();
		assertEquals(Maplb[fantomeTest.getCoorX()][fantomeTest.getCoorY()],'#');
	}
	
	//on fait le déplacement du fantome et on montre que le fantome ne se déplace pas
	@Test
	public void testNonPassageMurLabyFantome() throws IOException 
	{
		LabyFichier laby = new LabyFichier("niv1.txt");
		Fantome fantomeTest = new Fantome(1, 1, 8, 10, laby);
		char direction = 'q';
		fantomeTest.deplacement(direction, laby, true, fantomeTest.getTilePerso());
		char[][] Maplb = laby.getMap();
		assertEquals(fantomeTest.getCoorX(),1);
		assertEquals(fantomeTest.getCoorY(),1);
	}
}
