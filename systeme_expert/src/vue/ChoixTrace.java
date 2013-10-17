package vue;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.applet.*;

public class ChoixTrace extends JPanel implements ActionListener
{
	JCheckBox cBox1 = new JCheckBox("Afficher les traces de déclenchement des régles", false);
	JCheckBox cBox2 = new JCheckBox("Afficher les autres traces de régles", false);

	JCheckBox cBox3 = new JCheckBox("Afficher les traces de faits", false);
	JCheckBox cBox4 = new JCheckBox("Afficher les traces de buts", false);
	JCheckBox cBox5 = new JCheckBox("Afficher les traces de litterals", false);
	JCheckBox cBox6 = new JCheckBox("Afficher les traces de complément", false);

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
		}else if(e.getSource() == cBox2)
		{
			System.out.println("cBox2");
		}else if(e.getSource() == cBox3)
		{
			System.out.println("cBox3");
		}else if(e.getSource() == cBox4)
		{
			System.out.println("cBox4");
		}else if(e.getSource() == cBox5)
		{
			System.out.println("cBox5");
		}else if(e.getSource() == cBox6)
		{
			System.out.println("cBox6");
		}
	}
}
