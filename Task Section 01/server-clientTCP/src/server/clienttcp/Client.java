/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.clienttcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
 private static InetAddress host;
    private static final int port =0123;
    Socket link;
    Scanner input ;
    PrintWriter output ;
    public static String s1;
    Server s=new Server();
    Client()
    {
        host=null;
        
        link=null;
        input =null;
        output =null;
        s1="";
    }
    public void open_client()
    {
        try {
            host=InetAddress.getLocalHost();

        }
        catch (Exception ex){
            System.out.println(ex);
            System.exit(1);

        }
    }
    
    String mail_valid(){
        String response="";
        try{
        link = new Socket(host, port);
        input = new Scanner(link.getInputStream());
        output = new PrintWriter(link.getOutputStream(), true);
   
        response = input.nextLine();
        System.out.println(response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return response;
    }
    
    
    String send_msg(String msg)
    {
        output.println(msg);
        s1=s.receive_msg();
        String response = input.nextLine();
        return "<Server> : " + response;
    }
    
    String close_connection()
    {
        String s="client  is closed";
        try{
        link.close();
        }
        catch(Exception e)
        {
            s=e.toString();
        }
        return s;
    }
}
