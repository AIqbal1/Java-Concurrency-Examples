package com.java.executor;

public class NewStringTask implements MyCallable {

	private boolean flag = true;
	
	@Override
	public NewStringTask call() throws Exception {
		System.out.println("About to wait...");
		this.wait();
		System.out.println("Starting again..");
		return this;
	}

	@Override
	public void setBooleanFlag(boolean flag) {		
		this.flag = flag;
	}

}
