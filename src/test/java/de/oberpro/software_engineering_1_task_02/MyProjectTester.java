package de.oberpro.software_engineering_1_task_02;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Sascha
 *
 */
public class MyProjectTester extends TestCase
{
	IfProject example1;

	@Override
	@Before
	public void setUp()
	{
		example1 = new Project(new String[][]
		{
				{ "A", "C" },
				{ "D", "C" },
				{ "B", "C" } });
	}

	@Test
	public void test_example1_01()
	{

		assertFalse(example1.isWellSorted(new String[]
		{ "A", "B", "C", "D" }));
	}

	@Test
	public void test_example1_02()
	{
		assertFalse(example1.isWellSorted(new String[]
		{ "B", "C", "A", "D" }));
	}

	@Test
	public void test_example1_03()
	{
		assertTrue(example1.isWellSorted(new String[]
		{ "A", "B", "D", "C" }));
	}

	@Test
	public void test_example1_04()
	{
		assertFalse(example1.isWellSorted(new String[]
		{ "A", "A" }));
	}

}
