package RealPractice;

public class YieldPrac {
	public static void main(String[] args) {
		
		Thread t = new Thread(new MyThread());
		t.start();
		//two threads have started
		for(int i=0; i<=10; i++) {
			Thread.yield();
			System.out.println("Main thread");
		}
		
	}
}

//cannot rely on Thread.yield method completely because it just gives a hint that current thread is willing to yield, but scheduler can ignore it.

class MyThread implements Runnable {
	
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println("Child Thread");
		}
		
	}
}
