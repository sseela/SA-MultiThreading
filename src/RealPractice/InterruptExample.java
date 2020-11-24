package RealPractice;

public class InterruptExample {
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();
		t1.interrupt();
	}
}

class T1 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				System.out.println("I am lazy thread");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("I got interrupted");
			}
		}
	}
}