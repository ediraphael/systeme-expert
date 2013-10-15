import java.util.Vector;

public class Regle
{
	private Vector<Litteral> condition;
	private Vector<Litteral> conclusion;
	private boolean estDeclenche;

	public Regle(Vector<Litteral> condition, Vector<Litteral> conclusion)
	{
		this.condition = condition;
		this.conclusion = conclusion;
		this.estDeclenche = false;
	}

	public Regle()
	{
		this.condition = new Vector<Litteral>();
		this.conclusion = new Vector<Litteral>();
		this.estDeclenche = false;
	}

	public boolean isEstDeclenche()
	{
		return estDeclenche;
	}

	public void setEstDeclenche(boolean estDeclenche)
	{
		this.estDeclenche = estDeclenche;
	}

	public Vector<Litteral> getCondition()
	{
		return condition;
	}

	public void setCondition(Vector<Litteral> condition)
	{
		this.condition = condition;
	}

	public Vector<Litteral> getConclusion()
	{
		return conclusion;
	}

	public void setConclusion(Vector<Litteral> conclusion)
	{
		this.conclusion = conclusion;
	}

	public boolean addCondition(Litteral litteral)
	{
		return this.condition.add(litteral);
	}

	public boolean addConclusion(Litteral litteral)
	{
		return this.conclusion.add(litteral);
	}

	public boolean estDeclenchable(Vector<Litteral> base_faits)
	{
		return base_faits.containsAll(this.condition) && !this.estDeclenche;
	}
	
	public boolean estConclusion(Litteral litteral)
	{
		return this.getConclusion().contains(litteral);
	}

	public Vector<Litteral> declencher(Vector<Litteral> base_faits)
	{
		Configuration.afficherTraceComplementDebut("Regle:declencher");
		if (base_faits.containsAll(this.condition) && !this.estDeclenche)
		{
			Configuration.afficherTraceDeclenchementRegle(this);
			this.estDeclenche = true;
			base_faits.addAll(conclusion);
		} 
		Configuration.afficherTraceComplementFin("Regle:declencher");
		return base_faits;
	}

	public boolean declencher(Base_de_fait base_faits)
	{
		Configuration.afficherTraceComplementDebut("Regle:declencher");
		if (!this.estDeclenche)
		{
			if (base_faits.getFaits().containsAll(this.condition))
			{
				Configuration.afficherTraceDeclenchementRegle(this);
				if(base_faits.getFaits().containsAll(this.conclusion))
				{
					Configuration.afficherTraceNoteDeclenchementInutileDeclenchementRegle(this);
				}
				this.setEstDeclenche(true);
				base_faits.addAllFait(conclusion);
				Configuration.afficherTraceComplementFin("Regle:declencher");
				return true;
			}else
			{
				Configuration.afficherTraceErreurConditionsDeclenchementRegle(this);
			}
		} else
		{
			Configuration.afficherTraceErreurDejaDeclencherDeclenchementRegle(this);
		}
		Configuration.afficherTraceComplementFin("Regle:declencher");
		return false;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Regle))
		{
			return false;
		} else if (!((Regle) obj).getConclusion().equals(this.getConclusion()))
		{
			return false;
		} else if (!((Regle) obj).getCondition().equals(this.getCondition()))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		String chaine = "";
		for (Litteral lit : condition)
		{
			chaine += lit + " ";
		}
		chaine += "-> ";
		for (Litteral lit : conclusion)
		{
			chaine += lit + " ";
		}
		return chaine;
	}
}
