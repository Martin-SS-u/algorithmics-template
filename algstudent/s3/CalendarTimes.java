package algstudent.s3;

public class CalendarTimes {
	
	public static void main(String[] args) {
		long t1,t2;
		Calendar calendar = new Calendar();
		System.out.println("n\t\t time(ms)");
		for(int n=2 ; n < 1000000000 ; n*=2) {			
			t1 = System.currentTimeMillis();
			
			calendar.timedAlgorithm(n);
			
			t2 = System.currentTimeMillis();
			
			System.out.println(n + "\t\t" + (t2-t1));
		}
	}

}
