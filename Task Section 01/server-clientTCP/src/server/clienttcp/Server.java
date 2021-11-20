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
import javax.swing.JOptionPane;

/**
 *
 * @author Eng Ahmed
 */
public class Server{
public static ServerSocket serverSocket;
    public static final int port =0123;
    private static String Msg = "" ;
    Socket link;
    Scanner input ;
    PrintWriter output ;
    private static int num_msg;
    Server()
    {

        link=null;
        input =null;
        output =null;
        num_msg=0;
    }
    protected String open_server()
    {
        System.out.println("opening the server : ");
        String s="";
        try {
            serverSocket = new ServerSocket(port);
            s="port opened successful ";
            return s;

        } catch (IOException ex) {
            s+="faild to connect to the port " + port+"\n";
            s+="please try another port \n";
            System.exit(1);
        }
        return s;
    }
    
    
    public void mail_valid()
    {
      
      try{
            link=serverSocket.accept();
        input =new Scanner(link.getInputStream());
        output =new PrintWriter(link.getOutputStream(),true);
        Msg = input.nextLine();
      }
      catch(IOException ex)
      {
          ex.printStackTrace();
      }
     
    }
    
    String receive_msg()
    {
        num_msg++;
        String s="";
        s+="message "+num_msg+"is recevid "+Msg;
        
        output.println("message received successful ");
        return s;
    }
    
    
    String close_connection() 
    {
        
        String s="server is closed";
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
