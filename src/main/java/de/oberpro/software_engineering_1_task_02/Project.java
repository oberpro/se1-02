/**
 * (c) 2017 Parkhaus Enterprise Systems
 */
package de.oberpro.software_engineering_1_task_02;

/**
 * @author Kevin
 *
 */
public class Project implements IfProject
{

	private final String[][] relations;

	public Project(String[][] relations)
	{
		this.relations = relations;
	}

	private boolean inArray(String needle, String[] haystack)
	{
		for (String a : haystack)
		{
			if (needle.equalsIgnoreCase(a))
			{
				return true;
			}
		}
		return false;
	}

	private boolean inArray(String[] needle, String[] haystack)
	{
		for (String a : haystack)
		{
			if (a != null)
			{
				for (String b : needle)
				{
					boolean ok = false;
					for (String c : haystack)
					{
						if (b != null && c != null && b.equalsIgnoreCase(c))
						{
							ok = true;
							break;
						}
					}
					if (!ok)
					{
						return false;
					}
				}

			}
		}
		return true;
	}

	public boolean isWellSorted(String[] sequence)
	{
		System.out.println("checking sequence " + arrayToString(sequence));
		String[] done = new String[sequence.length];
		for (int i = 0; i < sequence.length; i++)
		{
			String task = sequence[i];
			if (inArray(task, done))
			{
				return false;
			}
			for (String[] relation : this.relations)
			{
				if (relation[1].equalsIgnoreCase(task))
				{
					String[] before = new String[this.relations.length];
					for (int j = 0; j < this.relations.length; j++)
					{
						String[] r = this.relations[j];
						if (r[1].equalsIgnoreCase(task))
						{
							before[j] = r[0];
						}
					}
					System.out.println("Task " + task + " needs " + arrayToString(before) + " in done list: "
							+ arrayToString(done));
					if (!inArray(before, done))
					{
						System.out.println(arrayToString(before) + " is not equals " + arrayToString(done));
						return false;
					}
				}
			}
			done[i] = task;
		}
		return true;
	}

	private String arrayToString(String[] array)
	{
		String s = "";
		for (int i = 0; i < array.length; i++)
		{
			s += array[i];
			if (i < array.length - 1)
			{
				s += ",";
			}
		}
		return s;
	}

}
