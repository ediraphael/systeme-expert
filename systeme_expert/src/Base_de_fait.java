import java.util.Vector;

public class Base_de_fait extends Base_abstrait
{
	public Base_de_fait()
	{
		super();
	}

	public Base_de_fait(Vector<Litteral> faits)
	{
		super();
		for (Litteral fait : faits)
		{
			this.elements.add(fait);
		}
	}

	public String getTypeBase()
	{
		return "Base de faits";
	}

	public Vector<Litteral> getFaits()
	{
		Vector<Litteral> retour = new Vector<Litteral>();
		for (Object object : this.getElements())
		{
			retour.add((Litteral) object);
		}
		return retour;
	}

	public void setFaits(Vector<Litteral> faits)
	{
		Vector<Object> vec = new Vector<Object>();
		for (Object object : faits)
		{
			vec.add(object);
		}
		this.setElements(vec);
	}

	public Vector<Litteral> addAllFait(Vector<Litteral> litteraux)
	{
		Vector<Litteral> retour = new Vector<Litteral>();
		Litteral ob;
		for (Litteral litteral : litteraux)
		{
			ob = (Litteral)this.addElement(litteral);
			if (ob != null)
			{
				retour.add(ob);
			}
		}
		return retour;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Base_de_fait clone() throws CloneNotSupportedException
	{
		return new Base_de_fait((Vector<Litteral>) this.getFaits().clone());
	}
}
