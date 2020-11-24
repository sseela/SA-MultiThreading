package com.synchronize;

public class SynchronizedBlockStaticExample {

	public static void main(String[] args) {
		
		Thread5 t1 = new Thread5();	
		Thread6 t2 = new Thread6();	
		t1.start();
		t2.start();
		
	}
}

class Tableee {
	public static void printTable(int i) {
		synchronized (Tableee.class) {
			for(int j=1; j<=10; j++) {
				System.out.println(i+" * "+j+" = "+i*j);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Thread5 extends Thread {
	
	@Override
	public void run() {
		Tableee.printTable(2);
	}
}

class Thread6 extends Thread {
	
	@Override
	public void run() {
		Tableee.printTable(9);
	}
}
