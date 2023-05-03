package com.example.practice4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        System.out.println("Client Started.......");
        Socket chatSocket = new Socket("127.0.0.1",12345);
        System.out.println("Client connected......");

        ObjectOutputStream oos = new ObjectOutputStream(chatSocket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(chatSocket.getInputStream());
        

        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        //set to server.........
        oos.writeObject(message);
        //receive from server............
        Object fromServer = ois.readObject();
        System.out.println("From Server : "+ (String)fromServer);
    }
}
