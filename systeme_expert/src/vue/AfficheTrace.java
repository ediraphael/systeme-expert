package vue;

import javax.swing.*;
import java.awt.*;
import java.io.*;

@SuppressWarnings("serial")
class AfficheTrace extends JPanel
{
	JEditorPane grandeZone;

	public AfficheTrace() throws IOException
	{

		JScrollPane texteAsc;
		grandeZone = new JEditorPane("Affichage des traces", "");
		grandeZone.setEditable(false);
		texteAsc = new JScrollPane(grandeZone);
		texteAsc.setPreferredSize(new Dimension(600, 300));
		add(texteAsc, BorderLayout.CENTER);
	}

	public void rajouterTexte(String texte)
	{
		grandeZone.setText((grandeZone.getText().concat("\n")).concat(texte));
	}

	public void reset()
	{
		System.out.println("reset de l'affichage");
		grandeZone.setText("");
	}
}
