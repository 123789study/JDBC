package JDBC;

import org.junit.*;

import java.sql.*;
import java.util.ArrayList;

public class Statement模块 {
    @Test
    public void TestDML() throws SQLException {
        String url = "jdbc:mysql:/study?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "update student set money=money+500";

        Statement stmt = conn.createStatement();

        int count = stmt.executeUpdate(sql);

        System.out.println(count);

        stmt.close();
        conn.close();
    }

    @Test
    public void TestDDL() throws SQLException {
        String url = "jdbc:mysql:/study?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "create database sc";

        Statement stmt = conn.createStatement();

        int count = stmt.executeUpdate(sql);

        System.out.println(count);

        stmt.close();
        conn.close();
    }

    @Test
    public void TestDQL() throws SQLException {
        ArrayList<Count> list=new ArrayList<>();
        String url = "jdbc:mysql:/study?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select * from student";

        Statement stmt = conn.createStatement();

        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String sex = resultSet.getString(4);
            double money=resultSet.getDouble(5);
            Count c=new Count(id,name,age,sex,money);
            list.add(c);
            System.out.println(id+" "+name+" "+age+" "+sex+" "+money);
        }

        resultSet.close();
        stmt.close();
        conn.close();
        System.out.println(list);
    }
}

class Count{
    private int id;
    private String name;
    private int age;
    private String sex;
    private double money;

    public Count() {
    }

    public Count(int id, String name, int age, String sex, double money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.money = money;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return money
     */
    public double getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    public String toString() {
        return "Count{id = " + id + ", name = " + name + ", age = " + age + ", sex = " + sex + ", money = " + money + "}";
    }
}