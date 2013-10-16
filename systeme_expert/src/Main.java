import java.util.Vector;

public class Main
{
	public static void main(String[] args)
	{
		Configuration.AFFICHER_TRACE=true;
		Configuration.AFFICHER_TRACE_LITTERAL=false;
		Configuration.AFFICHER_TRACE_FAIT=false;
		Configuration.AFFICHER_TRACE_REGLE=true;
		Configuration.AFFICHER_TRACE_COMPLEMENT=true;
		
		
		Base_de_regle base_regles = new Base_de_regle();
		Base_de_fait base_faits = new Base_de_fait();
		Base_de_but base_buts = new Base_de_but();
		base_regles.loadFile("base_regle.txt");
		base_faits.loadFile("base_fait.txt");
		base_buts.loadFile("base_but.txt");

		Chainage_abstrait chainage = new Chainage_arriere(base_regles, base_faits,base_buts);
		chainage.evaluer();
		chainage.afficherEvolution();
		// System.out.println(chainage.getFaits().estAccepte());
	}
}
