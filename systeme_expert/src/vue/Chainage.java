package vue;

import javax.swing.*;

import modele.Affichage;
import modele.Chainage_arriere;
import modele.Chainage_avant;

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
			SystemeExpert.base_faits.loadFile("base_fait.txt");
			if (avar.estAvant())
			{
				SystemeExpert.setChainage(new Chainage_avant(SystemeExpert.getBase_regles(), SystemeExpert.getBase_faits(), SystemeExpert.getBase_buts()));
			}
			if (avar.estArriere())
			{
				SystemeExpert.setChainage(new Chainage_arriere(SystemeExpert.getBase_regles(), SystemeExpert.getBase_faits(), SystemeExpert.getBase_buts()));
			}
			System.out.println("la1");
			System.out.println(SystemeExpert.getChainage().getClass());
			SystemeExpert.getChainage().evaluer();
			System.out.println("la2");
			SystemeExpert.getChainage().afficherEvolution();
			System.out.println("la3");
		}
	}
}
