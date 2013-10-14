
public class Configuration
{
	public static boolean AFFICHER_TRACE=false;
	
	public static void afficherTraceAjoutFait(Object object)
	{
		if(Configuration.AFFICHER_TRACE)
		{
			System.out.println("Ajout à la base de fait de : "+object);
		}
	}
	
	public static void afficherTraceAjoutRegle(Object object)
	{
		if(Configuration.AFFICHER_TRACE)
		{
			System.out.println("Ajout à la base de regle de : "+object);
		}
	}
	
	public static void afficherTraceAjoutLitteral(Object object)
	{
		if(Configuration.AFFICHER_TRACE)
		{
			System.out.println("Ajout à la liste de litteral de : " + object);
		}
	}
	
	public static void afficherTraceDeclenchementRegle(Object object)
	{
		if(Configuration.AFFICHER_TRACE)
		{
			System.out.println("Déclenchement de la regle : " + object);
		}
	}
}
