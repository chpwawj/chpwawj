public class Sushu
{
    public static boolean sushu(int m)
    {
        for(int i=2;i<m;i++)
        {
            if (m % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args)
    {
        System.out.println("100-200间的素数都有：");
        for(int i=100;i<=200;i++)
        {
            if(sushu(i))
                System.out.print(i + " ");;
        }
    }
}
