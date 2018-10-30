package application;

import javafx.concurrent.Task;

public class FibonacciTask extends Task<Long> {

	private final long n;
	
	public FibonacciTask(long n) {
		this.n = n;
	}
	
	@Override
	protected Long call() throws Exception {
		long a = 0, b = 0, c = 1;
		for (long i = 0; i < n; i++) {
			a = b;
			b = c;
			c = a + b;
			for (long j=0;j<100000000;j++);
		}
		return c;
	}

}
