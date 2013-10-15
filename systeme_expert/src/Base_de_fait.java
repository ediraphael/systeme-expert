import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Base_de_fait
{
	Vector<Litteral> faits;
	Vector<Litteral> buts;

	public Base_de_fait()
	{
		this.faits = new Vector<Litteral>();
		this.buts = new Vector<Litteral>();
	}

	public Base_de_fait(Vector<Litteral> faits, Vector<Litteral> buts)
	{
		this.faits = faits;
		this.buts = buts;
	}

	public Vector<Litteral> getFaits()
	{
		return faits;
	}

	public void setFaits(Vector<Litteral> faits)
	{
		this.faits = faits;
	}

	public Vector<Litteral> getButs()
	{
		return buts;
	}

	public boolean addBut(Litteral litteral)
	{
		Configuration.afficherTraceComplementDebut("Base_de_fait:addBut(Litteral) : " + litteral);
		if (this.buts.add(litteral))
		{
			Configuration.afficherTraceComplementFin("Base_de_fait:addBut(Litteral) : " + litteral);
			return true;
		}
		Configuration.afficherTraceComplementFin("Base_de_fait:addBut(Litteral) : " + litteral);
		return false;
	}

	public boolean addBut(String but)
	{
		Configuration.afficherTraceComplementDebut("Base_de_fait:addBut(String) : " + but);
		for (Litteral litteral : Liste_litteral.values())
		{
			if (litteral.isSameAs(but))
			{
				if(this.addBut(litteral))
				{
					Configuration.afficherTraceComplementFin("Base_de_fait:addBut(String) : " + but);
					return true;
				}
				Configuration.afficherTraceComplementFin("Base_de_fait:addBut(String) : " + but);
				return false;
			}
		}
		Configuration.afficherTraceComplementFin("Base_de_fait:addBut(String) : " + but);
		return false;
	}

	public void setButs(Vector<Litteral> buts)
	{
		this.buts = buts;
	}

	public Litteral addFait(Litteral litteral)
	{
		Configuration.afficherTraceComplementDebut("Base_de_fait:addFait");
		if (!faits.contains(litteral))
		{
			if (faits.add(litteral))
			{
				Configuration.afficherTraceAjoutFait(litteral);
				Configuration.afficherTraceComplementFin("Base_de_fait:addFait");
				return litteral;
			}
		} else
		{
			Configuration.afficherTraceErreurDejaPresentAjoutFait(litteral);
		}
		Configuration.afficherTraceComplementFin("Base_de_fait:addFait");
		return null;
	}

	public Vector<Litteral> addAllFait(Vector<Litteral> litteraux)
	{
		Configuration.afficherTraceComplementDebut("Base_de_fait:addAllFait");
		Vector<Litteral> retour = new Vector<Litteral>();
		Litteral lit;
		for (Litteral litteral : litteraux)
		{
			lit = this.addFait(litteral);
			if (lit != null)
			{
				retour.add(lit);
			}
		}
		Configuration.afficherTraceComplementFin("Base_de_fait:addAllFait");
		return retour;
	}

	public void loadFileBaseFait()
	{
		Configuration.afficherTraceComplementDebut("Base_de_fait:loadFileBaseFait");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader("base_fait.txt"));
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
							this.addFait(litteral);
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
		Configuration.afficherTraceComplementFin("Base_de_fait:loadFileBaseFait");
	}

	/*
	 * public boolean estAccepte() { return
	 * this.faits.contains(Litteral.accepte); }
	 */

	@SuppressWarnings("unchecked")
	@Override
	protected Base_de_fait clone() throws CloneNotSupportedException
	{
		return new Base_de_fait((Vector<Litteral>) this.faits.clone(), (Vector<Litteral>) this.buts.clone());
	}

}
