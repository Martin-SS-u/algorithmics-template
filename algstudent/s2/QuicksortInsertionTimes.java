package algstudent.s2;

/* This class measures times for the Quicksort method
for the 3 assumptions: (already ordered, reverse ordered and random ordered) */
public class QuicksortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		int size = 16000000; //16 million
		int[] k = {5, 10, 20, 30, 50, 100, 200, 500, 1000};
		
		System.out.println("size" + "\t\t" + "k" + "\t" + "time(ms)");

		for (int i = 0; i < k.length; i ++) {
			v = new int[size];

			Vector.randomSorted(v);

			t1 = System.currentTimeMillis();

			QuicksortInsertion.quicksortInsertion(v, k[i]);

			t2 = System.currentTimeMillis();

			System.out.println(size + "\t" + k[i] + "\t" + (t2 - t1));
		}
	}
}
