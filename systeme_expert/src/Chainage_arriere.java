import java.util.Vector;

public class Chainage_arriere extends Chainage_abstrait {
	public Chainage_arriere(Base_de_regle regles, Base_de_fait faits) {
		super(regles, faits);
	}

	public void evaluer() {
		for (Litteral litteral : Liste_litteral.values()) {
			if (evaluerArriere(litteral)) {
				this.getFaits().getFaits().add(litteral);
			}
		}

	}

	public boolean evaluerArriere(Litteral b) {
		boolean dem = false;

		// Premier cas evident
		for (Litteral flitteral : this.getFaits().getFaits()) {
			if (b.toString().equals(flitteral.toString()))
				dem = true;
		}

		// 2eme cas: rechercher si litteral deductible a partir de BR U BF
		for (Regle regle : this.getRegles().getRegles()) {
			for (Litteral r : regle.getConclusion()) {
				if (r.toString().equals(b.toString())) {
					while (dem == false) {
						dem = Verif(regle.getCondition(), this.getFaits());
					}
				}
			}
		}

		// 3eme cas: sinon voir si b est demandable

		// A faire

		return dem;
	}

	public boolean Verif(Vector<Litteral> condition, Base_de_fait BF) {
		boolean ver = true;

		for (Litteral b : BF.getFaits()) {
			while (ver) {
				ver = evaluerArriere(b);
			}
		}
		return ver;
	}

}
