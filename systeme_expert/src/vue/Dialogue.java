package vue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Dialogue extends JFrame
{
	public Dialogue()
	{
		super();
	}

	public boolean afficher_demande(String message)
	{
		int reponse = JOptionPane.showConfirmDialog(null, message, "Demande utilisateur", JOptionPane.YES_NO_OPTION);
		if (reponse == JOptionPane.YES_OPTION)
		{
			return true;
		}
		return false;
	}

	public String afficher_message(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Résultat", JOptionPane.INFORMATION_MESSAGE);
		return "ok";
	}
}
