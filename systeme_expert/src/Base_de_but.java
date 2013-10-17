import java.util.Vector;

public class Base_de_but extends Base_abstrait
{
	public Base_de_but()
	{
		super();
	}

	public Base_de_but(Vector<Element_base> buts)
	{
		super();
		for (Element_base but : buts)
		{
			this.elements.add(but);
		}
	}

	public String getTypeBase()
	{
		return "Base de buts";
	}

	public Vector<Element_base> getButs()
	{
		Vector<Element_base> retour = new Vector<Element_base>();
		for (Object object : this.getElements())
		{
			retour.add((Element_base) object);
		}
		return retour;
	}

	public void setButs(Vector<Element_base> buts)
	{
		Vector<Object> vec = new Vector<Object>();
		for (Object object : buts)
		{
			vec.add(object);
		}
		this.setElements(vec);
	}

	public Element_base addBut(String but)
	{
		Configuration.afficherTraceComplementDebut("Base_de_but:addBut(String) : " + but);
		String element = but;
		boolean estNonElement = false;
		if (element.startsWith("!"))
		{
			estNonElement = true;
			element = element.substring(1);
		}
		for (Litteral litteral : Liste_litteral.values())
		{
			if (litteral.isSameAs(element))
			{
				Element_base element_base = new Element_base(litteral, estNonElement);
				if (this.addElement(element_base) != null)
				{
					Configuration.afficherTraceComplementFin("Base_de_but:addBut(String) : " + but);
					return element_base;
				}
				Configuration.afficherTraceComplementFin("Base_de_but:addBut(String) : " + but);
				return null;
			}
		}
		Configuration.afficherTraceComplementFin("Base_de_but:addBut(String) : " + but);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Base_de_but clone() throws CloneNotSupportedException
	{
		return new Base_de_but((Vector<Element_base>) this.getElements().clone());
	}
}
