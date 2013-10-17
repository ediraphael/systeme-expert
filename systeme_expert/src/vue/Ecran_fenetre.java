package vue;

import modele.Affichage;

public class Ecran_fenetre extends Affichage
{
	AfficheTrace affichage;

	public Ecran_fenetre(AfficheTrace affichage)
	{
		super();
		this.affichage = affichage;
	}

	public AfficheTrace getAffichage()
	{
		return affichage;
	}

	public void setAffichage(AfficheTrace affichage)
	{
		this.affichage = affichage;
	}

	@Override
	protected void afficher_message(Object message)
	{
		this.affichage.rajouterTexte(message.toString());
	}
	
	protected void reset_message()
	{
		this.affichage.reset();
	}
}
