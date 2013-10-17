package modele;
public class Element_base
{
	Litteral litteral;
	Boolean estNonElement;
	
	public Element_base(Litteral litteral)
	{
		this.litteral = litteral;
		this.estNonElement = false;
	}
	
	public Element_base(Litteral litteral, Boolean estNonElement)
	{
		this.litteral = litteral;
		this.estNonElement = estNonElement;
	}

	public Litteral getLitteral()
	{
		return litteral;
	}

	public void setLitteral(Litteral litteral)
	{
		this.litteral = litteral;
	}

	public Boolean getEstNonElement()
	{
		return estNonElement;
	}

	public void setEstNonElement(Boolean estNonElement)
	{
		this.estNonElement = estNonElement;
	}
	
	public String toString()
	{
		return ((estNonElement)?"!":"")+litteral;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Element_base))
		{
			return false;
		} else if (!((Element_base) obj).getLitteral().equals(this.getLitteral()))
		{
			return false;
		} else if (!((Element_base) obj).getEstNonElement().equals(this.getEstNonElement()))
		{
			return false;
		}
		return true;
	}

}
