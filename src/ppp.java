import java.util.*;
import java.sql.*;
public class ppp{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=StudentInfo;";
            String userName = "sa";
            String passWord = "123";
            Connection conn = DriverManager.getConnection(url,userName,passWord);
            Statement statement = conn.createStatement();
            String name,sex;
            int age;
            String sql;
            System.out.print("是否输入学生信息？(确定请输入1)");
            if(in.nextInt()==1){
                String str = in.nextLine();  //用于除去多余换行符
                while(true){
                    System.out.print("请输入姓名:");
                    name = in.nextLine();
                    System.out.print("请输入性别:");
                    sex = in.nextLine();
                    System.out.print("请输入年龄:");
                    age = in.nextInt();
                    sql = "insert into student values('" + name +"','"+sex+"',"+age+");";
                    statement.executeUpdate(sql);
                    System.out.print("是否继续输入?(继续请输入1)");
                    int a = in.nextInt();
                    str = in.nextLine();   //用于除去多余换行符
                    if(a != 1) break;
                }
            }
            sql = "select * from student";
            ResultSet result = statement.executeQuery(sql);
            System.out.println("所有记录:");
            System.out.println("姓名\t    性别\t年龄");
            while(result.next()){
                System.out.print(result.getString("Name"));
                System.out.print(result.getString("Sex")+"\t");
                System.out.println(result.getString("Age"));
            }
            sql = "select * from student where Age > 18";
            result = statement.executeQuery(sql);
            System.out.println("年龄大于18的学生记录:");
            System.out.println("姓名\t    性别\t年龄");
            while(result.next()){
                System.out.print(result.getString("Name"));
                System.out.print(result.getString("Sex")+"\t");
                System.out.println(result.getString("Age"));
            }
            DatabaseMetaData md = conn.getMetaData();
            String tableName = "score";
            result = md.getTables(null, null, tableName, null);
            if (!result.next()){ //若成绩表不存在创建表
                sql = "create table score(Name char(10),Score real)";
                statement.execute(sql);
            }
            System.out.println("请输入操作序号:");
            System.out.println("1.插入\t2.修改\t3.删除\t4.查询\t5.成绩统计\t6.退出");
            int i = in.nextInt();
            while(true){
                switch(i){
                    case 1:statement.executeUpdate(Insert());System.out.println("插入成功");break;
                    case 2:statement.executeUpdate(Update());System.out.println("修改成功");break;
                    case 3:statement.executeUpdate(Delete());System.out.println("删除成功");break;
                    case 4:result = statement.executeQuery(Select());result.next();
                        System.out.println("该学生成绩:" + result.getString("Score"));break;
                    case 5:result = statement.executeQuery("select avg(Score) as a from score");
                        result.next();System.out.println("平均分:" + result.getString("a"));break;
                }
                if(i == 6){ System.out.println("程序已退出。");break;}
                i = in.nextInt();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String Insert(){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入姓名和成绩:");
        String name = in.next();
        float score = in.nextFloat();
        String sql = "insert into score values('" + name +"',"+score+")";
        return sql;
    }
    public static String Update(){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入需修改成绩的学生姓名及目标分数:");
        String name = in.next();
        float score = in.nextFloat();
        String sql = "update score set Score = " + score + "where Name = '" + name + "'";
        return sql;
    }
    public static String Delete(){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入需删除的学生姓名:");
        String name = in.nextLine();
        String sql = "delete from score where Name = '" + name +"'";
        return sql;
    }
    public static String Select(){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入需查询的学生姓名:");
        String name = in.nextLine();
        String sql = "select Score from score where Name = '" + name +"'";
        return sql;
    }
}