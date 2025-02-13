package algstudent.s12;

public class Loop1 {

	/**
	 * 	Complexity O(n^2) i think
	 */
	public static long loop1(long n) {
		long cont = 0;
		long n1 = 1;
		while (n1 <= n * n) {
			for (long i = 1; i <= 2 * n; i += 3)
				cont++;
			n1 = 3 * n1;
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
				c = loop1(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main
	
} 