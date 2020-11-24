class Account {
	private int bal = 10000;
	public synchronized void WD(int amt) throws InterruptedException {
		if(this.bal < amt) {
			this.wait();
			System.out.println("amount deposited...");
			this.bal = this.bal - amt;
			System.out.println("amount withdrawn");
		}
	}
	
	public synchronized void DP(int amt) throws InterruptedException {
		if(amt>0) {
			this.bal = this.bal + amt;
			System.out.println("updated balance");
			this.notify();
		}
	}
}

class ThreadOne extends Thread {
	private Account ac;
	ThreadOne(Account ac){
		this.ac = ac;
	}
	public void run() {
		try {
			this.ac.WD(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ThreadTwo extends Thread {
	private Account ac;
	ThreadTwo(Account ac){
		this.ac = ac;
	}
	public void run() {
		try {
			this.ac.DP(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class WaitNotify {
	public static void main(String[] args) {
		Account ac = new Account();
		ThreadOne t1 = new ThreadOne(ac);
		ThreadTwo t2 = new ThreadTwo(ac);
		t1.start();
		t2.start();
		
	}
}

