class Newton {
	public interface Function {
		double calculate(double x);
	}
	
	public static void main(String[] args) {
		
		// b)
		double b = calculate(1, Math.pow(10, -14), Math.pow(10, -7), 20, new Function() {
			public double calculate(double x) {
				return x*x - 42;
			}
		}, new Function() {
			public double calculate(double x) {
				return 2*x;
			}
		});
		System.out.println("Approximation with f(x)=x^2-42: " + b);
		
		// c)
		double c = calculate(96, Math.pow(10, -14), Math.pow(10, -8), 20, new Function() {
			public double calculate(double x) {
				return x*x - 4;
			}
		}, new Function() {
			public double calculate(double x) {
				return 2*x;
			}
		});
		System.out.println("Approximation with f(x)=x^2-42: " + c);
	}
	
	private static double calculate(double x0, double epsilon, double tolerance, int maxIterations, Function f, Function fPrime ) {
		// Start value x0=1
		// f = x^2 - 42
		// f'= 2x
		
		double x1 = 0.0;
		boolean foundResult = false;
		int iterations = 0;
		for(; iterations < maxIterations; iterations++) {
			double y = f.calculate(x0);
			double yPrime = fPrime.calculate(x0);
			
			if( Math.abs(yPrime) < epsilon) {
				System.out.println("Warning: denominator is too small");
				break;
			}
			
			x1 = x0 - y / yPrime;
			
			if(Math.abs(x1 - x0) / Math.abs(x1) < tolerance) {
				foundResult = true;
				break;
			}
			
			x0 = x1;
		}
		
		if (foundResult) {
			System.out.println("Found result in " + iterations + " steps.");
			return x1;
		}
		throw new IndexOutOfBoundsException("Not able to find solution within the desired tolerance of " + tolerance + " Last computed approximate root was " + x1);
	}
}