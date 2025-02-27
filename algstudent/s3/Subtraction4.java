package algstudent.s3;

/* 
 * Params: a=1 ; b=1 ; k=2
 * The time complexity is quadratic O(n^3) 
 */
public class Subtraction4 {
	public static long rec4(int n) {
		long cont = 0;
		if (n <= 0)
			cont++;
		else {
			for (int i = 0; i < n; i++) //O(n^2)
				for (int j = 0; j < n; j++) // O(n)
					cont++; 
			rec4(n - 1);
		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2, cont = 0;
		int reps = Integer.parseInt(arg[0]);
		for (int n = 100; n <= 10000; n*=2) {
			t1 = System.currentTimeMillis();

			for(int r=0 ; r<reps ; r++) {
				cont = rec4(n);
			}

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
		} // for
	} // main
} // class