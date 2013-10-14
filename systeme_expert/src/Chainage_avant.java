public class Chainage_avant extends Chainage_abstrait
{
	public Chainage_avant(Base_de_regle regles, Base_de_fait faits)
	{
		super(regles, faits);
	}

	public void evaluer()
	{
		Configuration.afficherTraceComplementDebut("Chainage_avant:evaluer");
		boolean inf = true;
		boolean dec = false;
		// int nbinf = 0;

		while (inf)
		{
			inf = false;
			for (Regle regle : this.getRegles().getRegles())
			{
				dec = regle.estDeclenchable(this.getFaits().getFaits());
				if (dec)
				{
					// nbinf++;
					regle.declencher(this.getFaits());
					inf = true;
				}
			}
		}
		Configuration.afficherTraceComplementFin("Chainage_avant:evaluer");
	}
}
