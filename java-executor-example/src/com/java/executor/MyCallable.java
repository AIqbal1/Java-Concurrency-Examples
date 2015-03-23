package com.java.executor;

import java.util.concurrent.Callable;

public interface MyCallable extends Callable<NewStringTask> {	
	abstract void setBooleanFlag(boolean flag);	
}
