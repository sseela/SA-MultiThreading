package com.InterThreadCommunication;

public class WaitNotifyExample1 {
	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1(0);
		t1.start();
		synchronized(t1) {
			System.out.println("main thread waiting");
			t1.wait();
			System.out.println("updated balance "+t1.balance);
		}
	}
}

class Thread1 extends Thread {
	int balance;
	Thread1(int bal) {
		this.balance = bal;
	}
	@Override
	public void run() {
		synchronized(this) {
			balance = balance + 1000;
			System.out.println("balance updated");
			System.out.println("so calling notify method");
			this.notify();
		}
 	}
}

