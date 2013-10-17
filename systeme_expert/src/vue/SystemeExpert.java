package vue;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SystemeExpert {

	public static void main(String[] arg) throws IOException{

		JFrame cadre = new javax.swing.JFrame("Systeme-expert : Motor Zero");
		
		DownloadFile dfbr = new DownloadFile("Votre Base de Régle:");
		DownloadFile dfbf = new DownloadFile("Votre Base de Fait:");
		DownloadFile dfb = new DownloadFile("Votre But:");
		AvantArriere av = new AvantArriere();
		ChoixTrace ct = new ChoixTrace();
		Chainage ch = new Chainage();
		AfficheTrace at = new AfficheTrace();

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
		panneau.setLayout(new BorderLayout(10,10));
		panneau.add(panneau1, BorderLayout.CENTER);
		panneau.add(panneau2, BorderLayout.EAST);

		cadre.setContentPane(panneau);
		cadre.setLocation(400, 300);
		cadre.pack();
		cadre.setVisible(true);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
