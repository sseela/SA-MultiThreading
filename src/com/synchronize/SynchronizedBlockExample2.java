package com.synchronize;

public class SynchronizedBlockExample2 {

		public static void main(String[] args) {
			Table t = new Table();			//one object created
			Thread1 t1 = new Thread1(t);	
			Thread2 t2 = new Thread2(t);	//Two threads working on same object resource
			t1.start();
			t2.start();
			
		}
}

class Table {
	public void printTable(int i) {
		
		synchronized(this) {
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

class Thread1 extends Thread {
	Table t1;
	Thread1(Table t) {
		this.t1 = t;
	}
	@Override
	public void run() {
		t1.printTable(2);
	}
}

class Thread2 extends Thread {
	Table t2;
	Thread2(Table t) {
		this.t2 = t;
	}
	@Override
	public void run() {
		t2.printTable(9);
	}
}