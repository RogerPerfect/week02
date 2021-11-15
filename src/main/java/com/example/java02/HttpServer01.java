package com.example.java02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while(true){
            try{
                Socket socket = serverSocket.accept();
                service(socket);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private static void service(Socket socket){
        try{
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:test/html;charset=utf-8");
            String body = "java02";
            printWriter.println("Content-Length:"+body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
