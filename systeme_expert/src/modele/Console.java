package modele;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console
{
	static public String lireClavier(String message)
	{
		String resultat = "";
		Affichage.afficher(message);
		BufferedReader lecteur = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			resultat = lecteur.readLine();
		} catch (IOException e)
		{
			Affichage.afficher("Erreur : " + e.getMessage());
			// e.printStackTrace();
		}
		return resultat;
	}
	
	static public boolean demanderBoolean(String message)
	{
		message+="(yes/no)";
		String resultat= lireClavier(message);
		if(resultat.equals("yes"))
		{
			return true;
		}
		return false;
	}
}
