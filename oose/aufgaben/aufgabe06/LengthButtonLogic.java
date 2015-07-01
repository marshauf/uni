package name.marcelhauf.oose13.dialogue;

import name.panitz.oose13.dialogue.*;

class LengthButtonLogic extends ButtonLogic {
	public String getDescription() {
		return "Länge:";
	}

	public String eval(String x) {
		return String.format("%d", x.length());
	}
	
}
