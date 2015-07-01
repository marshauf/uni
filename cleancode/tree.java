class Tree {
	
	static void drawTree(int height, boolean tip) {
		int beforeCenter = height - 1;
		StringBuilder sb = new StringBuilder();
		if (tip) {
			sb.append(new String(new char[beforeCenter]).replace("\0", " "));
			sb.append(String.format("*%n"));
		}
		for (int i = 0; i < height; i++) {
			sb.append(new String(new char[beforeCenter - i]).replace("\0", " "));
			sb.append(new String(new char[2 * i + 1]).replace("\0", "X"));
			sb.append(String.format("%n"));
		}
		sb.append(new String(new char[beforeCenter]).replace("\0", " "));
		sb.append(String.format("X%n"));
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		drawTree(5, true);
		drawTree(10, false);
	}
}