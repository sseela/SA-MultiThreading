public class DeadLock {
	public static void main(String[] args) {
		FirstClass first = new FirstClass();
		SecondClass second = new SecondClass();
		
		FirstThread t1 = new FirstThread(first, second);
		SecondThread t2 = new SecondThread(first, second);
		t1.start();
		t2.start();
	}
}

class FirstThread extends Thread {
	FirstClass first;
	SecondClass second;
	FirstThread(FirstClass first, SecondClass second) {
		this.first = first;
		this.second = second;
	}
	public void run() {
		first.testing(second);
	}
}

class SecondThread extends Thread {
	FirstClass first;
	SecondClass second;
	SecondThread(FirstClass first, SecondClass second) {
		this.first = first;
		this.second = second;
	}
	public void run() {
		second.dev(first);
	}
}

class FirstClass {
	
	public synchronized void testing(SecondClass sec){
		System.out.println("Thread1 acquired lock");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("trying to access second class method");
		sec.sub();
	}
	
	public synchronized void abs() {
		System.out.println("inside abs");
	}
}

class SecondClass {
	
	public synchronized void dev(FirstClass first) {
		System.out.println("Thread2 acquired lock");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("trying to access first class method");
		first.abs();
	}
	
	public synchronized void sub() {
		System.out.println("inside sub");
	}
}
