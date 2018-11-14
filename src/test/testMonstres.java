package test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
}
