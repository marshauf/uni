class Person  {
	//Felder
    	String name;
    	String vorname;
	String strase;
	String ort;
	int plz;

    	//Konstruktor
    	Person(String n,String v,String st,String o, int p){
		name = n;
		vorname = v;
		strase = st;
		ort = o;
		plz = p;
    	}

	@Override
	public String toString() {
		return "Person(" + name + "," + vorname + "," + strase + "," + ort + "," + plz + ")";
	}
}
