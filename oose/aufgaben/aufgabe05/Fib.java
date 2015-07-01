public class Fib {
	int n1 = 1;
	int n2 = 0;
	
	public int nextFib() {
		int f = n1+n2;
		n2 = n1;
		n1 = f;
		return n2;
	}
	
	public static int fib(int n) {
		if (n < 0) { return negafib(n); }
		return posfib(n);
		
	}
	
	private static int posfib(int n) {
		switch (n) {
		case 0:
			return 0;
		case 1:
			return 1;
		}
		return posfib(n - 1) + posfib(n - 2);
	}
	
	private static int negafib(int n) {
		int m = posfib(-n);
		if ((n + 1) % 2 == 0) {
			return m;
		}
		return -m;
	}
}