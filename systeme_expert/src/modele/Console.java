package modele;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console extends Interface_utilisateur
{
	public String lireClavier_interface(String message) 
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
		}
		return resultat;
	}
	
	public boolean demanderBoolean_interface(String message)
	{
		message+="(yes/no)";
		String resultat= lireClavier_interface(message);
		if(resultat.equals("yes"))
		{
			return true;
		}
		return false;
	}
}
