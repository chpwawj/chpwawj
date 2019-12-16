import java.util.*;
public class CE {
    public static void panduan(String str) throws MyException
    {
        if (Objects.equals(str, "XYZ"))
        {
            throw new MyException("This is a XYZ");
        }
    }
    public static void main(String[] args)
    {
        System.out.println("请输入字符串：");
        Scanner in = new Scanner(System.in);
        try
        {
            String s = in.nextLine();
            panduan(s);
        } catch (MyException e)
        {
            System.out.println(e.getMessage());
        }
    }
   static class MyException extends Exception
   {
   public MyException(String s)
    {
        super(s);
    }
    }
}
