class Buch {
	String titel;
    	String autor;
    	int preis;

	Buch(String t, String autor ,int preisInEuroCent){
		titel = t;
		autor = autor;
		preis = preisInEuroCent;
    	}
	
	@Override
	public String toString() {
		return "Buch(" + titel + "," + autor + "," + preis + ")";
	}
}
