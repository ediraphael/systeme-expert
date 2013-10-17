import java.util.Vector;

public class Chainage_arriere extends Chainage_abstrait
{
	public Chainage_arriere(Base_de_regle regles, Base_de_fait faits, Base_de_but buts)
	{
		super(regles, faits, buts);
	}

	public void evaluer()
	{
		Vector<Element_base> but = this.getBase_buts().getButs();
		for (Element_base element : but)
		{
			this.demo(element, this.getBase_faits());
		}
	}

	public boolean demo(Element_base but, Base_de_fait BF)
	{
		Configuration.afficherTraceComplementDebut("Chainage_arriere:demo but:" + but);
		boolean dem = false;

		// 1er cas
		if (this.getBase_faits().getFaits().contains(but))
		{
			Configuration.afficherTraceComplement("Présent dans la base de fait : " + but);
			dem = true;
		} else
		{
			// 2eme cas
			Configuration.afficherTraceComplement("Parcours des regles avec but : " + but);
			for (Regle regle : this.getBase_regles().getRegles())
			{
				if (regle.getConclusion().contains(but) && !regle.estEnIncoherence(this.getBase_faits().getFaits()) && !dem)
				{
					Configuration.afficherTraceComplement("Vérification regle but(" + but + "): " + regle);
					dem = verif(regle.getCondition(), this.getBase_faits());
					if (dem)
					{
						regle.declencher(this.getBase_faits());
					}
				}
			}
		}

		// 3eme cas si b n'est pas une conclusion
		if (!dem && this.getBase_regles().getDemandable().contains(but))
		{
			// On demande à l'utilisateur si il peut faire partie de la base de
			// fait
			Configuration.afficherTraceComplement("Demande utilisateur du but demandable : " + but);
			dem = Console.demanderBoolean("Question :\n " + but + " ?");
			if (dem)
			{
				this.getBase_faits().addElement(but);
			}
		}

		/*if (dem)
		{
			BF.addElement(but);
		}*/
		Configuration.afficherTraceComplementFin("Chainage_arriere:demo but:"+ but);
		return dem;
	}

	public boolean verif(Vector<Element_base> but, Base_de_fait BF)
	{
		Configuration.afficherTraceComplementDebut("Chainage_arriere:verif but:"+but);
		boolean ver = true;
		for (Element_base b : but)
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
		Configuration.afficherTraceComplementFin("Chainage_arriere:verif but:"+but);
		return ver;
	}
}
