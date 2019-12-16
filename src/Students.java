 import java.util.*;
class Person {
    String name;
    double SFNum;

    public void set(String name, double SFNum) {
        this.name = name;
        this.SFNum = SFNum;
    }
}
    public class Students extends Person {
        double Grade, Date;
        int XNum, i = 0;
        double sum = 0;
        String a[] = new String[100];

        public void KH() {
            Scanner in = new Scanner(System.in);
            String name = in.next();
            double SFNum = in.nextDouble();
            double Grade = in.nextDouble();
            double Date = in.nextDouble();
            int XNum = in.nextInt();
            super.set(name, SFNum);
        }
        public void CQ() {
            Scanner in = new Scanner(System.in);
            long money = in.nextLong();
            sum += money;
            a[i] = "存入：" + money + "元";
            i = i + 1;
        }
        public void QQ() {
            Scanner in = new Scanner(System.in);
            long money = in.nextLong();
            if (sum - money < 0) {
                System.out.println("余额不足");
                System.exit(0);
            } else {
                sum -= money;
                a[i] = "取走：" + money + "元";
                i = i + 1;
            }
        }
        public void CX() {
            System.out.println("1.查询余额");
            System.out.println("2.查询流水");
            Scanner in = new Scanner(System.in);
            int m = in.nextInt();
            switch (m) {
                case 1: {
                    System.out.println("余额：" + sum);
                    break;
                }
                case 2: {
                    for (int j = 0; j < i; j++)
                    {
                        System.out.println(a[j]);
                    }
                }
            }
        }
        public void XH(Students s) {
            s = null;
        }
        public static void main(String[] args)
        {
            boolean flag=true;
            Students s=new Students();
            System.out.println("输入想要执行的操作：\n1.开户\n2.存钱\n3.取钱\n4.查询\n5.销户");
            Scanner n=new Scanner(System.in);
            while(flag) {
                int m=n.nextInt();
                switch (m) {
                    case 1:
                    {s.KH();
                        break;}
                    case 2:
                    {s.CQ();
                        break;}
                    case 3:
                    {s.QQ();
                        break;}
                    case 4:
                    { s.CX();
                        break;}
                    case 5:
                    {s.XH(s);flag=false;System.exit(0);
                        break;}
                }
            }
        }

}

