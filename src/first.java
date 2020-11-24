

class MyThread extends Thread{
	
	public void run() {
		for(int i=0;i<6;i++) {
			System.out.println("thread 2");
		}
	}
}


public class first {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		
		for(int j=0;j<6;j++) {
			System.out.println("Main thread");
		}

	}

}
