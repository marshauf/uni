package name.marcelhauf.oose13;

public class Date {
	int day;
    	int month;
	int year;
	
	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;	
	}
	
	@Override
	public String toString() {
		return "Date(" + day + "," + month + "," + year + ")";
	}

	int compare(Date d) {
		if (year < d.year)  {
			return -1;
		}
		if (year == d.year) {
			if (month < d.month) {
				return -1;
			}
			if (month == d.month) {
				if (day < d.day) {
					return -1;
				}
				if (day == d.day) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	boolean isEarlierThan(Date d) {
		return compare(d) < 0;
	}

	boolean isLaterThan(Date d) {
		return compare(d) > 0;
	}

	boolean sameDay(Date d) {
		return compare(d) == 0;
	}

	boolean isLeapYear() {
		return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
	}

	int getAbsoluteDaysInYear() {
		return isLeapYear() ? 365 : 364;
	}

	static int[] daysInMonth = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

	int getDaysInMonth() {
		int days = daysInMonth[month-1];
		if (month == 2 && isLeapYear()) {
			return days + 1;
		}
		return days;
	}

	int dayNumber() {
		return day % 7;
	}

	static int[] monthNumbers = new int[]{0,3,3,6,1,4,6,2,5,0,3,5};

	int monthNumber() {
		return monthNumbers[month-1];
	}

	int yearNumber() {
		int jz = year % 100;
		return (jz + (jz / 4)) % 7;
	}

	int centuryNumber() {
		int jh = year / 100;
		return (3 - (jh % 4)) * 2;
	}

	int weekDay() {
		int correction = isLeapYear() ? -1 : 0; 
		return (dayNumber() + monthNumber() + yearNumber() + centuryNumber() + correction) % 7;
	}
	
	// Easter calculation based on Hermann Kinkelin and Christian Zellers work which is based on Carl Friedrich Gauß's work.
	// Gregorian calendar.
	public Date getEasterDay() {
		int k = year / 100;
		int m = 15 + (3 * k + 3) / 4 - (8 * k + 13) / 25;
		int s = 2 - (3 * k + 3) / 4;
		int a = year % 19;
		int d = (19 * a + m) % 30;
		int r = (d + a / 11) / 29;
		int og = 21 + d - r;
		int sz = 7 - (year + year / 4 + s) % 7;
		int oe = 7 - (og - sz) % 7;
		int os = og + oe;
		
		int month = 3;
		while (os > 31) {
			month++;
			os -= 31;
		}
		
		return new Date(os, month, this.year);
	}

	static String[] germanWeekNames = new String[]{"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Sonnabend"};
	
	String weekDayName() {
		int wDay = weekDay();
		return germanWeekNames[wDay];
	}

	String monthToString() {
		Date tmp = new Date(1,month, year);
		StringBuilder sb = new StringBuilder();
		for (int n = 1; n <= getDaysInMonth(); n++) {
			tmp.day = n;
			sb.append(tmp.weekDayName());
			sb.append(" der ");
			sb.append(tmp.day);
			sb.append(".");
			sb.append(tmp.month);
			sb.append(".");
			sb.append(tmp.year);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	String monthAsHTML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<table>\n");
		sb.append("\t<tr><th>Mo</th><th>Di</th><th>Mi</th><th>Do</th><th>Fr</th><th>Sb</th><th>So</th></tr>\n");
		
		Date tmp = new Date(1, month, year);
		int wDay = tmp.weekDay() - 1;
		if (wDay < 0) {
			wDay = 6;
		}
		sb.append("\t<tr>");
		for (int i = 0; i < wDay; i++) {
			sb.append("<td></td>");
		}
					
		for (int n = 1; n <= getDaysInMonth(); n++) {
			tmp.day = n;
			wDay = tmp.weekDay() - 1;
			if (wDay < 0) {
				wDay = 6;
			}
			if (wDay == 0) {
				sb.append("\t<tr>");
			}
			sb.append("<td>");
			if (tmp.day == day) {
				sb.append("<b>");
				sb.append(tmp.day);
				sb.append("</b>");
			} else {
				sb.append(tmp.day);
			}

			sb.append("</td>");
			
			if (wDay == 6 || n == getDaysInMonth()) {
				sb.append("</tr>\n");
			}
		}
		
		sb.append("</table>");
		return sb.toString();
	}
}
