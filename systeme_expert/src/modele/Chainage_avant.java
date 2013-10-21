package modele;

public class Chainage_avant extends Chainage_abstrait
{
	public Chainage_avant(Base_de_regle regles, Base_de_fait faits, Base_de_but buts)
	{
		super(regles, faits, buts);
	}

	public void evaluer()
	{
		Configuration.afficherTraceComplementDebut("Chainage_avant:evaluer");
		boolean inf = true;
		boolean dec = false;
		// int nbinf = 0;

		while (inf && (!this.getBase_faits().getFaits().containsAll(this.getBase_buts().getElements()) || this.getBase_buts().getElements().isEmpty()))
		{
			inf = false;
			for (Regle regle : this.getBase_regles().getRegles())
			{
				dec = regle.estDeclenchable(this.getBase_faits().getFaits());
				if (dec)
				{
					// nbinf++;
					regle.declencher(this.getBase_faits());
					inf = true;
				}
			}
		}
		Configuration.afficherTraceComplementFin("Chainage_avant:evaluer");
	}
}
