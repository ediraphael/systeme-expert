package vue;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.applet.*;

public class AvantArriere extends JPanel implements ActionListener
{
	JRadioButton avant = new JRadioButton("Avant  ", true);
	JRadioButton arriere = new JRadioButton("Arriere", false);

	public AvantArriere() 
	{
		JLabel label = new JLabel("Chainage :");

		avant.addActionListener(this);
		arriere.addActionListener(this);		
		
		ButtonGroup groupe = new ButtonGroup();
		groupe.add(avant);
		groupe.add(arriere);

		JPanel panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		panneau.add(avant, BorderLayout.CENTER);
		panneau.add(arriere, BorderLayout.SOUTH);

		setLayout(new BorderLayout());
		add(label, BorderLayout.WEST);
		add(panneau, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == avant)
		{
			System.out.println("avant");
		}else if(e.getSource() == arriere)
		{
			System.out.println("arriere");
		}
	}
}
