package modele;

public abstract class Interface_utilisateur
{
	private static Interface_utilisateur INTERFACE = new Console();

	public abstract String lireClavier_interface(String message);

	public abstract boolean demanderBoolean_interface(String message);

	public static Interface_utilisateur getINTERFACE()
	{
		return INTERFACE;
	}

	public static void setINTERFACE(Interface_utilisateur iNTERFACE)
	{
		INTERFACE = iNTERFACE;
	}

	public static boolean demanderBoolean(String message)
	{
		return INTERFACE.demanderBoolean_interface(message);
	}

	public static String lireClavier(String message)
	{
		return INTERFACE.lireClavier_interface(message);
	}
}
