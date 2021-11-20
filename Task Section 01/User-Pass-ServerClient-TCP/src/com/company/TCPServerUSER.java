package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerUSER {
    private static ServerSocket serversocket;
    private static final int port = 1234;

    public static void main(String[] args) {
        System.out.println("Openning Port ");
        try {
            serversocket = new ServerSocket(port);
            System.out.println("Port Opened Successfully");
        }
        catch (IOException ex)
        {
            System.out.println("Failed TO Connect TO Port");
            System.exit(1);
        }
        do {
            handelConnection();
        }
        while (true);
    }

    private static void handelConnection() {
        Socket link = null;
        try {
            link = serversocket.accept();
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(),true);
            int NumMsg=0 ;
            String Msg = input.nextLine();
            while (!Msg.equals("close"))
            {
                System.out.println("Message Received ");
                NumMsg++;
                output  .println(" Message " + NumMsg+" : is -->> " + Msg);
                Msg = input.nextLine();
            }
             output.println(" Message " + NumMsg+" : is -->> " + Msg);
        }
        catch (IOException es)
        {
            es.printStackTrace();
        }
        finally {
            try {
                System.out.println("Colssing Connection !");
                link.close();
            }
            catch (IOException ex)
            {
                System.out.println("Unable To DisConnection");
                System.exit(1);;
            }

        }
    }
}
