package AtomicVariables;

public class whyAtomicVariables {
	int counter = 0;
	public void Increment() {
		for(int i=0; i<10; i++) {
			counter++;
		}
		System.out.println(counter);
	}
	
	public static void main(String[] args) {
		whyAtomicVariables w = new whyAtomicVariables();
		Thread1 t1 = new Thread1(w);
		Thread2 t2 = new Thread2(w);
		t1.start();
		t2.start();
	}
}

class Thread1 extends Thread {
	whyAtomicVariables w;
	Thread1(whyAtomicVariables w) {
		this.w = w;
	}
	@Override
	public void run() {
		w.Increment();
	}
}

class Thread2 extends Thread {
	whyAtomicVariables w;
	Thread2(whyAtomicVariables w) {
		this.w = w;
	}
	@Override
	public void run() {
		w.Increment();
	}
}
