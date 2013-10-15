import java.util.Vector;

public class Chainage_arriere extends Chainage_abstrait
{
	public Chainage_arriere(Base_de_regle regles, Base_de_fait faits)
	{
		super(regles, faits);
	}

	public void evaluer()
	{
		Vector<Litteral> but = this.getBaseFaits().getButs();
		for (Litteral litteral : but)
		{
			System.out.println(this.demo(litteral, this.getBaseFaits()));
		}
	}

	public boolean demo(Litteral but, Base_de_fait BF)
	{
		Configuration.afficherTraceComplementDebut("Chainage_arriere:demo but:"+but);
		boolean dem = false;

		// 1er cas
		if (this.getBaseFaits().faits.contains(but))
		{
			Configuration.afficherTraceComplement("Présent dans la base de fait : " + but);
			dem = true;
		} else
		{
			// 2eme cas
			Configuration.afficherTraceComplement("Parcours des regles avec but : " + but);
			for (Regle regle : this.getBaseRegles().regles)
			{
				if (regle.getConclusion().contains(but) && !dem)
				{
					Configuration.afficherTraceComplement("Vérification regle but(" + but + "): " + regle);
					dem = verif(regle.getCondition(), this.getBaseFaits());
					if(dem)
					{
						regle.declencher(this.getBaseFaits());
					}
				}
			}
		}

		// 3eme cas si b n'est pas une conclusion
		if (!dem && this.getBaseRegles().getDemandable().contains(but))
		{
			// On demande à l'utilisateur si il peut faire partie de la base de
			// fait
			Configuration.afficherTraceComplement("Demande utilisateur du but demandable : " + but);
			dem = Console.demanderBoolean("Question :\n " + but + " ?");
			if(dem)
			{
				this.getBaseFaits().addFait(but);
			}
		}

		if (dem)
		{
			Configuration.afficherTraceComplement("Ajout du but à la base de fait : " + but);
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
					Configuration.afficherTraceComplement("Vérification  but : " + but);
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
