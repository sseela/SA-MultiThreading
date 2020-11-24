
public class RaceCondition {

	public static void main(String[] args) {
		DisplayCounter dc = new DisplayCounter();
		Thread1 t1 = new Thread1(dc);
		Thread1 t2 = new Thread1(dc);
		Thread1 t3 = new Thread1(dc);
		Thread1 t4 = new Thread1(dc);
		Thread1 t5 = new Thread1(dc);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}


class Thread1 extends Thread {
	private DisplayCounter dc;
	Thread1(DisplayCounter dc) {
		this.dc = dc;
	}
	public void run(){
		dc.count();
	}
}

class DisplayCounter {
	int x=0;
	public synchronized void count() {
		for(int i=0; i<5; i++) {
			x = x+1;
		}
		System.out.println(x);
	}
	/*int balance=0;
	public synchronized void count(int amt) {
		balance = balance+amt;
		System.out.println(balance);
	}*/
}