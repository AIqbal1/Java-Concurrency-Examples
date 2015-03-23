package com.concurrency.test.refactored;

import java.net.Socket;

public class ClientConnection {

	private Socket socket;

	public ClientConnection(Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}
	
}
