package com.company;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Test  {
    public static void main(String[] args) throws IOException {
        Socket tempSocket = new Socket();	//	Initialize
        boolean isOpened;
        InetAddress host;
        host = InetAddress.getLocalHost();
        for (int port = 0; port < 65536; port++) {
            isOpened = true;

            try {


                tempSocket = new Socket(host, port);
            }
            catch (IOException e) {
                isOpened = false;
            }
            finally {
                tempSocket.close();
            }
            if (isOpened) {
                String message = String.format("port %d is open", port);
                System.out.println(message);
            }
        }
    }
}
