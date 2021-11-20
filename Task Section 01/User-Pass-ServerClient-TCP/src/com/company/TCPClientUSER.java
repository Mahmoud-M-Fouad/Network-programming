package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientUSER {
    private static InetAddress host;
    private static final int port = 1234;
    private static String Username ="";
    private static String Password ="";


    public static void main(String[] args) {
        try {
            host =InetAddress.getLocalHost();

        }
        catch (IOException ex)
        {
            System.out.println("Host ID Not Found");
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer() {
        Socket link = null;
        try {
            link = new Socket(host , port);
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(),true);
            Scanner Userinput = new Scanner(System.in);
            String Msg ="" ,Respn ;
            do {


                System.out.println("Enter Username");
                Username = Userinput.nextLine();
                System.out.println("Enter Password");
                Password = Userinput.nextLine();

                if(Username.equals("123")&&Password.equals("123"))
                {
                    System.out.println("Enter Message : ");
                    Msg = Userinput.nextLine();
                    output.println(Msg);
                    Respn = input.nextLine();
                    System.out.println("Server> "+ Respn);
                }
                else {

                }

            }
            while (!Msg.equals("close"));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally {
            try {
                System.out.println("Closing Connection.....");
                link.close();
            }
            catch (IOException ex)
            {
                System.out.println("Unable TO DisConnect");
                System.exit(1);
            }
        }
    }

}
