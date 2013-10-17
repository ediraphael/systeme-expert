package vue;

import javax.swing.*;

import modele.Configuration;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ChoixTrace extends JPanel implements ActionListener
{
	JCheckBox cBox1 = new JCheckBox("Afficher les traces de déclenchement des régles", Configuration.AFFICHER_TRACE_REGLE_DECLENCHEMENT);
	JCheckBox cBox2 = new JCheckBox("Afficher les autres traces de régles", Configuration.AFFICHER_TRACE_REGLE_AUTRE);

	JCheckBox cBox3 = new JCheckBox("Afficher les traces de faits", Configuration.AFFICHER_TRACE_FAIT);
	JCheckBox cBox4 = new JCheckBox("Afficher les traces de buts", Configuration.AFFICHER_TRACE_BUT);
	JCheckBox cBox5 = new JCheckBox("Afficher les traces de litterals", Configuration.AFFICHER_TRACE_LITTERAL);
	JCheckBox cBox6 = new JCheckBox("Afficher les traces de complément", Configuration.AFFICHER_TRACE_COMPLEMENT);

	Box panneauCocher = Box.createVerticalBox();
	
	public ChoixTrace() 
	{
		cBox1.addActionListener(this);
		cBox2.addActionListener(this);
		cBox3.addActionListener(this);
		cBox4.addActionListener(this);
		cBox5.addActionListener(this);
		cBox6.addActionListener(this);
		
		panneauCocher.add(cBox1);
		panneauCocher.add(cBox2);
		panneauCocher.add(cBox3);
		panneauCocher.add(cBox4);
		panneauCocher.add(cBox5);
		panneauCocher.add(cBox6);
		

		setLayout(new BorderLayout());
		add(panneauCocher, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == cBox1)
		{
			System.out.println("cBox1");
			Configuration.AFFICHER_TRACE_REGLE_DECLENCHEMENT=cBox1.isSelected();
		}else if(e.getSource() == cBox2)
		{
			System.out.println("cBox2");
			Configuration.AFFICHER_TRACE_REGLE_AUTRE=cBox2.isSelected();
		}else if(e.getSource() == cBox3)
		{
			System.out.println("cBox3");
			Configuration.AFFICHER_TRACE_FAIT=cBox3.isSelected();
		}else if(e.getSource() == cBox4)
		{
			System.out.println("cBox4");
			Configuration.AFFICHER_TRACE_BUT=cBox4.isSelected();
		}else if(e.getSource() == cBox5)
		{
			System.out.println("cBox5");
			Configuration.AFFICHER_TRACE_LITTERAL=cBox5.isSelected();
		}else if(e.getSource() == cBox6)
		{
			System.out.println("cBox6");
			Configuration.AFFICHER_TRACE_COMPLEMENT=cBox6.isSelected();
		}
	}
}
