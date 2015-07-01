class Ausleihe {
	Buch buch;
    	Person ausleiher;
	Datum rückgabe;

	Ausleihe(Buch b, Person a, Datum r){
		buch = b;
		ausleiher = a;
		rückgabe = r;
	}
	
	@Override
	public String toString() {
		return "Ausleihe(" + buch + "," + ausleiher + "," + rückgabe + ")";
	}
}
