package name.marcelhauf.oose13.dialogue;

import name.panitz.oose13.dialogue.*;
import name.marcelhauf.oose13.Date;

class EasterDayButtonLogic extends ButtonLogic {
	public String getDescription() {
		return "Get easter day";
	}

	public String eval(String x) {
		try{
			int year = Integer.parseInt(x);
			Date d = new Date(1,1,year);
			return d.getEasterDay().toString();
		}catch(NumberFormatException ex) {
			return ex.toString();
		}
	}
}

