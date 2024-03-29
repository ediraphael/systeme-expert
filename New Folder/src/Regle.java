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

	public Vector<Litteral> declencher(Vector<Litteral> base_faits)
	{
		if (base_faits.containsAll(this.condition) && !this.estDeclenche)
		{
			this.estDeclenche=true;
			base_faits.addAll(conclusion);
			return base_faits;
		} else
		{
			return base_faits;
		}
	}
}
