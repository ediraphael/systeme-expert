public class Configuration
{
	public static boolean AFFICHER_TRACE = false;
	public static boolean AFFICHER_TRACE_REGLE = true;
	public static boolean AFFICHER_TRACE_REGLE_DECLENCHEMENT = true;
	public static boolean AFFICHER_TRACE_REGLE_AUTRE = true;
	public static boolean AFFICHER_TRACE_FAIT = true;
	public static boolean AFFICHER_TRACE_BUT = true;
	public static boolean AFFICHER_TRACE_LITTERAL = true;
	public static boolean AFFICHER_TRACE_COMPLEMENT = false;

	public static void afficherTraceComplementDebut(Object object)
	{
		if (AFFICHER_TRACE && AFFICHER_TRACE_COMPLEMENT)
		{
			System.out.println("------------Début: " + object);
		}
	}

	public static void afficherTraceComplementFin(Object object)
	{
		if (AFFICHER_TRACE && AFFICHER_TRACE_COMPLEMENT)
		{
			System.out.println("------------Fin: " + object + "\n");
		}
	}

	public static void afficherTraceComplement(Object object)
	{
		if (AFFICHER_TRACE && AFFICHER_TRACE_COMPLEMENT)
		{
			System.out.println("-- " + object);
		}
	}

	public static void afficherTraceAjout(Object object, Object base)
	{
		switch (base.getClass().toString())
		{
		case "class Base_de_but":
			afficherTraceAjoutBut(object);
			break;
		case "class Base_de_fait":
			afficherTraceAjoutFait(object);
			break;
		case "class Base_de_regle":
			afficherTraceAjoutRegle(object);
			break;
		case "class Litteral":
			afficherTraceAjoutLitteral(object);
			break;
		default:
			afficherTraceAjoutDefaut(object);
			break;
		}
	}

	public static void afficherTraceAjoutErreurDejaPresent(Object object, Object base)
	{
		switch (base.getClass().toString())
		{
		case "class Base_de_but":
			afficherTraceAjoutErreurDejaPresentBut(object);
			break;
		case "class Base_de_fait":
			afficherTraceAjoutErreurDejaPresentFait(object);
			break;
		case "class Base_de_regle":
			afficherTraceAjoutErreurDejaPresentRegle(object);
			break;
		case "class Litteral":
			afficherTraceAjoutErreurDejaPresentLitteral(object);
			break;
		default:
			afficherTraceAjoutErreurDejaPresentDefaut(object);
			break;
		}
	}

	public static void afficherTraceAjoutDefaut(Object object)
	{
		if (AFFICHER_TRACE)
		{
			System.out.println("Ajout de : " + object);
		}
	}

	public static void afficherTraceAjoutErreurDejaPresentDefaut(Object object)
	{
		if (Configuration.AFFICHER_TRACE)
		{
			System.out.println("ERREUR d'ajout, element déjà présent : " + object);
		}
	}

	public static void afficherTraceAjoutErreurDejaPresentFait(Object object)
	{
		if (Configuration.AFFICHER_TRACE && Configuration.AFFICHER_TRACE_FAIT)
		{
			System.out.println("ERREUR d'ajout, fait déjà présent : " + object);
		}
	}

	public static void afficherTraceAjoutErreurDejaPresentBut(Object object)
	{
		if (Configuration.AFFICHER_TRACE && Configuration.AFFICHER_TRACE_BUT)
		{
			System.out.println("ERREUR d'ajout, but déjà présent : " + object);
		}
	}

	public static void afficherTraceAjoutErreurDejaPresentRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && Configuration.AFFICHER_TRACE_REGLE && Configuration.AFFICHER_TRACE_REGLE_AUTRE)
		{
			System.out.println("ERREUR d'ajout, regle déjà présent : " + object);
		}
	}

	public static void afficherTraceAjoutErreurDejaPresentLitteral(Object object)
	{
		if (Configuration.AFFICHER_TRACE && Configuration.AFFICHER_TRACE_LITTERAL)
		{
			System.out.println("ERREUR d'ajout, Litteral déjà présent : " + object);
		}
	}

	public static void afficherTraceAjoutBut(Object object)
	{
		if (AFFICHER_TRACE && AFFICHER_TRACE_BUT)
		{
			System.out.println("Ajout à la base de but de : " + object);
		}
	}

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
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE && Configuration.AFFICHER_TRACE_REGLE_AUTRE)
		{
			System.out.println("Ajout à la base de regle de : " + object);
		}
	}

	public static void afficherTraceErreurDejaPresentAjoutRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE && Configuration.AFFICHER_TRACE_REGLE_AUTRE)
		{
			System.out.println("ERREUR d'ajout, regle déjà présente : " + object);
		}
	}

	public static void afficherTraceDeclenchementRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE && Configuration.AFFICHER_TRACE_REGLE_DECLENCHEMENT)
		{
			System.out.println("Déclenchement de la regle : " + object);
		}
	}

	public static void afficherTraceErreurDejaDeclencherDeclenchementRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE && Configuration.AFFICHER_TRACE_REGLE_DECLENCHEMENT)
		{
			System.out.println("Erreur de déclenchement, règle déjà déclenché : " + object);
		}
	}

	public static void afficherTraceErreurConditionsDeclenchementRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE && Configuration.AFFICHER_TRACE_REGLE_DECLENCHEMENT)
		{
			System.out.println("Erreur de déclenchement, règle déjà déclenché : " + object);
		}
	}

	public static void afficherTraceNoteDeclenchementInutileDeclenchementRegle(Object object)
	{
		if (Configuration.AFFICHER_TRACE && AFFICHER_TRACE_REGLE && Configuration.AFFICHER_TRACE_REGLE_DECLENCHEMENT)
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
