 class pppp
{
    int year, month, day;

    void set(int y, int m, int d)
    {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public String toString()
    {
        return this.year+"年"+this.month+"yue"+this.day+"ri";
    }
}
public class ppp {
    public static void main(String args[]) {
        pppp d1;
        d1 = new pppp();
        System.out.println("d1:" + d1.toString());
        d1.set(2012, 1, 1);
        pppp d2 = d1;
        System.out.println("d1:" + d1.toString() + ", d2:" + d2.toString());
        d2.month = 10;
        System.out.println("d1:" + d1 + ", d2:" + d2);
        d2 = new pppp();
    }
}