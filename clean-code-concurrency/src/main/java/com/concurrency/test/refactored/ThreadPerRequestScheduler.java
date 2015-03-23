package com.concurrency.test.refactored;

public class ThreadPerRequestScheduler implements ClientScheduler {
	
	public void schedule(final ClientRequestProcessor requestProcessor) {
		
		Runnable runnable = new Runnable() {
			public void run() {
				requestProcessor.process();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
