
public abstract class Affichage
{
	private static Affichage ECRAN=new Ecran_console();
	protected abstract void afficher_message(Object message);
	public static void afficher(Object message)
	{
		ECRAN.afficher_message(message);
	}
	public static Affichage getECRAN()
	{
		return ECRAN;
	}
	public static void setECRAN(Affichage eCRAN)
	{
		ECRAN = eCRAN;
	}
}
