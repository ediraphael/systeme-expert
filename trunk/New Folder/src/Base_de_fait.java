import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Base_de_fait
{
	Vector<Litteral> faits;

	public Base_de_fait()
	{
		this.faits = new Vector<Litteral>();
	}

	public Base_de_fait(Vector<Litteral> faits)
	{
		this.faits = faits;
	}

	public Vector<Litteral> getFaits()
	{
		return faits;
	}

	public void setFaits(Vector<Litteral> faits)
	{
		this.faits = faits;
	}

	public boolean addFait(Litteral litteral)
	{
		return faits.add(litteral);
	}

	public void loadFileBaseFait()
	{
		try
		{
			BufferedReader input = new BufferedReader(new FileReader("base_fait.txt"));
			try
			{
				String line = null;
				while ((line = input.readLine()) != null)
				{

					for (Litteral litteral : Litteral.values())
					{
						if (litteral.toString().equals(line.trim()))
						{
							this.faits.add(litteral);
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
	
	public boolean estAccepte()
	{
		return this.faits.contains(Litteral.accepte);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Base_de_fait clone() throws CloneNotSupportedException
	{
		return new Base_de_fait((Vector<Litteral>)this.faits.clone());
	}
	
}
