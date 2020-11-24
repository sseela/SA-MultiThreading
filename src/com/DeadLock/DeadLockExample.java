package com.DeadLock;

public class DeadLockExample {
	public static void main(String[] args) {
		First f = new First();
		Second s = new Second();
		Thread1 t1 = new Thread1(f, s);
		t1.start();
		f.foo(s);

	}

}	

class Thread1 extends Thread {
	First f;
	Second s;
	public Thread1(First f, Second s) {
		this.f = f;
		this.s = s;
	}
	@Override
	public void run() {
		s.bar(f);
	}
}

class First {
	public synchronized void foo(Second second) {
		System.out.println("Thread1 started executing bar method");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread1 trying to call Second class m2 method");
		second.m2();
	}
	
	public synchronized void m1() {
		System.out.println("inside m1 method");
	}
}

class Second {
	public synchronized void bar(First first) {
		System.out.println("Thread2 started executing foo method");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread2 trying to call First class m1 method");
		first.m1();
	}
	
	public synchronized void m2() {
		System.out.println("inside m2 method");
	}
}
