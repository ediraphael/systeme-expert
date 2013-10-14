import java.util.Vector;

public class Chainage_arriere extends Chainage_abstrait {
	public Chainage_arriere(Base_de_regle regles, Base_de_fait faits) {
		super(regles, faits);
	}

	public void evaluer() {
		Litteral but = this.getFaits().faits.lastElement();
		this.demo(but, this.getFaits());
	}

	public boolean demo(Litteral but, Base_de_fait BF) {
		boolean dem = false;

		// 1er cas
		if (this.getFaits().faits.contains(but))
			dem = true;

		// 2eme cas
		for (Regle regle : this.getRegles().regles) {
			if (regle.getConclusion().contains(but)) {
				dem = verif(regle.getCondition(), this.getFaits());
			}
		}
		
		// 3eme cas
		
		if(dem)
		{
			this.getFaits().addFait(but);
		}

		return dem;

	}

	public boolean verif(Vector<Litteral> but, Base_de_fait BF)
	{
		boolean ver=true;
		
		for(Litteral b : but)
		{
			if(ver==true)
			{
				ver=demo(b,BF);
			}
		}
			
		return ver;
	}
}
