/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreading;

public  class Task extends Thread
{
    int i=1;
    @Override
    public synchronized void run() 
    {
        while(i<=500) 
        {
            System.out.println(i);
            i++;
                
        }
            
        try 
        {
            Thread.sleep(600);
                
        }
            
        catch(InterruptedException e) 
        {
        }
            
    }

    public static void main(String[] args) throws InterruptedException 
    {
        Task task1=new Task();
        Thread t1=new Thread(task1);
	t1.start();
        
        Task2 task2=new Task2();
	Thread t2=new Thread(task2);
        t1.join();
	t2.start();
	t2.join();

    }

}
class Task2 implements Runnable{
    int i=501;
    public synchronized void run() 
    {
        while(i<=1000) 
        {
            System.out.println(i);
            i++;
            
	}
	
        try 
        {
            Thread.sleep(500);
	
        }
        
        catch(InterruptedException e) 
        {
	}
        
    }
    
}
