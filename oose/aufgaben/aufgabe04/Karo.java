class Karo {
	static String karo(int columns, int rows) {
		StringBuilder sb = new StringBuilder();
		
		boolean useX = true;
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				if (useX) {
					sb.append("X");
				} else {
					sb.append("O");
				}

				useX = !useX;
			}
			if (columns % 2 == 0) {
				useX = !useX;
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	static int sumOfDigits(int n) {
		if (n == 0) { return 0; }
		return abs(n % 10) + sumOfDigits(n / 10);
	}

	static int abs(int n) {
		return n < 0 ? -n : n;
	}
}
