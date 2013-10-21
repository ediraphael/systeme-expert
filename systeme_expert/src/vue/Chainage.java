package vue;

import javax.swing.*;

import modele.Affichage;
import modele.Chainage_arriere;
import modele.Chainage_avant;
import modele.Chainage_mixte;
import modele.Interface_utilisateur;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Chainage extends JPanel implements ActionListener
{
	private JButton chainage = new JButton("START");
	private AvantArriere avar;

	public Chainage(AvantArriere avar)
	{
		add(chainage, BorderLayout.CENTER);
		chainage.addActionListener(this);
		this.avar = avar;
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == chainage)
		{
			System.out.println("chainage");
			Affichage.reset();
			SystemeExpert.loadFichier();
			if (avar.estAvant())
			{
				SystemeExpert.setChainage(new Chainage_avant(SystemeExpert.getBase_regles(), SystemeExpert.getBase_faits(), SystemeExpert.getBase_buts()));
			}
			if (avar.estArriere())
			{
				SystemeExpert.setChainage(new Chainage_arriere(SystemeExpert.getBase_regles(), SystemeExpert.getBase_faits(), SystemeExpert.getBase_buts()));
			}
			if (avar.estMixte())
			{
				SystemeExpert.setChainage(new Chainage_mixte(SystemeExpert.getBase_regles(), SystemeExpert.getBase_faits(), SystemeExpert.getBase_buts()));
			}
			SystemeExpert.getChainage().evaluer();
			SystemeExpert.getChainage().afficherEvolution();
			Interface_utilisateur.lireClavier(SystemeExpert.getChainage().butEstAtteint()?"but("+SystemeExpert.getBase_buts().getButs()+"):atteint":"but("+SystemeExpert.getBase_buts().getButs()+"):non atteint");
			
		}
	}
}
