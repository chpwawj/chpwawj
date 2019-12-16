class TicketSeller {
    int ten=0,five=1;
    public synchronized void sellTicket(int ticket,int money) {
        String s=Thread.currentThread().getName();
        if(ticket==2&&money==20) {
            System.out.println("当前"+five+"张5元"+","+ten+"张10元");
            while(ten<1) {
                try {
                    System.out.println(s+"实付20元");
                    System.out.println("购买两张票，金额10元");
                    System.out.println("应找10元");
                    System.out.println("请靠边等候");
                    System.out.println("---------------------------");
                    wait();
                }
                catch(InterruptedException e)
                {}
            }
            ten--;
            System.out.println(s+"实付20元");
            System.out.println("购买两张票，金额10元");
            System.out.println("应找10元");
            System.out.println("拿好，慢走");
            System.out.println("---------------------------");
        }
        else if(ticket==1&&money==20)
        {
            System.out.println("当前"+five+"张5元"+","+ten+"张10元");
            while(ten<1||five<1)
            {
                try
                {
                    System.out.println(s+"实付20元");
                    System.out.println("购买一张票，金额5元");
                    System.out.println("应找15元");
                    System.out.println("请靠边等候");
                    System.out.println("---------------------------");
                    wait();
                }
                catch(InterruptedException e)
                {}
            }
            ten--;
            five--;
            System.out.println(s+"实付20元");
            System.out.println("购买一张票，金额5元");
            System.out.println("应找15元");
            System.out.println("拿好，慢走");
            System.out.println("---------------------------");
        }
        else if(ticket==1&&money==10) {
            System.out.println("当前"+five+"张5元"+","+ten+"张10元");
            while(five<1) {
                try {
                    System.out.println(s+"实付10元");
                    System.out.println("购买一张票，金额5元");
                    System.out.println("应找5元");
                    System.out.println("请靠边等候");
                    System.out.println("---------------------------");
                    wait();
                }
                catch(InterruptedException e) {}
            }
            five--;
            ten++;
            System.out.println(s+"实付10元");
            System.out.println("购买一张票，金额5元");
            System.out.println("应找5元");
            System.out.println("拿好，慢走");
            System.out.println("---------------------------");

        }
        else if(ticket==2&&money==10) {
            System.out.println("当前"+five+"张5元"+","+ten+"张10元");
            ten++;
            System.out.println(s+"实付10元");
            System.out.println("购买两张票，金额10元");
            System.out.println("应找0元");
            System.out.println("拿好，慢走");
            System.out.println("---------------------------");
        }
        else if(ticket==1&&money==5) {
            System.out.println("当前"+five+"张5元"+","+ten+"张10元");
            five++;
            System.out.println(s+"实付5元");
            System.out.println("购买一张票，金额5元");
            System.out.println("应找0元");
            System.out.println("拿好，慢走");
            System.out.println("---------------------------");
        }
        notify();
    }
}
public class Ticket implements Runnable {
    String s1,s2,s3,s4,s5;
    Thread zhao,qian,sun,li,zhou;
    TicketSeller seller=new TicketSeller();
    public Ticket(String s1,String s2,String s3,String s4,String s5) {
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        this.s4=s4;
        this.s5=s5;
        zhao=new Thread(this);
        qian=new Thread(this);
        sun=new Thread(this);
        li=new Thread(this);
        zhou=new Thread(this);
        zhao.setName(s1);
        qian.setName(s2);
        sun.setName(s3);
        li.setName(s4);
        zhou.setName(s5);
    }
    public void run() {
        if(Thread.currentThread().getName().equals(s1))
            seller.sellTicket(2,20);
        else if(Thread.currentThread().getName().equals(s2))
            seller.sellTicket(1,20);
        else if(Thread.currentThread().getName().equals(s3))
            seller.sellTicket(1,10);
        else if(Thread.currentThread().getName().equals(s4))
            seller.sellTicket(2,10);
        else if(Thread.currentThread().getName().equals(s5))
            seller.sellTicket(1,5);
    }
    public static void main(String args[]) {
        String s1="赵",s2="钱",s3="孙",s4="李",s5="周";
        Ticket customer=new Ticket(s1,s2,s3,s4,s5);
        customer.zhao.start();
        try{Thread.sleep(1000);}
        catch(InterruptedException e){}
        customer.qian.start();
        try{Thread.sleep(1000);}
        catch(InterruptedException e){}
        customer.sun.start();
        try{Thread.sleep(1000);}
        catch(InterruptedException e){}
        customer.li.start();
        try{Thread.sleep(1000);}
        catch(InterruptedException e){}
        customer.zhou.start();
        try{Thread.sleep(1000);}
        catch(InterruptedException e){}

    }
}