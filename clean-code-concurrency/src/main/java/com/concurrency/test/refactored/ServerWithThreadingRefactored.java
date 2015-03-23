package com.concurrency.test.refactored;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerWithThreadingRefactored implements Runnable {
	ServerSocket serverSocket;
	volatile boolean keepProcessing = true;
	private ClientScheduler clientScheduler;
	private ConnectionManager connectionManager;

	public ServerWithThreadingRefactored(int port, int millisecondsTimeout)throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(millisecondsTimeout);
		connectionManager = new ConnectionManager(serverSocket);
		clientScheduler = new ExecutorClientScheduler(100);
	}

	public void run() {
		System.out.printf("Server Starting\n");
		while (keepProcessing) {
			try {
				ClientConnection clientConnection = connectionManager.awaitClient();
				ClientRequestProcessor requestProcessor = new ClientRequestProcessor(clientConnection);
				clientScheduler.schedule(requestProcessor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		connectionManager.shutdown();
	}

	public void stopProcessing() {
		keepProcessing = false;
	}

}