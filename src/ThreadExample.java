import java.lang.Thread;
public  class ThreadExample
{
    public static void main(String a[])
    {
        Rabit rabit;
        rabit =new Rabit("haha",500,8);
        Tortoise tortoise =new Tortoise("heihei",500,6);
        tortoise.start();
        rabit.start();
    }
}
    class Tortoise extends Thread
    {     int sleepTime=0, liveLength=0;
         String name;
        public Tortoise(String name,int sleepTime, int liveLength)
        {
            this.sleepTime=sleepTime;
            this.liveLength=liveLength;
            this.name=name;
        }
        public void run()
        {   while (true )
        {
            liveLength--;
            System.out.println("@_@");
            try{
                sleep( sleepTime);
            }
            catch (InterruptedException e) {}
            if (liveLength<=0 )
            {
                System.out.println(getName()+"进入死亡状态\n");
                break;
            }
        }
        }
    }
    class Rabit extends Thread
    {
        int sleepTime=0, liveLength=0;
        String name;
        public Rabit(String name,int sleepTime, int liveLength)
        {
            this.name=name;
            this.sleepTime=sleepTime;
            this.liveLength=liveLength;
        }
        public void run()
        {
            while (true )
            {
                liveLength--;
                System.out.println("*_*");
                try{
                    sleep( sleepTime);
                }
                catch (InterruptedException e) {}
                if (liveLength<=0 )
                {
                    System.out.println(getName()+"进入死亡状态\n");
                    break;
                }
            }
        }
    }


