import java.util.Vector;

public class Chainage_arriere extends Chainage_abstrait
{
	public Chainage_arriere(Base_de_regle regles, Base_de_fait faits)
	{
		super(regles, faits);
	}

	public void evaluer()
	{
		Litteral but = Liste_litteral.values().lastElement();

		System.out.println(this.demo(but, this.getFaits()));
	}

	public boolean demo(Litteral but, Base_de_fait BF)
	{
		Configuration.afficherTraceComplementDebut("Chainage_arriere:demo");
		boolean dem = false;

		// 1er cas
		if (this.getFaits().faits.contains(but))
		{
			dem = true;
		} else
		{
			// 2eme cas
			for (Regle regle : this.getRegles().regles)
			{
				if (regle.getConclusion().contains(but))
				{
					Configuration.afficherTraceComplement("Vérification regle but("+but+"): "+regle);
					dem = verif(regle.getCondition(), this.getFaits());
				}
			}
		}

		// 3eme cas si b n'est pas une conclusion
		if(!dem && this.getRegles().getDemandable().contains(but))
		{
			//On demande à l'utilisateur si il peut faire partie de la base de fait
			dem=Console.demanderBoolean("Question :\n "+but+" ?");
		}

		if (dem)
		{
			BF.addFait(but);
		}
		Configuration.afficherTraceComplementFin("Chainage_arriere:demo");
		return dem;
	}

	public boolean verif(Vector<Litteral> but, Base_de_fait BF)
	{
		Configuration.afficherTraceComplementDebut("Chainage_arriere:verif");
		boolean ver = true;
		for (Litteral b : but)
		{
			if (ver == true)
			{
				try
				{
					Configuration.afficherTraceComplement("Vérification  but : "+but);
					ver = demo(b, BF.clone());
				} catch (CloneNotSupportedException e)
				{
					e.printStackTrace();
				}
			}
		}
		Configuration.afficherTraceComplementFin("Chainage_arriere:verif");
		return ver;
	}
}
