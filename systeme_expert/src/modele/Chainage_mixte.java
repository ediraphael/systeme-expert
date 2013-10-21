package modele;

public class Chainage_mixte extends Chainage_abstrait
{
	public Chainage_mixte(Base_de_regle regles, Base_de_fait faits, Base_de_but buts)
	{
		super(regles, faits, buts);
	}

	public void evaluer()
	{
		Configuration.afficherTraceComplementDebut("Chainage_mixte:evaluer()");
		Chainage_avant chainage_avant = new Chainage_avant(this.getBase_regles(), this.getBase_faits(), this.getBase_buts());
		chainage_avant.evaluer();
		this.setBase_faits(chainage_avant.getBase_faits());
		if(!this.butEstAtteint())
		{
			Chainage_arriere chainage_arriere = new Chainage_arriere(this.getBase_regles(), this.getBase_faits(), this.getBase_buts());
			chainage_arriere.evaluer();
			this.setBase_faits(chainage_arriere.getBase_faits());
		}
		
		Configuration.afficherTraceComplementFin("Chainage_mixte:evaluer()");
	}
}
