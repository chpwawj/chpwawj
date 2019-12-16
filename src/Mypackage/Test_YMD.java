package Mypackage;
import java.util.*;
public class Test_YMD
{
    private int year,mon,day;
    public static void main(String[] arg3)
    {
    }
    public Test_YMD(int y, int m, int d)
    {
        year = y;
        mon = (((m >= 1)&(m <= 12))? m: 1);
        day = (((d >= 1) & (d <= 31))? d : 1);
    }
    public Test_YMD()
    {
        this(0, 0, 0);
    }
    public static int thisyear()
    {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    public int year()
    {
        return year;
    }
    public String toString()
    {
        return year+"-"+mon+"-"+day;
    }
}

