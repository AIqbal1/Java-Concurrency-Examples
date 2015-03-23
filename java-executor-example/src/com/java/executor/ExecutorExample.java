package com.java.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorExample {
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {		
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		CompletionService<NewStringTask> pool = new ExecutorCompletionService<NewStringTask>(threadPool);	
		
		Future<NewStringTask> future = pool.submit(new NewStringTask());
		StringBuilder result = new StringBuilder();
		
		while(!future.isDone()){
			System.out.println("Wating....");
			NewStringTask task = null;			
			
			future.get();
			System.out.println(task);
		}
		
		result.append(pool.take().get());		   		  		
		threadPool.shutdown();
		System.out.println("Shutdown..");
	}
	
	

}
