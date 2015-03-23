package com.concurrency.test.refactored;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionManager {

	private ServerSocket serverSocket;
	
	public ConnectionManager(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public ClientConnection awaitClient() {
		try {
			return new ClientConnection(serverSocket.accept());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void shutdown() {
		closeIgnoringException(serverSocket);
	}
	
	private void closeIgnoringException(ServerSocket serverSocket) {
		if (serverSocket != null)
			try {
				serverSocket.close();
			} catch (IOException ignore) {
		}
	}

}
