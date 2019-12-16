import java.util.Arrays;
import java.util.Scanner;
public class Array
{
    public static void main(String[] args)
    {
        int low=0,high=10,mid=0,flag=0,b;
        int a[] = {12, 39, 9, -23, 45, 6, 90, 123, 19, 45, 34};
        Arrays.sort(a);
        System.out.println("排序后数组为");
        for(int j=0;j<11;j++)
        {
            System.out.print(a[j]+" ");
        }
        System.out.println();
        System.out.println("请输入要查询的数");
        Scanner n=new Scanner(System.in);
        b=n.nextInt();//运算符不可以用在Scanner接受的数上，将接受的数赋值给另一个数
        while(low!=high)
        {
            mid=(low+high)/2;
            if(b>a[mid])
            {  if((low+1)==high)
                  break;
                low = mid;
                if(b==a[high])
               {
                System.out.println("找到此数，它是数组中第" + (high+1) + "个数");
                flag=1;
                break;
                }
            }
            else if(b<a[mid])
            {
                if((low+1)==high)
                    break;
                high=mid;
                if(b==a[low])
                {
                    System.out.println("找到此数，它是数组中第" + (low + 1) + "个数");
                    flag=1;
                    break;
                }

            }
            else if(b==a[mid])
            {
                System.out.println("找到此数，它是数组中第" + (mid+1) + "个数");
                flag=1;
                break;
            }
        }
        if(flag==0)
          System.out.println("找不到此数");
    }

}
