import java.util.Vector;

public class Regle
{
	private Vector<Element_base> condition;
	private Vector<Element_base> conclusion;
	private boolean estDeclenche;

	public Regle(Vector<Element_base> condition, Vector<Element_base> conclusion)
	{
		this.condition = condition;
		this.conclusion = conclusion;
		this.estDeclenche = false;
	}

	public Regle()
	{
		this.condition = new Vector<Element_base>();
		this.conclusion = new Vector<Element_base>();
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

	public Vector<Element_base> getCondition()
	{
		return condition;
	}

	public void setCondition(Vector<Element_base> condition)
	{
		this.condition = condition;
	}

	public Vector<Element_base> getConclusion()
	{
		return conclusion;
	}

	public void setConclusion(Vector<Element_base> conclusion)
	{
		this.conclusion = conclusion;
	}

	public boolean addCondition(Element_base element)
	{
		return this.condition.add(element);
	}

	public boolean addConclusion(Element_base element)
	{
		return this.conclusion.add(element);
	}

	public boolean estDeclenchable(Vector<Element_base> base_faits)
	{
		return base_faits.containsAll(this.condition) && !this.estDeclenche && !this.estEnIncoherence(base_faits);
	}

	public boolean estConclusion(Element_base element)
	{
		return this.getConclusion().contains(element);
	}
	
	private Vector<Element_base> getConclusionInverse()
	{
		Vector<Element_base> element_inverse= new Vector<Element_base>();
		for (Element_base element_base : this.conclusion)
		{
			element_inverse.add(new Element_base(element_base.getLitteral(),!element_base.getEstNonElement()));
		}
		return element_inverse;
	}
	
	public boolean estEnIncoherence(Vector<Element_base> base_faits)
	{
		Vector<Element_base> condition_inverse = this.getConclusionInverse();
		boolean incoherence_base_conclusion=false;
		for (Element_base element_base : base_faits)
		{
			if(condition_inverse.contains(element_base))
			{
				incoherence_base_conclusion=true;
			}
		}
		return incoherence_base_conclusion;
	}

	public Vector<Element_base> declencher(Vector<Element_base> base_faits)
	{
		Configuration.afficherTraceComplementDebut("Regle:declencher()");
		if (!this.estDeclenche)
		{
			if (base_faits.containsAll(this.condition))
			{
				if(!estEnIncoherence(base_faits))
				{
					Configuration.afficherTraceDeclenchementRegle(this);
					if (base_faits.containsAll(this.conclusion))
					{
						Configuration.afficherTraceNoteDeclenchementInutileDeclenchementRegle(this);
					}
					this.setEstDeclenche(true);
					base_faits.addAll(conclusion);
				}else
				{
					Configuration.afficherTraceErreurIncoherenceDeclenchementRegle(this);
				}
			} else
			{
				Configuration.afficherTraceErreurConditionsDeclenchementRegle(this);
			}
		} else
		{
			Configuration.afficherTraceErreurDejaDeclencherDeclenchementRegle(this);
		}
		Configuration.afficherTraceComplementFin("Regle:declencher()");
		return base_faits;
	}

	public Vector<Element_base> declencher(Base_de_fait base_faits)
	{
		base_faits.setFaits(this.declencher(base_faits.getFaits()));
		return base_faits.getFaits();

		/*
		 * Configuration.afficherTraceComplementDebut("Regle:declencher()"); if
		 * (!this.estDeclenche) { if
		 * (base_faits.getFaits().containsAll(this.condition)) {
		 * Configuration.afficherTraceDeclenchementRegle(this);
		 * if(base_faits.getFaits().containsAll(this.conclusion)) {
		 * Configuration
		 * .afficherTraceNoteDeclenchementInutileDeclenchementRegle(this); }
		 * this.setEstDeclenche(true); base_faits.addAllFait(conclusion);
		 * Configuration.afficherTraceComplementFin("Regle:declencher()");
		 * return true; }else {
		 * Configuration.afficherTraceErreurConditionsDeclenchementRegle(this);
		 * } } else {
		 * Configuration.afficherTraceErreurDejaDeclencherDeclenchementRegle
		 * (this); } Configuration.afficherTraceComplementFin(
		 * "Regle:declencher(Base_de_fait base_faits)"); return false;
		 */
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
		for (Element_base el : condition)
		{
			chaine += el + " ";
		}
		chaine += "-> ";
		for (Element_base el : conclusion)
		{
			chaine += el + " ";
		}
		return chaine;
	}
}
