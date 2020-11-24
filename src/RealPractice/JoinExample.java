package RealPractice;

public class JoinExample {
	public static void main(String[] args) {
	      
		MyClass t1 = new MyClass();
		MyClass t2 = new MyClass();
		MyClass t3 = new MyClass();
		
		t1.start();
			
		try {
			t1.join();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
			
		try {
			t2.join();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();
		
		try {
			t3.join();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
} 

class MyClass extends Thread{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" start");
		}
	}
}
