import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Base_de_regle
{
	Vector<Regle> regles;

	public Base_de_regle()
	{
		this.regles = new Vector<Regle>();
	}

	public Base_de_regle(Vector<Regle> regles)
	{
		this.regles = regles;
	}

	public Vector<Regle> getRegles()
	{
		return regles;
	}

	public void setRegles(Vector<Regle> regles)
	{
		this.regles = regles;
	}

	public boolean addRegle(Regle regle)
	{
		return this.regles.add(regle);
	}

	public void loadFileBaseRegle()
	{
		try
		{
			BufferedReader input = new BufferedReader(new FileReader("base_regle.txt"));
			try
			{
				String line = null;
				String composition[] = new String[2];
				String condition[];
				String conclusion[];
				while ((line = input.readLine()) != null)
				{
					composition = line.split(":");
					if (composition.length > 0)
					{
						Regle regle = new Regle();
						condition = composition[0].split(" ET ");
						conclusion = composition[1].split(" ET ");
						for (String cond : condition)
						{
							for (Litteral litteral : Litteral.values())
							{
								if (litteral.toString().equals(cond.trim()))
								{
									regle.addCondition(litteral);
								}
							}
						}
						for (String conc : conclusion)
						{
							for (Litteral litteral : Litteral.values())
							{
								if (litteral.toString().equals(conc.trim()))
								{
									regle.addConclusion(litteral);
								}
							}
						}
						this.regles.add(regle);
					}
				}
			} finally
			{
				input.close();
			}
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
