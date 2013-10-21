package modele;
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

	public Vector<Object> getElements()
	{
		return elements;
	}

	public abstract String getTypeBase();

	public void setElements(Vector<Object> elements)
	{
		this.elements = elements;
	}

	protected Object addElement(Object element)
	{
		Configuration.afficherTraceComplementDebut(this.getTypeBase() + ":addElement(" + element + ")");
		if (!elements.contains(element))
		{
			if (elements.add(element))
			{
				Configuration.afficherTraceAjout(element, this);
				Configuration.afficherTraceComplementFin(this.getTypeBase() + ":addElement(" + element + ") retour:" + element);
				return element;
			}
		} else
		{
			Configuration.afficherTraceAjoutErreurDejaPresent(element, this);
		}
		Configuration.afficherTraceComplementFin(this.getTypeBase() + ":addElement(" + element + ") retour:null");
		return null;
	}

	protected Vector<Object> addAllElement(Vector<Object> object)
	{
		Configuration.afficherTraceComplementDebut(this.getTypeBase() + ":addAllElement(" + object + ")");
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
		Configuration.afficherTraceComplementFin(this.getTypeBase() + ":addAllElement(" + object + ") retour:" + retour);
		return retour;
	}

	public void loadFile(String fichier)
	{
		Configuration.afficherTraceComplementDebut(this.getTypeBase() + ":loadFile(" + fichier + ")");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(fichier));
			try
			{
				String line = null;
				while ((line = input.readLine()) != null)
				{
					boolean estNonElement = false;
					if (line.startsWith("!"))
					{
						estNonElement = true;
						line = line.substring(1);
					}
					Litteral lit_conc = new Litteral(line);
					if (!Liste_litteral.contains(lit_conc))
					{
						Liste_litteral.addLitteral(new Litteral(line.trim()));
					}
					for (Litteral litteral : Liste_litteral.values())
					{
						if (litteral.toString().equals(line.trim()))
						{
							this.addElement(new Element_base(litteral, estNonElement));
						}
					}
				}
			} finally
			{
				input.close();
			}
		} catch (IOException ex)
		{
			Configuration.afficherTraceComplement("Erreur de chargement du fichier");
		}
		Configuration.afficherTraceComplementFin(this.getTypeBase() + ":loadFile(" + fichier + ")");
	}
}
