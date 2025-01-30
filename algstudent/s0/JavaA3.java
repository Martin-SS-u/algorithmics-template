package session0.main;

import java.util.ArrayList;
import java.util.List;

public class JavaA3 {
	public void a3() {
		int n=10000;
		for(int c=0; c<7; c++) {
			long t1 = System.currentTimeMillis();
			List primes = listadoPrimos(n);
			long t2 = System.currentTimeMillis();
			System.out.println("n = "+ n+ " *** "+ "time = "+ (int)(t2-t1)+ " milliseconds)");
			n = n*2;
		}
	}

	private List listadoPrimos(int n) {
		List primes = new ArrayList();
		for (int i=2; i<n+1; i++) {
			if (primoA3(i)) {
				primes.add(i);
			}
		}
		return primes;
	}

	private boolean primoA3(int m) {
		for(int i=2; i<(m/2)+1; i++) {
			if (m%i==0) {
				return false;
			}
		}
		return true;
	}

}
