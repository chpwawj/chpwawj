import java.util.Scanner;
import java.util.Arrays;
interface Average
{
    public double avg1(double[] s);
    public double avg2(double[] s);
}
public class Studentss implements Average{
    String  Name;
    int Num;
    double Score;
    public Studentss(){
        Name = "";
        Num = 0;
        Score = 0;
    }
    public double avg1(double[] s){
        double avg = 0;
        for(int i = 0;i<s.length;i++){
            avg += s[i];
        }
        avg = avg/s.length;
        System.out.println("第一种方法算的学生平均成绩为："+avg);
        return avg;
    }
    public double avg2(double[] s){
        double avg = 0;
        for(int i=1;i<s.length-1;i++)
        {
            avg += s[i];
        }
        avg = avg/(s.length - 2);
        System.out.println("第二种方法算的学生的平均成绩为："+avg);
        return avg;
    }
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("请输入共有多少名学生：");
        int n = a.nextInt();
        double[] s = new double[n];
        Studentss[] stu = new Studentss[n];
        for(int i=0;i<n;i++)//给数组对象a分配内存空间
        {
            stu[i]=new Studentss();
        }
        for(int i = 0;i<n;i++){
            System.out.println("请输入第"+(i+1)+"名学生的姓名：");
            stu[i].Name = a.next();
            System.out.println("请输入第"+(i+1)+"名学生的学号：");
            stu[i].Num = a.nextInt();
            System.out.println("请输入第"+(i+1)+"名学生的成绩：");
            stu[i].Score = a.nextDouble();}
        for(int i = 0;i<n;i++){
            s[i] = stu[i].Score;
        }
        Arrays.sort(s);
        stu[0].avg1(s);
        stu[0].avg2(s);
    }
}