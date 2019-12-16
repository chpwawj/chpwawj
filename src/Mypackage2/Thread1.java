package Mypackage2;
import java.lang.Thread;
public class Thread1 extends Thread
    {
        public void run()
        {
            int m = 0;
            for(int i = 1;i < 101;i++)
            {
                if(i % 2 == 0)
                {
                    System.out.print(i + " ");
                    m+= 1;
                }
            }
            System.out.println("偶数"+m+"个");
        }
    }

