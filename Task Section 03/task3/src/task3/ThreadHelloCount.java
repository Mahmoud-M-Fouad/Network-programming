/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task3;

import static java.lang.Thread.sleep;
import static task3.ThreadHelloCount.Finalmessage;

/**
 *
 * @author Emad
 */
public class ThreadHelloCount {
    static String message ="";
      static  int number;
       static int t;
       static String Finalmessage ="";
       static int FinalNumber ;
   
    public ThreadHelloCount() {
        
        HelloThread hello = new HelloThread();
        CountThread count = new CountThread();
        Thread t1 = new Thread(hello);
        Thread t2 = new Thread(count);
        t1.start();
        t2.start();
    }
    public String returnMessage()
    {
        return message;
    }
     public int returnInt()
    {
        return number;
    }
      public int returnTimer()
    {
        return t;
    }
 
     
     }

class HelloThread implements java.lang.Runnable{
   // static String message ="";
       // int number;
       /* int t;
    
    public HelloThread(String msg,int num,int timer) {
      
         this.message= message;
        this.number = num;
        this.t = timer;
    }
    */
 @Override
 public void run() {
    int pause;
    for (int i = 0; i < ThreadHelloCount.number; i++) {
    try{
         System.out.println(ThreadHelloCount.message);
         
           runnableForm.txtArea.append(ThreadHelloCount.message); 
           runnableForm.txtArea.append("\n");
         pause = (int)(Math.random()*ThreadHelloCount.t);
         sleep(pause);
         
     }catch (InterruptedException ex){
        ex.getMessage();
    }
    }
 }
 
}
class CountThread implements java.lang.Runnable{
    /*int number;
    int t;
    
    public CountThread(int num,int timer) {
        this.number=num;
        this.t=timer;
    }
*/
    
 @Override
    public void run() {
    int pause;
    for (int i = 0; i < ThreadHelloCount.number; i++) {
    try{
        System.out.println(i);
        runnableForm.txtArea.append(i+""); 
        runnableForm.txtArea.append("\n");
        
        pause = (int)(Math.random()*ThreadHelloCount.t);
        sleep(pause);
        }
    catch (InterruptedException ex){
    ex.getMessage();
    }
    }
    }
}
