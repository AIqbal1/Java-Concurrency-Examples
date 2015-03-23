package com.java.executor;

public class RunnableTask implements Runnable {

	private boolean isDone = false;
	
	@Override
	public void run() {
		System.out.println("About to wait...");
		try {
			while(!isDone()) {
				System.out.println("Watinign///");
				this.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Starting again..");		
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	
	
}
