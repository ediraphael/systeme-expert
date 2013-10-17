package vue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialogue extends JFrame
{

	public Dialogue()
	{
		super();
	}

	public boolean afficher(String message)
	{
		int reponse = JOptionPane.showConfirmDialog(null, message, "Demande utilisateur", JOptionPane.YES_NO_OPTION);
		if (reponse == JOptionPane.YES_OPTION)
		{
			return true;
		}
		return false;
	}
}
