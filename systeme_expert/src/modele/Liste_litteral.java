package modele;
import java.util.Vector;


public class Liste_litteral
{
	private static Vector<Litteral> liste_litteral=new Vector<Litteral>();
	
	static Vector<Litteral> values()
	{
		return liste_litteral;
	}
	
	static void addLitteral(Litteral lit)
	{
		Configuration.afficherTraceComplementDebut("Liste_litteral:addLitteral");
		liste_litteral.add(lit);
		Configuration.afficherTraceAjout(lit,liste_litteral.lastElement());
		Configuration.afficherTraceComplementFin("Liste_litteral:addLitteral");
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
