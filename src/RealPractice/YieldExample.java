package RealPractice;

public class YieldExample {
	public static void main(String[] args) {
		MyyThread t1 = new MyyThread();
		MyyThread t2 = new MyyThread();
		MyyThread t3 = new MyyThread();
		t1.start();
		Thread.yield();
		t2.start();
		t3.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class MyyThread extends Thread {
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
}