package algstudent.s5;

public class MinimumPathTimes {
	
	public static void main(String arg[]) {
		int[][] weights;
		int[][] costs;
		int[][] p;
		String[] v;
		
		long t1,t2;
		System.out.println("SIZE: \t\tTIME");
		for(int n = 200 ; n < 20000000 ; n*=2) {
			
			// Start timer
			t1 = System.currentTimeMillis();
			
			MinimumPaths.basicAlgorithm(n);
			
			// End timer
			t2 = System.currentTimeMillis();
			
			System.out.println(n + "\t\t" + (t2-t1));
			
		}
	}	

}
