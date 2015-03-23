package com.concurrency.test.refactored;

import java.io.IOException;
import java.net.Socket;

import com.concurrency.test.MessageUtils;

public class ClientRequestProcessor {

	private ClientConnection clientConnection;
		
	public ClientRequestProcessor(ClientConnection clientConnection) {
		super();
		this.clientConnection = clientConnection;
	}

	public void process() {
		Socket socket = this.clientConnection.getSocket();
		try {
			System.out.printf("Server: getting message\n");
			String message = MessageUtils.getMessage(socket);
			System.out.printf("Server: got message: %s\n", message);
			Thread.sleep(1000);
			System.out.printf("Server: sending reply: %s\n", message);
			MessageUtils.sendMessage(socket, "Processed: " + message);
			System.out.printf("Server: sent\n");
			closeIgnoringException(socket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void closeIgnoringException(Socket socket) {
		if (socket != null)
			try {
				socket.close();
			} catch (IOException ignore) {
			}
	}

}
