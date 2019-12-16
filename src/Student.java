import java.util.*;
public class Student
{
     static String Name;
     static int Age;
     static double Grade;
    MyDate Date = new MyDate();
    public Student()
    {
        Name = "";
        Age = 0;
        Grade = 0;
        Date.year=0;
        Date.month = 0;
        Date.day=0;
    }
    public void get()
    {
        Scanner q = new Scanner(System.in);
        Name = q.nextLine();
        Age = q.nextInt();
        Grade = q.nextDouble();
        Date.year = q.nextInt();
        Date.month = q.nextInt();
        Date.day = q.nextInt();
        this.Date.jiucuo(Date.year,Date.month,Date.day);

    }
    public  static void main(String[] args)
    {
        Student[] a = new Student[10];
        int avgAge = 0;
        double avgGrade = 0;
        for (int i = 0; i < 10; i++)
        {
            a[i] = new Student();
        }
        for (int j = 0; j < 10; j++)
        {
            System.out.println("请输入第" + (j + 1) + "个学生信息");
            a[j].get();
            avgAge += Age;
            avgGrade += Grade;
        }
        System.out.println("学生的平均年龄为" + avgAge / 10);
        System.out.println("学生的平均成绩为" + avgGrade / 10);
    }
    public class MyDate
    {
        public int year, month, day;
        public boolean runnian(int year)
        {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            {
                System.out.println("出生的年份是闰年");
                return true;
            }
            return false;
        }
        public void jiucuo(int year,int month,int day)
        {
            if(year>2019) {
                if (month > 0 && month <= 12) {
                    if (month == 2) {
                        if (runnian(year)) {
                            if (day < 0 || day > 29)
                                System.out.println("输入的日有错误");
                            else
                                System.out.println("出生的月份是大二月");
                        } else {
                            if (day < 0 || day > 28)
                                System.out.println("输入的日有错误");
                            else
                                System.out.println("出生的月份是小二月");
                        }
                    } else if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
                        if (day < 0 || day > 31)
                            System.out.println("输入的日有错误");
                        else
                            System.out.println("出生的月份是大月");
                    } else if (month == 4 | month == 6 | month == 9 | month == 11) {
                        if (day < 0 || day > 30)
                            System.out.println("输入的日有错误");
                        else
                            System.out.println("出生的月份是小月");
                    }
                } else if (month < 0 || month > 12) {
                    System.out.println("输入月份有误");
                    if (day < 0 || day > 31)
                        System.out.println("输入的日也有错误");
                }
            }
            else
            {
                System.out.println("输入的年份有错误");
            }

        }

    }
}

