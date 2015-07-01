class Test {
	class TestDataFib {
		int n;
		int expected;
		TestDataFib(int n, int expected) {
			this.n = n;
			this.expected = expected;
		}
	}
	
	class TestDataGeometricObjectTouches {
		GeometricObject g1;
		GeometricObject g2;
		boolean expected;
		
		TestDataGeometricObjectTouches(GeometricObject g1, GeometricObject g2, boolean expected) {
			this.g1 = g1;
			this.g2 = g2;
			this.expected = expected;
		}
	}
	
	void run() {
		TestDataFib[] testTableFib = new TestDataFib[]{
			new TestDataFib(-8,-21),new TestDataFib(-7,13),new TestDataFib(-6,-8),new TestDataFib(-5,5),new TestDataFib(-4,-3),new TestDataFib(-3,2),new TestDataFib(-2,-1),new TestDataFib(-1,1),
			new TestDataFib(0,0),new TestDataFib(1,1),new TestDataFib(2,1),new TestDataFib(3,2),new TestDataFib(4,3),new TestDataFib(5,5),new TestDataFib(6,8),new TestDataFib(7,13),new TestDataFib(8,21),
		};
		
		int[] testTableNextFib = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169}; // Fibonacci numbers excluding F0
		
		TestDataGeometricObjectTouches[] testTableTouches = new TestDataGeometricObjectTouches[]{
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(0,0), 1, 1), new GeometricObject(new Vertex(0.25, 0.25), 0.5, 0.5), true), // inside
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(0.25, 0.25), 0.5, 0.5), new GeometricObject(new Vertex(0,0), 1, 1), true), // inside
			
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(0,0), 1, 1), new GeometricObject(new Vertex(-0.5, -0.5), 1, 1), true), // inside
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(-0.5, -0.5), 1, 1), new GeometricObject(new Vertex(0,0), 1, 1), true), // inside
			
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(0, 0), 1, 1), new GeometricObject(new Vertex(1,1), 1, 1), true), // touches
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(1,1), 1, 1), new GeometricObject(new Vertex(0, 0), 1, 1), true), // touches
			
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(0,0), 1, 2), new GeometricObject(new Vertex(1, 2), 1, 1), true), // touches on the edge
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(1, 2), 1, 1), new GeometricObject(new Vertex(0,0), 1, 2), true), // touches on the edge
			
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(0, 0), 1, 1), new GeometricObject(new Vertex(0.5,0.5), 1, 1), true), // x1,y1 is inside
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(0.5,0.5), 1, 1), new GeometricObject(new Vertex(0, 0), 1, 1), true), // x2,y2 is inside
			
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(0,0), 1, 1), new GeometricObject(new Vertex(1.1, 1.1), 1, 1), false),
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(1.1, 1.1), 1, 1), new GeometricObject(new Vertex(0,0), 1, 1), false),
			
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(-1, -1), 1, 1), new GeometricObject(new Vertex(1,1), 1, 1), false),
			new TestDataGeometricObjectTouches(new GeometricObject(new Vertex(1,1), 1, 1), new GeometricObject(new Vertex(-1, -1), 1, 1), false),
		};
		
		for (int i = 0; i < testTableFib.length; i++) {
			int obtained = Fib.fib(testTableFib[i].n);
			if (obtained != testTableFib[i].expected) {
				System.out.printf("obtained %d expected %d %n", obtained, testTableFib[i].expected);
			}
		}
		
		Fib f = new Fib();
		for (int i = 0; i < testTableNextFib.length; i++) {
			int obtained = f.nextFib();
			if (obtained != testTableNextFib[i]) {
				System.out.printf("obtained %d expected %d %n", obtained, testTableFib[i]);
			}
		}
		
		for (int i = 0; i < testTableTouches.length; i++) {
			boolean obtained = testTableTouches[i].g1.touches(testTableTouches[i].g2);
			if (obtained != testTableTouches[i].expected) {
				System.out.printf("%s touches %s -> obtained %s expected %s %n", testTableTouches[i].g1, testTableTouches[i].g2, obtained, testTableTouches[i].expected);
			}
		}
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.run();
	}
}