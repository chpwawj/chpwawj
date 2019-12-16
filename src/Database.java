import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName = Studentinfo";
        String sql1 = "select * from student";
        String sql2 = "create table dbo_grade(name varchar(10), age int, grade int)";
        try {
            conn = DriverManager.getConnection(url,"sa","123");
            stmt = conn.createStatement();


            int n1 = stmt.executeUpdate("insert into student values('cyj','男',47)");
            int n2 = stmt.executeUpdate("insert into student values('zyj','女',49)");
            int n3 = stmt.executeUpdate("insert into student values('chp','女',21)");
            if(n1 == 1 && n2 == 1&&n3==1) {
                System.out.println("数据添加成功!");
            }
            else System.out.println("数据添加失败");
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                if (rs.getInt("Age") > 18) {
                    String name = rs.getString("Name");
                    String sex = rs.getString("Sex");
                    int age = rs.getInt("Age");
                    System.out.println("  姓名：" + name + "  性别：" + sex + "  年龄：" + age);
                }
                else rs.next();
            }
            //int n3 = stmt.executeUpdate(sql2);
            //int m1 = stmt.executeUpdate("insert into dbo_grade values('齐小汶',8,99)");
            // int m2 = stmt.executeUpdate("insert into dbo_grade values('李晓晓',28,59)");
            // int m3 = stmt.executeUpdate("delete from dbo_grade where grade < 60");

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("数据库连接失败……");
            e.printStackTrace();
        }
    }
}