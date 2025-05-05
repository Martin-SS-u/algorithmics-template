package algstudent.s7;

public class NullPathTimesBB {

	public static void main(String[] args) {
		NullPathBB npBB= new NullPathBB();
//		npBB.newNullPathBB(5);
		
		long t1,t2;		
		System.out.println("N:\t\tTIME(ms)");
		for(int n=20; n< 50; n+=5) {
			t1 = System.currentTimeMillis();
			for(int i=0; i<100; i++) {
				//npBB.newNullPath(n);			
			}
			t2 = System.currentTimeMillis();
			
			System.out.println(n + "\t\t" + ((t2-t1)/100));
		}
		
	}
}
