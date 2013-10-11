
public class Main
{
	public static void main(String[] args)
	{
		Base_de_regle base_regles = new Base_de_regle();
		Base_de_fait base_faits = new Base_de_fait();
		base_regles.loadFileBaseRegle();
		base_faits.loadFileBaseFait();
		
		Chainage_avant chainage_avant = new Chainage_avant(base_regles, base_faits);
		chainage_avant.evaluer();
		chainage_avant.afficherEvolution();
		System.out.println(chainage_avant.getFaits().estAccepte());
	}
}
