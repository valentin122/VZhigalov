package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                boolean needClose = false;
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String response = "Exit";
                    boolean hasResponse = false;
                    while (!str.isEmpty()) {
                        if (str.contains("msg=Exit")) {
                            response = "Exit";
                            hasResponse = true;
                            needClose = true;
                        } else if (str.contains("msg=Hello")) {
                            response = "Hello";
                            hasResponse = true;
                        } else if (!hasResponse) {
                            response = "What";
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(response.getBytes());
                }
                if (needClose) {
                    server.close();
                }
            }
        }
    }
}