
class MyRunnable implements Runnable{
	
	public void run() {
		for(int i=0; i<6; i++) {
			System.out.println("thread 2");
		}
	}
}


public class ImplementingRunnable {

	public static void main(String[] args) {
		MyRunnable m = new MyRunnable();
		Thread t = new Thread(m);
		t.start();
		
		for(int j=0; j<6; j++) {
			System.out.println("Main thread");
		}

	}

}
