package vue;

import modele.Interface_utilisateur;

public class Interface_fenetre extends Interface_utilisateur
{
	Dialogue dialogue;

	public Interface_fenetre(Dialogue dialogue)
	{
		this.dialogue = dialogue;
	}

	@Override
	public String lireClavier_interface(String message)
	{
		return "";
	}

	@Override
	public boolean demanderBoolean_interface(String message)
	{
		return dialogue.afficher(message);
	}

}
