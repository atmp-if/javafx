package atmp.javafx;

import javafx.concurrent.Task;

public class FibonacciTask extends Task<Long> {

	private final long n;

	public FibonacciTask(long n) {
		this.n = n;
		updateTitle(Long.toString(n));
		updateMessage("У черзі");
	}

	@Override
	protected Long call() throws Exception {
		updateMessage("Виконується");
		long a = 0, b = 0, c = 1;
		for (long i = 0; i < n; i++) {
			a = b;
			b = c;
			c = a + b;
			for (long j = 0; j < 100000000; j++)
				;
			updateProgress(i, n-1);
		}
		updateMessage("Завершено");
		return c;
	}

}
