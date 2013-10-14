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
		Configuration.afficherTraceComplementDebut("Base_de_regle:addRegle");
		if (!this.regles.contains(regle))
		{
			if (this.regles.add(regle))
			{
				Configuration.afficherTraceAjoutRegle(regle);
				Configuration.afficherTraceComplementFin("addRegle");
				return true;
			}
		} else
		{
			Configuration.afficherTraceErreurDejaPresentAjoutRegle(regle);
		}
		Configuration.afficherTraceComplementFin("Base_de_regle:addRegle");
		return false;
	}

	public void loadFileBaseRegle()
	{
		Configuration.afficherTraceComplementDebut("Base_de_regle:loadFileBaseRegle");
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
							Litteral lit_cond = new Litteral(cond);
							if (!Liste_litteral.contains(lit_cond))
							{
								Liste_litteral.addLitteral(new Litteral(cond.trim()));
							}
							for (Litteral litteral : Liste_litteral.values())
							{
								if (litteral.toString().equals(cond.trim()))
								{
									regle.addCondition(litteral);
								}
							}
						}
						for (String conc : conclusion)
						{
							Litteral lit_conc = new Litteral(conc);
							if (!Liste_litteral.contains(lit_conc))
							{
								Liste_litteral.addLitteral(new Litteral(conc.trim()));
							}
							for (Litteral litteral : Liste_litteral.values())
							{
								if (litteral.toString().equals(conc.trim()))
								{
									regle.addConclusion(litteral);
								}
							}
						}
						this.addRegle(regle);
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
		Configuration.afficherTraceComplementFin("Base_de_regle:loadFileBaseRegle");
	}
}
