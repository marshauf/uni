class Datum {
	int tag;
    	int monat;
	int jahr;
	
	Datum(int tag, int monat, int jahr) {
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;	
	}
	
	@Override
	public String toString() {
		return "Datum(" + tag + "," + monat + "," + jahr + ")";
	}
}
