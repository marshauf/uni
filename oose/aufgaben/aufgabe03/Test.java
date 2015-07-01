class Test {
	class TestValue {
		Date d;
		int expectedWeekDay;

		TestValue(Date d, int weekDay) {
			this.d = d;
			expectedWeekDay = weekDay;
		}
	}

	TestValue[] testTable;

	Test() {
		testTable = new TestValue[]{
			new TestValue(new Date(14, 7, 1789), 2),
			new TestValue(new Date(23, 5, 1949), 1),
			new TestValue(new Date(18, 1, 1892), 1),
			new TestValue(new Date(9, 11, 1989), 4),
		};
	}
	
	
	void run() {
		for (int i = 0; i < testTable.length; i++) {
			int obtained = testTable[i].d.weekDay();
			if (obtained != testTable[i].expectedWeekDay) {
				System.out.println("Test error in TestTable index:" + i);
				System.out.println("Obtained weekDay: " + obtained + " expected weekDay: " + testTable[i].expectedWeekDay);
				System.out.println("Day:");
				System.out.println("dayNumber:" + testTable[i].d.dayNumber());
				System.out.println("monthNumber:" + testTable[i].d.monthNumber());
				System.out.println("yearNumber:" + testTable[i].d.yearNumber());
				System.out.println("centuryNumber:" + testTable[i].d.centuryNumber());
				System.out.println("isLeapYear:" + testTable[i].d.isLeapYear());
				System.out.println("weekDay:" + testTable[i].d.weekDay());
			}
		}
	}
}