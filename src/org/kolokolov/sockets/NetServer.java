package org.kolokolov.sockets;

import java.net.ServerSocket;
import java.net.Socket;

import org.kolokolov.sockets.service.SocketService;

public class NetServer {

	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(7777);
			System.out.println("Server started!");
			while (true) {
				Socket clientSocket = socket.accept();
				System.out.println("Client connected from port " + clientSocket.getRemoteSocketAddress());
				SocketService socketService = new SocketService(clientSocket);
			    System.out.println("Client sais: " + socketService.receiveMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
