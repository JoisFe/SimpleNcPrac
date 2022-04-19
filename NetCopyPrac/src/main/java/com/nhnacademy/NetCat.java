package com.nhnacademy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetCat {
    public static void main(String[] args) throws IOException {
        if (!args[0].equals("snc")) {
            throw new InvalidCommandException("잘못된 명령어를 입력하였습니다.");
        }

        if (args[1].equals("-l")) {

            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(Integer.parseInt(args[2]));
                System.out.println("서버 준비됨");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Socket socket = serverSocket.accept();

                Sender sender = new Sender(socket);
                Receiver receiver = new Receiver(socket);

                sender.start();
                receiver.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Socket socket = new Socket(args[1], Integer.parseInt(args[2]));

                System.out.println("서버에 연결됨");

                Sender sender = new Sender(socket);
                Receiver receiver = new Receiver(socket);

                sender.start();
                receiver.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
