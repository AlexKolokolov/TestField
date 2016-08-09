package org.kolokolov.sockets;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer {
	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(7777);
			System.out.println("Server started!");
			while (true) {
				Socket clientSocket = socket.accept();
				System.out.println("Client connected from port " + clientSocket.getRemoteSocketAddress());
				InputStream inputStream = clientSocket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				String str = reader.readLine();
			    System.out.println("Client sais: " + str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
