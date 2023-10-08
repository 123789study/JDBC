package mashuangqing;

import java.sql.*;

public class TestDB {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost/mashuangqing8.0?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            System.out.println("尝试建立数据库连接");
            Class.forName("com.mysql.cj.jdbc.Driver"); //可省略,因为在lib文件夹下已经注册驱动了
            con = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功");

            String SQL = "delete from student where Sno='200215126'";
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);

            SQL = "insert into student(Sno,Sname,Ssex,Sage,Sdept) values ('200215126','陈冬','男',21,'MA')";
            stmt.executeUpdate(SQL);

            SQL = "select * from student";
            rs = stmt.executeQuery(SQL);

            System.out.println("学号" + "\t\t" + "姓名" + "\t" + "性别" + "\t" + "年龄" + "\t" + "所在系");
            while (rs.next()) {
                System.out.println(rs.getString("Sno") + "\t " + rs.getString("Sname") + '\t'
                        + rs.getString("Ssex") + "\t" + rs.getString("Sage") + "\t" + rs.getString("Sdept"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
    }
}
