package org.kolokolov.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import org.kolokolov.sockets.service.SocketService;

public class NetClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 7777);
			System.out.print("Enter your message: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			SocketService socketService = new SocketService(socket);
			socketService.sendMessage(reader.readLine());
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
