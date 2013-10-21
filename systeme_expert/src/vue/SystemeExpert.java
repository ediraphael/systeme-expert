package vue;

import modele.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Vector;

public class SystemeExpert
{
	public static Base_de_regle base_regles = new Base_de_regle();
	public static Base_de_fait base_faits = new Base_de_fait();
	public static Base_de_but base_buts = new Base_de_but();
	public static String chemin_fait = "base_fait.txt";
	public static String chemin_but = "base_but.txt";
	public static String chemin_regle = "base_regle.txt";
	public static Chainage_abstrait chainage;
	
	
	public static DownloadFile dfbr = new DownloadFile("Votre Base de Régle:",chemin_regle);
	public static DownloadFile dfbf = new DownloadFile("Votre Base de Fait:",chemin_fait);
	public static DownloadFile dfb = new DownloadFile("Votre But:",chemin_but);

	public static Base_de_regle getBase_regles()
	{
		return base_regles;
	}

	public static void setBase_regles(Base_de_regle base_regles)
	{
		SystemeExpert.base_regles = base_regles;
	}

	public static Base_de_fait getBase_faits()
	{
		return base_faits;
	}

	public static void setBase_faits(Base_de_fait base_faits)
	{
		SystemeExpert.base_faits = base_faits;
	}

	public static Base_de_but getBase_buts()
	{
		return base_buts;
	}

	public static void setBase_buts(Base_de_but base_buts)
	{
		SystemeExpert.base_buts = base_buts;
	}

	public static Chainage_abstrait getChainage()
	{
		return chainage;
	}

	public static void setChainage(Chainage_abstrait chainage)
	{
		SystemeExpert.chainage = chainage;
	}

	public static void loadFichier()
	{
		base_regles.setRegles(new Vector<Regle>());
		base_faits.setFaits(new Vector<Element_base>());
		base_buts.setButs(new Vector<Element_base>());
		base_regles.loadFile(dfbr.getPathText());
		base_faits.loadFile(dfbf.getPathText());
		base_buts.loadFile(dfb.getPathText());
	}
	
	public static void lancerAffichage() throws IOException
	{
		JFrame cadre = new javax.swing.JFrame("Systeme-expert : Motor Zero");

		AvantArriere av = new AvantArriere();
		ChoixTrace ct = new ChoixTrace();
		Chainage ch = new Chainage(av);
		AfficheTrace at = new AfficheTrace();

		Affichage.setECRAN(new Ecran_fenetre(at));
		Interface_utilisateur.setINTERFACE(new Interface_fenetre(new Dialogue()));

		JPanel panneauDF = new JPanel();
		panneauDF.setLayout(new BorderLayout());
		panneauDF.add(dfbr, BorderLayout.NORTH);
		panneauDF.add(dfbf, BorderLayout.CENTER);
		panneauDF.add(dfb, BorderLayout.SOUTH);

		JPanel panneauAV = new JPanel();
		panneauAV.setLayout(new BorderLayout());
		panneauAV.add(av, BorderLayout.CENTER);

		JPanel panneauCT = new JPanel();
		panneauCT.setLayout(new BorderLayout());
		panneauCT.add(ct, BorderLayout.CENTER);

		JPanel panneauCH = new JPanel();
		panneauCH.setLayout(new BorderLayout());
		panneauCH.add(ch, BorderLayout.CENTER);

		JPanel panneau1_1 = new JPanel();
		panneau1_1.setLayout(new BorderLayout());
		panneau1_1.add(panneauDF, BorderLayout.NORTH);
		panneau1_1.add(panneauAV, BorderLayout.CENTER);

		JPanel panneau1_2 = new JPanel();
		panneau1_2.setLayout(new BorderLayout());
		panneau1_2.add(panneauCT, BorderLayout.NORTH);

		JPanel panneau1 = new JPanel();
		panneau1.setLayout(new BorderLayout());
		panneau1.add(panneau1_1, BorderLayout.NORTH);
		panneau1.add(panneau1_2, BorderLayout.CENTER);

		JPanel panneau2 = new JPanel();
		panneau2.setLayout(new BorderLayout());
		panneau2.add(at, BorderLayout.NORTH);
		panneau2.add(panneauCH, BorderLayout.CENTER);

		JPanel panneau = new JPanel();
		panneau.setLayout(new BorderLayout(10, 10));
		panneau.add(panneau1, BorderLayout.CENTER);
		panneau.add(panneau2, BorderLayout.EAST);

		cadre.setContentPane(panneau);
		cadre.setLocation(400, 300);
		cadre.pack();
		cadre.setVisible(true);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] arg) throws IOException
	{
		Configuration.AFFICHER_TRACE = true;
		Configuration.AFFICHER_TRACE_LITTERAL = false;
		Configuration.AFFICHER_TRACE_FAIT = true;
		Configuration.AFFICHER_TRACE_REGLE = true;
		Configuration.AFFICHER_TRACE_REGLE_DECLENCHEMENT = true;
		Configuration.AFFICHER_TRACE_REGLE_AUTRE = false;
		Configuration.AFFICHER_TRACE_BUT = false;
		Configuration.AFFICHER_TRACE_COMPLEMENT = false;

		SystemeExpert.lancerAffichage();
	}
}
