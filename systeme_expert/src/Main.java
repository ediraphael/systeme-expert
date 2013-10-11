
public class Main
{
	public static void main(String[] args)
	{
		Base_de_regle base_regles = new Base_de_regle();
		Base_de_fait base_faits = new Base_de_fait();
		base_regles.loadFileBaseRegle();
		base_faits.loadFileBaseFait();
		
		Chainage_abstrait chainage = new Chainage_avant(base_regles, base_faits);
		chainage.evaluer();
		chainage.afficherEvolution();
		System.out.println(chainage.getFaits().estAccepte());
	}
}
