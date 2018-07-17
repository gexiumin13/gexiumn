package shixun;

import shix.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/7/17.
 */
public class testConnection {
        try {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        //创建数据库连接字符串
        String dbURl = "jdbc:mysql//localhost:3306/class11";
        //建立数据库链接
        try {
            Connection connection = DriverManager.getConnection(dbURl, "root", "888888gxm");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }


    public  static  void main(String[] args){
        new jdbc();



    }
}





}
