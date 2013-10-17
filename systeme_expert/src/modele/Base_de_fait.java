package modele;
import java.util.Vector;

public class Base_de_fait extends Base_abstrait
{
	public Base_de_fait()
	{
		super();
	}

	public Base_de_fait(Vector<Element_base> faits)
	{
		super();
		for (Element_base fait : faits)
		{
			this.elements.add(fait);
		}
	}

	public String getTypeBase()
	{
		return "Base de faits";
	}

	public Vector<Element_base> getFaits()
	{
		Vector<Element_base> retour = new Vector<Element_base>();
		for (Object object : this.getElements())
		{
			retour.add((Element_base) object);
		}
		return retour;
	}

	public void setFaits(Vector<Element_base> faits)
	{
		Vector<Object> vec = new Vector<Object>();
		for (Object object : faits)
		{
			vec.add(object);
		}
		this.setElements(vec);
	}

	public Vector<Element_base> addAllFait(Vector<Element_base> litteraux)
	{
		Vector<Element_base> retour = new Vector<Element_base>();
		Element_base ob;
		for (Element_base litteral : litteraux)
		{
			ob = (Element_base)this.addElement(litteral);
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
		return new Base_de_fait((Vector<Element_base>) this.getFaits().clone());
	}
}
