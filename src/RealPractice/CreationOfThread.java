package RealPractice;

public class CreationOfThread {

	public static void main(String[] args) {
		Thread.currentThread().setPriority(10);
		Thread thread = new Thread(new Thread1());
		thread.setPriority(1);
		thread.start();
		
		for(int j=0; j<=3; j++) {
			System.out.println(Thread.currentThread().getPriority());
			System.out.println(Thread.currentThread().getName()+" printing: "+ j);
			System.out.println();
		}
	}
}

class Thread1 implements Runnable {
	@Override
	public void run() {
		System.out.println("Child thread priority inheriting and overridden by 1: "+Thread.currentThread().getPriority());
		for(int i=0; i<=3; i++) {
			System.out.println(Thread.currentThread().getName()+" printing: "+ i);
			System.out.println();
		}
		
	}
}