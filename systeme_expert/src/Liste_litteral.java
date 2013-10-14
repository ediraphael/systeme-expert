import java.util.Vector;


public class Liste_litteral
{
	private static Vector<Litteral> liste=new Vector<Litteral>();
	
	static Vector<Litteral> values()
	{
		return liste;
	}
	
	static void add(Litteral lit)
	{
		liste.add(lit);
		Configuration.afficherTraceAjoutLitteral(lit);
	}
	
	static boolean contains(Litteral lit)
	{
		for (Litteral element : liste)
		{
			if(element.toString().trim().equals(lit.toString().trim()))
			{
				return true;
			}
		}
		return false;
	}
	
	
}
