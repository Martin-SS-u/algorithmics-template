package algstudent.s2;

/* This class measures times for the Bubble method
for the 3 assumptions: (already ordered, reverse ordered and random ordered) */
public class BubbleTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		String opcion = arg[0];
		
		System.out.println("n" + "\t" + "time(ms)");

		for (int n = 10000; n <= 1000000000; n *= 2) {
			v = new int[n];

			if (opcion.compareTo("ordered") == 0)
				Vector.sorted(v);
			else if (opcion.compareTo("reverse") == 0)
				Vector.reverseSorted(v);
			else
				Vector.randomSorted(v);

			t1 = System.currentTimeMillis();

			Bubble.bubble(v);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1));
		}
	}
}
