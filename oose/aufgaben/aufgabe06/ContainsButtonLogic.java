package name.marcelhauf.oose13.dialogue;

import name.panitz.oose13.dialogue.*;

public class ContainsButtonLogic extends ButtonLogic {
	
	public String val;
	
	public ContainsButtonLogic(String val) {
		this.val = val;
	}
	
	public String getDescription() {
		return "Does string contain \""+ val + "\"?";
	}

	public String eval(String x) {
		if (x.contains(val)) {
			return "Does contain \"" + val + "\".";
		}
		return "Does not contain \"" + val + "\".";
	}
}
