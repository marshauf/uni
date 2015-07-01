package name.marcelhauf.oose13.dialogue;

import name.panitz.oose13.dialogue.*;

class LowerCaseButtonLogic extends  ButtonLogic { 
	
	public String getDescription() {
		return "in Kleinbuchstaben umwandeln";
	}

	public String eval(String x) {
		return x.toLowerCase();
	}
}
