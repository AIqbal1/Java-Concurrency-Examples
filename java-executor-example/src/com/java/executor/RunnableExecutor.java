package com.java.executor;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableExecutor {

	public static void main(String args[]) throws InterruptedException, ExecutionException {		
		ExecutorService threadPool = Executors.newFixedThreadPool(4);		
		
		RunnableTask task = new RunnableTask();
		threadPool.execute(task);
		
		while(!task.isDone()){
			System.out.println("Wating....");
			task.setDone(true);			
			System.out.println(task);
		}
				   		  		
		threadPool.shutdown();
		System.out.println("Shutdown..");
	}	
	
}
