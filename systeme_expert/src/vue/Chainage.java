package vue;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Chainage extends JPanel implements ActionListener
{

	public JButton chainage = new JButton("START");

	public Chainage()
	{
		add(chainage, BorderLayout.CENTER);
		chainage.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == chainage)
		{
			System.out.println("chainage");
		}	
	}
}
