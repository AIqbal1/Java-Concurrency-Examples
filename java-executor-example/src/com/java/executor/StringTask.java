package com.java.executor;

import java.util.concurrent.Callable;

public class StringTask implements Callable<String> {
	   public String call(){
	      //Long operations
		   System.out.println("==> Im running ");
	      return "Run";
	   }
}

