import java.util.Vector;

public class Base_de_but extends Base_abstrait
{
	public Base_de_but()
	{
		super();
	}

	public Base_de_but(Vector<Litteral> buts)
	{
		super();
		for (Litteral but : buts)
		{
			this.addBut(but);
		}
	}

	public Vector<Litteral> getButs()
	{
		Vector<Litteral> retour = new Vector<Litteral>();
		for (Object object : this.getElements())
		{
			retour.add((Litteral) object);
		}
		return retour;
	}

	public void setButs(Vector<Litteral> buts)
	{
		Vector<Object> vec = new Vector<Object>();
		for (Object object : buts)
		{
			vec.add(object);
		}
		this.setElements(vec);
	}

	public Litteral addBut(Litteral litteral)
	{
		return (Litteral) this.addElement(litteral);
	}

	public Litteral addBut(String but)
	{
		Configuration.afficherTraceComplementDebut("Base_de_fait:addBut(String) : " + but);
		for (Litteral litteral : Liste_litteral.values())
		{
			if (litteral.isSameAs(but))
			{
				if (this.addBut(litteral) != null)
				{
					Configuration.afficherTraceComplementFin("Base_de_fait:addBut(String) : " + but);
					return litteral;
				}
				Configuration.afficherTraceComplementFin("Base_de_fait:addBut(String) : " + but);
				return null;
			}
		}
		Configuration.afficherTraceComplementFin("Base_de_fait:addBut(String) : " + but);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Base_de_but clone() throws CloneNotSupportedException
	{
		return new Base_de_but((Vector<Litteral>) this.getElements().clone());
	}
}
