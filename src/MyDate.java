import java.util.*;

public class MyDate {
    private String Sname;
    private int Sage;
    private date Sbirth = new date();
    private float Sgrade;

    class date
    {
        int year;
        int month;
        int day;

        public boolean check()
        {
            if (month > 0 & month < 13)
            {
                if(month == 2)
                {
                    if(year%4 == 0)
                    {		//闰年
                        if(day < 0 | day > 29) {System.out.println("输入day有误"); return false;}
                    }
                    else
                        {			        //平年
                        if(day < 0 | day > 28) {System.out.println("输入day有误"); return false;}
                        }
                }
                else if(month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12)
                {
                    if(day < 1 | day > 31) {System.out.println("输入day有误");  return false;}
                }
                else
                    {
                    if(day <1 | day > 30) {System.out.println("输入day有误"); return false;}
                    }
            }
            else {System.out.println("输入month有误"); return false;}
            return true;
        }
    }

    public void input() {
        Scanner  input = new Scanner(System.in);
        Sname = input.next();
        Sbirth.year = input.nextInt();
        Sbirth.month = input.nextInt();
        Sbirth.day = input.nextInt();
        checkDate();
        Sage = 2018 - Sbirth.year;
        Sgrade = input.nextFloat();
    }

    public float getgrade() {
        return Sgrade;
    }

    public float getage() {
        return Sage;
    }

    public void checkDate() {
        boolean check = this.Sbirth.check();
        if (!check) {
            throw new IllegalArgumentException("输入的出生年月日有误");
        }
    }

    public static void main(String[] args) {
        float sum_grade = 0;
        float sum_age = 0;
        MyDate[] student = new MyDate[10];
        for (int i = 0; i < 10; i++) {
            student[i] = new MyDate();
        }
        for (int i = 0; i < 10; i++) {
            student[i].input();
            sum_grade += student[i].getgrade();
            sum_age += (float)student[i].getage();
        }
        float grade_average = sum_grade/10;
        float age_average = sum_age/10;
        System.out.println("平均年龄：" + age_average);
        System.out.println("平均分：" + grade_average);
    }
}