public class Configuration
{
	public static boolean AFFICHER_TRACE = false;
	public static boolean AFFICHER_TRACE_REGLE = true;
	public static boolean AFFICHER_TRACE_FAIT = true;
	public static boolean AFFICHER_TRACE_LITTERAL = true;

	public static void afficherTraceAjoutFait(Object object)
	{
		if (AFFICHER_TRACE && AFFICHER_TRACE_FAIT)
		{
			System.out.println("Ajout à la base de fait de : " + object);
		}
	}

	public static void afficherTraceErreurDejaPresentAjoutFait(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_FAIT)
		{
			System.out.println("ERREUR d'ajout, fait déjà présent : " + object);
		}
	}

	public static void afficherTraceAjoutFaits(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_FAIT)
		{
			System.out.println("Ajout des faits à la base de fait : " + object);
		}
	}

	public static void afficherTraceAjoutRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE)
		{
			System.out.println("Ajout à la base de regle de : " + object);
		}
	}

	public static void afficherTraceErreurDejaPresentAjoutRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE)
		{
			System.out.println("ERREUR d'ajout, regle déjà présente : " + object);
		}
	}

	public static void afficherTraceDeclenchementRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE)
		{
			System.out.println("Déclenchement de la regle : " + object);
		}
	}

	public static void afficherTraceErreurDejaDeclencherDeclenchementRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE)
		{
			System.out.println("Erreur de déclenchement, règle déjà déclenché : " + object);
		}
	}

	public static void afficherTraceErreurConditionsDeclenchementRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE)
		{
			System.out.println("Erreur de déclenchement, règle déjà déclenché : " + object);
		}
	}

	public static void afficherTraceNoteDeclenchementInutileDeclenchementRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE)
		{
			System.out.println("Note : Déclehement inutile, conclusion déjà présente : " + object);
		}
	}

	public static void afficherTraceAjoutLitteral(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_LITTERAL)
		{
			System.out.println("Ajout à la liste de litteral de : " + object);
		}
	}
}
