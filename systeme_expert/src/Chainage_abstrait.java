public abstract class Chainage_abstrait
{
	private Base_de_regle base_regles;
	private Base_de_fait base_faits;
	private Base_de_but base_buts;
	private Base_de_fait base_faits_initial;

	public Chainage_abstrait(Base_de_regle regles, Base_de_fait faits, Base_de_but buts)
	{
		this.base_regles = regles;
		this.base_buts = buts;
		try
		{
			this.base_faits = faits.clone();
			this.base_faits_initial = faits.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}

	public Base_de_fait getBase_faits()
	{
		return base_faits;
	}

	public void setBase_faits(Base_de_fait base_faits)
	{
		this.base_faits = base_faits;
	}

	public Base_de_regle getBase_regles()
	{
		return base_regles;
	}

	public void setBase_regles(Base_de_regle base_regles)
	{
		this.base_regles = base_regles;
	}

	public Base_de_but getBase_buts()
	{
		return base_buts;
	}

	public void setBase_buts(Base_de_but base_buts)
	{
		this.base_buts = base_buts;
	}
	
	public boolean butEstAtteint()
	{
		return this.getBase_faits().getElements().containsAll(this.getBase_buts().getElements());
	}

	public void afficherEvolution()
	{
		Affichage.afficher("Base de fait initial :");
		for (Element_base faits : this.base_faits_initial.getFaits())
		{
			Affichage.afficher(faits);
		}
		Affichage.afficher("\nBase de fait calculée:");
		for (Element_base faits : this.base_faits.getFaits())
		{
			Affichage.afficher(faits);
		}
	}

	public abstract void evaluer();
}
