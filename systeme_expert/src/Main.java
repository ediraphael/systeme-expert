public class Main
{
	public static void main(String[] args)
	{
		Configuration.AFFICHER_TRACE=true;
		Configuration.AFFICHER_TRACE_LITTERAL=false;
		Configuration.AFFICHER_TRACE_FAIT=false;
		Configuration.AFFICHER_TRACE_REGLE=true;
		Configuration.AFFICHER_TRACE_COMPLEMENT=false;
		
		
		Base_de_regle base_regles = new Base_de_regle();
		Base_de_fait base_faits = new Base_de_fait();
		base_regles.loadFileBaseRegle();
		base_faits.loadFileBaseFait();
		base_faits.addBut("accepte");

		Chainage_abstrait chainage = new Chainage_arriere(base_regles, base_faits);
		chainage.evaluer();
		chainage.afficherEvolution();
		// System.out.println(chainage.getFaits().estAccepte());
	}
}
