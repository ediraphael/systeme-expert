import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Base_de_regle extends Base_abstrait
{
	public Base_de_regle()
	{
		super();
	}

	public Base_de_regle(Vector<Regle> regles)
	{
		super();
		for (Regle regle : regles)
		{
			this.addRegle(regle);
		}
	}

	public Vector<Regle> getRegles()
	{
		Vector<Regle> retour = new Vector<Regle>();
		for (Object object : this.getElements())
		{
			retour.add((Regle) object);
		}
		return retour;
	}

	public void setRegles(Vector<Regle> regles)
	{
		Vector<Object> vec = new Vector<Object>();
		for (Object object : regles)
		{
			vec.add(object);
		}
		this.setElements(vec);
	}

	public Regle addRegle(Regle regle)
	{
		return (Regle) this.addElement(regle);
	}

	public Vector<Regle> addAllRegle(Vector<Regle> regles)
	{
		Configuration.afficherTraceComplementDebut("Base_de_regle:addAllRegle");
		Vector<Regle> retour = new Vector<Regle>();
		Regle reg;
		for (Regle regle : regles)
		{
			reg = this.addRegle(regle);
			if (reg != null)
			{
				retour.add(reg);
			}
		}
		Configuration.afficherTraceComplementFin("Base_de_regle:addAllRegle");
		return retour;
	}

	public boolean estConclusion(Litteral litteral)
	{
		boolean demandable = false;
		for (Regle regle : this.getRegles())
		{
			demandable = regle.estConclusion(litteral);
			if (demandable)
			{
				return demandable;
			}
		}
		return demandable;
	}

	public Vector<Litteral> getDemandable()
	{
		Vector<Litteral> liste_demandable = new Vector<Litteral>();
		for (Litteral lit : Liste_litteral.values())
		{
			if (!estConclusion(lit))
			{
				liste_demandable.add(lit);
			}
		}
		return liste_demandable;
	}

	public void loadFile(String fichier)
	{
		Configuration.afficherTraceComplementDebut("Base_de_regle:loadFileBaseRegle");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(fichier));
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
