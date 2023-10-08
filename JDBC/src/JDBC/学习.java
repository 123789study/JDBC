package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class 学习 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        String url="jdbc:mysql:/study?serverTimezone=GMT%2B8";
        String username="root";
        String password="123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql="update student set money=money+114514";

        //4.获取执行sql对象 Statement
        Statement stmt= conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql); //返回受影响的行数

        //6.处理结果
        System.out.println(count);

        //7.资源释放
        stmt.close();
        conn.close();
    }
}
