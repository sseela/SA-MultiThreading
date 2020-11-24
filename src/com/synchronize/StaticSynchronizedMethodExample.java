package com.synchronize;

public class StaticSynchronizedMethodExample {

	public static void main(String[] args) {
				
		Thread3 t1 = new Thread3();	
		Thread4 t2 = new Thread4();	
		t1.start();
		t2.start();
		
	}
}

class Tablee {
	public static synchronized void printTable(int i) {
		
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

class Thread3 extends Thread {
	
	@Override
	public void run() {
		Tablee.printTable(2);
	}
}

class Thread4 extends Thread {
	
	@Override
	public void run() {
		Tablee.printTable(9);
	}
}