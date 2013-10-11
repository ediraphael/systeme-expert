
public abstract class Chainage_abstrait
{
	private Base_de_regle base_regles;
	private Base_de_fait base_faits;
	private Base_de_fait base_faits_initial;
	
	public Chainage_abstrait(Base_de_regle regles, Base_de_fait faits)
	{
		this.base_regles = regles;
		try
		{
			this.base_faits = faits.clone();
			this.base_faits_initial = faits.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}
	
	public Base_de_regle getRegles()
	{
		return base_regles;
	}

	public void setRegles(Base_de_regle regles)
	{
		this.base_regles = regles;
	}

	public Base_de_fait getFaits()
	{
		return base_faits;
	}

	public void setFaits(Base_de_fait faits)
	{
		this.base_faits = faits;
	}
	
	public void afficherEvolution()
	{
		System.out.println("Base de fait initial :");
		for (Litteral faits : this.base_faits_initial.getFaits())
		{
			System.out.println(faits);
		}
		System.out.println();
		System.out.println("Base de fait calculée:");
		for (Litteral faits : this.base_faits.getFaits())
		{
			System.out.println(faits);
		}
	}
	
	public abstract void evaluer();
}
