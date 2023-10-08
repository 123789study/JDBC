package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection模块 {
    public static void main(String[] args) throws Exception {

        String url="jdbc:mysql:///study?serverTimezone=GMT%2B8";
        String name="root";
        String password="123456";

        Connection conn = DriverManager.getConnection(url, name, password);
        Statement stat = conn.createStatement();

        String sql1="update student set money=money+1000 where sno='10'";
        String sql2="update student set money=money-1000 where sno='11'";


        try {
            conn.setAutoCommit(false);

            int i1 = stat.executeUpdate(sql1);
            System.out.println(i1);

            int i2 = stat.executeUpdate(sql2);
            System.out.println(i2);
            conn.commit();

        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        }

        stat.close();
        conn.close();
    }
}
