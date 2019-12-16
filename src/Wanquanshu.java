public class Wanquanshu
{
    public static boolean wanquanshu(int n)
    {
        int sum=0,q=0;
        for(int i=1;i<n;i++)
        {
            if(n%i==0)
            {
                sum=sum+i;
            }
        }
        if(sum==n)
            return true;
        else
            return false;
    }
    public static void main(String [] args)
    {
        System.out.println("1-1000间的完全数有：");
        for(int i=1;i<=1000;i++)
        {
            if(wanquanshu(i))
                System.out.print(i+" ");
        }
    }
}
