import java.util.Vector;

public class Litteral
{
	//poste_responsabilite, langue_facile, neerlandais_parle, anglais_parle, candidat_dynamique, bonne_adaptabilite, capacite_leadership, est_slave, accepte
	private String libelle;

	public Litteral(String libelle)
	{
		this.libelle = libelle.trim();
	}

	public String getLibelle()
	{
		return this.libelle;
	}

	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}	
	
	public String toString()
	{
		return libelle;
	}
}
