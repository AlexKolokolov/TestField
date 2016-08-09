package org.kolokolov.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class NetClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 7777);
			OutputStream outputStream = socket.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(outputStream);
			System.out.print("Enter your message: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String message = reader.readLine();
			writer.write(message);
			writer.flush();
			outputStream.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
