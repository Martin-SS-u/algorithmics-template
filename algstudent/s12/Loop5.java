package algstudent.s12;

public class Loop5 {

	/**
	 *	Complexity O(n^2log^2n)
	 */
	public static long loop5(long n) {
		long cont = 0;
		long n1 = 1;
		for(int i=1; i<= n; i*=2)
			for(int p=1; p<= n; p*=2)
				for(int j=1; j<= n; j++)
					for(int k=1; k<= n; k++)
						cont++;
		return cont;
		//TODO
	}

	public static void main(String arg[]) {
		long t1, t2;
		int nTimes = Integer.parseInt(arg[0]);

		System.out.println("n\ttime\trepetions\tcounter");

		for (long n = 100; n <= 819200; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop5(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main
	
} 