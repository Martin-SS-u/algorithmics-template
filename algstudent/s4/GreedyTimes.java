package algstudent.s4;

public class GreedyTimes {
	
	
	public static void main(String[] args) {
		long t1,t2 = 0;
		
		for(int n=8 ; n<=65536 ; n*=2) {
			
			t1= System.currentTimeMillis();
			
			//for(int rep = 0 ; rep<5 ; rep++) {
				Greedy.greedy(n);
			//}			
			
			t2 = System.currentTimeMillis();
			
			System.out.println(n + "\t" + (t2-t1));
		}
	}
	
	

}
