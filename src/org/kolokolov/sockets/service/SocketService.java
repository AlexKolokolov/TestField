package org.kolokolov.sockets.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketService {
	
	private Socket socket;
	
	public SocketService(Socket socket) {
		this.socket = socket;
	}
	
	public void sendMessage(String message) {
		try {
			OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write(message);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String receiveMessage() {
		String message = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			message = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

}
