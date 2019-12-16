package Mypackage2;
import java.lang.Thread;
public class Thread2 extends Thread
{
    public void run()
    {
        int n = 0;
        for(int j = 1;j < 101;j++)
        {
            if(j % 2 == 1)
            {
                System.out.print(j + " ");
                n+= 1;
            }
        }
        System.out.println("奇数"+n+"个");
    }
}

