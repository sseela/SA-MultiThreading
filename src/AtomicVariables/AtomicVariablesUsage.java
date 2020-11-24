package AtomicVariables;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesUsage {
	AtomicInteger counter;
	int m = 0;
	public void Increment() {
		for(int i=0; i<10; i++) {
			m = counter.incrementAndGet();
		}
		System.out.println(m);
	}
	
	public static void main(String[] args) {
		whyAtomicVariables w = new whyAtomicVariables();
		Thread3 t1 = new Thread3(w);
		Thread4 t2 = new Thread4(w);
		t1.start();
		t2.start();
	}
}
class Thread3 extends Thread {
	whyAtomicVariables w;
	Thread3(whyAtomicVariables w) {
		this.w = w;
	}
	@Override
	public void run() {
		w.Increment();
	}
}

class Thread4 extends Thread {
	whyAtomicVariables w;
	Thread4(whyAtomicVariables w) {
		this.w = w;
	}
	@Override
	public void run() {
		w.Increment();
	}
}

