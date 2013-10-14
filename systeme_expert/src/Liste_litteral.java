import java.util.Vector;


public class Liste_litteral
{
	private static Vector<Litteral> liste_litteral=new Vector<Litteral>();
	
	static Vector<Litteral> values()
	{
		return liste_litteral;
	}
	
	static void add(Litteral lit)
	{
		liste_litteral.add(lit);
		Configuration.afficherTraceAjoutLitteral(lit);
	}
	
	static boolean contains(Litteral lit)
	{
		for (Litteral element : liste_litteral)
		{
			if(element.toString().trim().equals(lit.toString().trim()))
			{
				return true;
			}
		}
		return false;
	}
	
	
}
