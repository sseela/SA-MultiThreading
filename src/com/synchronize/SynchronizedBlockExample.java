package com.synchronize;

public class SynchronizedBlockExample extends Thread{
	
	public static void main(String[] args) throws InterruptedException {
		ThreadB b = new ThreadB();
		b.start();
		synchronized (b) {
			System.out.println("main thread trying to call wait");
			b.wait(1000);
			System.out.println("main thread got notification");
			System.out.println(b.total);
		}
	}
}

class ThreadB extends SynchronizedBlockExample {
	int total=0;
	@Override
	public void run() {
		synchronized(this) {
			System.out.println("Child Thread Starts notification");
			for(int i=1; i<=100; i++) {
				total = total + i;
			}
			System.out.println("child thread trying to give notification");
			this.notify();
		}
	}
}
