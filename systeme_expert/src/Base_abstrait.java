import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public abstract class Base_abstrait
{
	Vector<Object> elements;

	public Base_abstrait()
	{
		this.elements = new Vector<Object>();
	}

	public Base_abstrait(Vector<Object> elements)
	{
		this.elements = elements;
	}

	protected Vector<Object> getElements()
	{
		return elements;
	}

	protected void setElements(Vector<Object> elements)
	{
		this.elements = elements;
	}

	protected Object addElement(Object litteral)
	{
		if (!elements.contains(litteral))
		{
			if (elements.add(litteral))
			{
				return litteral;
			}
		}
		return null;
	}

	protected Vector<Object> addAllElement(Vector<Object> object)
	{
		Vector<Object> retour = new Vector<Object>();
		Object ob;
		for (Object litteral : object)
		{
			ob = this.addElement(litteral);
			if (ob != null)
			{
				retour.add(ob);
			}
		}
		return retour;
	}

	protected void loadFile(String fichier)
	{
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(fichier));
			try
			{
				String line = null;
				while ((line = input.readLine()) != null)
				{
					Litteral lit_conc = new Litteral(line);
					if (!Liste_litteral.contains(lit_conc))
					{
						Liste_litteral.addLitteral(new Litteral(line.trim()));
					}
					for (Litteral litteral : Liste_litteral.values())
					{
						if (litteral.toString().equals(line.trim()))
						{
							this.addElement(litteral);
						}
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
	}
}
