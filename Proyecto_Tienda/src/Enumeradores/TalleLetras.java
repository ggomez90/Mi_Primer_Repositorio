package Enumeradores;

public enum TalleLetras {
	
	DOBLE_EXTRA_SMALL("XXS"),
	EXTRA_SMALL("XS"),
	SMALL("S"),
	MEDIUM("M"),
	BIG("L"),
	EXTRA_BIG("XL"),
	DOBLE_EXTRA_BIG("XXL"),
	TRIPLE_EXTRA_BIG("XXXL"),
	ESPECIAL("ESPECIAL");
	
	private String abreviatura;
	
	private TalleLetras (String abreviatura)
	{
		this.abreviatura = abreviatura;
	}
	
	public String getAbreviatura()
	{
		return this.abreviatura;
	}

}
