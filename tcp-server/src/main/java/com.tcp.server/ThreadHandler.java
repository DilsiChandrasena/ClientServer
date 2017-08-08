package com.tcp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadHandler extends Thread {
    private Socket client;


    public ThreadHandler(Socket client) {
        this.client = client;
    }


    public synchronized void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(this.client.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(this.client.getOutputStream());

            int number = dataInputStream.readInt();
            dataOutputStream.writeInt(number);
            System.out.println("Client is processed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}