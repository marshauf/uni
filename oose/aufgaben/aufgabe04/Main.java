class Main {
	public static void main(String[] args) {
		String k = Karo.karo(20, 15);
		System.out.print(k + "\n");

		String k2 = Karo.karo(3, 15);
		System.out.println(k2);

		int n = 123;
		int n2 = -123;
		int q = Karo.sumOfDigits(n);
		int q2 = Karo.sumOfDigits(n2);
		System.out.print("Sum of digits (" + n + "): " + q + "\n");
		System.out.print("Sum of digits (" + n2 + "): " + q2 + "\n\n");

		Date d = new Date(5,11,2013);
		String month = d.monthToString();
		System.out.print("Month of " + d + ":\n" + month + "\n");

		String html = d.monthAsHTML();

		System.out.print(html + "\n");
	}
}
