package RealPractice;

public class joinPrac {
	public static void main(String[] args) throws InterruptedException {
		
		Custom myThread = new Custom();
		myThread.start();
		/*myThread.join(3000);*/
		Thread.currentThread().join(1000);
		for(int i=0; i<=50; i++) {
			System.out.println("Parent");
		}
	}
}

class Custom extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<=50; i++) {
			System.out.println("Child");
		}
	}
}
