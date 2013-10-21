package vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class AvantArriere extends JPanel implements ActionListener
{
	private JRadioButton avant = new JRadioButton("Avant  ", true);
	private JRadioButton arriere = new JRadioButton("Arriere", false);
	private JRadioButton mixte = new JRadioButton("Mixte", false);

	public AvantArriere()
	{
		JLabel label = new JLabel("Chainage :");

		avant.addActionListener(this);
		arriere.addActionListener(this);
		mixte.addActionListener(this);
		
		ButtonGroup groupe = new ButtonGroup();
		groupe.add(avant);
		groupe.add(arriere);
		groupe.add(mixte);

		JPanel panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		panneau.add(avant, BorderLayout.NORTH);
		panneau.add(arriere, BorderLayout.CENTER);
		panneau.add(mixte, BorderLayout.SOUTH);

		setLayout(new BorderLayout());
		add(label, BorderLayout.WEST);
		add(panneau, BorderLayout.CENTER);
	}
	
	public JRadioButton getMixte()
	{
		return mixte;
	}

	public void setMixte(JRadioButton mixte)
	{
		this.mixte = mixte;
	}

	public JRadioButton getAvant()
	{
		return avant;
	}

	public void setAvant(JRadioButton avant)
	{
		this.avant = avant;
	}

	public JRadioButton getArriere()
	{
		return arriere;
	}

	public void setArriere(JRadioButton arriere)
	{
		this.arriere = arriere;
	}

	public boolean estAvant()
	{
		return this.avant.isSelected();
	}
	
	public boolean estArriere()
	{
		return this.arriere.isSelected();
	}
	
	public boolean estMixte()
	{
		return this.mixte.isSelected();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == avant)
		{
			System.out.println("avant");
		} else if (e.getSource() == arriere)
		{
			System.out.println("arriere");
		}
	}
}
