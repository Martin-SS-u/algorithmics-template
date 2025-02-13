package algstudent.s12;

public class Loop3 {
	
	/**
	 * 	Complexity O(n^2logn)
	 */
	public static long loop3(long n) {
		long cont = 0;
		long i = 1;
		while (i <= 2 * n) {
			for (long j = i; j >= 0; j -= 2)
				for (long k = 1; k <= n; k *= 2)
					cont++;
			i++;
		}

		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2;
		int nTimes = Integer.parseInt(arg[0]);

		System.out.println("n\ttime\trepetions\tcounter");

		for (long n = 100; n <= 819200; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop3(n);

			t2 = System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);

		} // for
	} // main
	
} 