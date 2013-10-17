package vue;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class DownloadFile extends JPanel implements ActionListener
{
	public JButton param = new JButton("parcourir");
	private JTextField path = new JTextField(30);

	public DownloadFile(String name)
	{
		JLabel label = new JLabel(name);
		setLayout(new BorderLayout(10, 10));
		add(label, BorderLayout.NORTH);
		add(path, BorderLayout.CENTER);
		add(param, BorderLayout.EAST);
		param.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == param)
		{
			JFileChooser dialogue = new JFileChooser(new File("."));
			//PrintWriter sortie;
			File fichier;

			if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				fichier = dialogue.getSelectedFile();
				path.setText(fichier.getAbsolutePath());
			}
		}
	}
}
