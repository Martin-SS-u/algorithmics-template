package algstudent.s3;

/* Class that models T(n)=T(n-1)+O(n)
 * Params: a=1 ; b=1 ; k= 1
 * The time complexity is quadratic O(n^2) 
 * and the waste of stack is O(n)
 * In this case => the stack overflows 
 */
public class Subtraction2 {
	public static long rec2(int n) {
		long cont = 0;
		if (n <= 0)
			cont++;
		else {
			for (int i = 0; i < n; i++)
				cont++; // O(n)
			rec2(n - 1);
			for (int i = 0; i < n; i++)
				cont++; // O(n)
		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2, cont = 0;
		int reps = Integer.parseInt(arg[0]);
		for (int n = 1; n <= 100000; n *= 2) {
			t1 = System.currentTimeMillis();

			for(int r=0 ; r<reps ; r++) {
				cont = rec2(n);
			}

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
		} // for
	} // main
} // class