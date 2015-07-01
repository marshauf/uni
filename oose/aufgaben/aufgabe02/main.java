class main {
	public static void main(String[] args) {
		Person person = new Person("Marcel","Hauf","MeineStraße","Ort",6501);
		Buch buch = new Buch("Go - von Grund auf","Marcel Hauf",2013);
		Datum datum = new Datum(21,10,2013);
		Ausleihe ausleihe = new Ausleihe(buch, person, datum);
		
		try {
			Vertex v1 = new Vertex(0,0);
			Vertex v2 = new Vertex(1,2);
			
			v1.moveTo(v2);
			if (v1.x != v2.x || v1.y != v2.y) {
				throw new Exception("v1 and v2 do not have equal values");
			}
			
			v1.move(v2);
			if (v1.x != 2) {
				throw new Exception("v1.x does not equal 2");
			}
			if (v1.y != 4) {
				throw new Exception("v1.y does not equal 4");
			}
			if (v2.x != 1) {
				throw new Exception("v2.x does not equal 1");
			}
			if (v2.y != 2) {
				throw new Exception("v2.y does not equal 2");
			}
		} catch(Exception ex) {
			System.out.println(ex);
			return;
		}
	}
}
