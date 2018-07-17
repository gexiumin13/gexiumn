package shixun;

import java.sql.*;

/**
 * Created by Administrator on 2018/7/15
 */
public class JDBCDemo {
    private Connection getConnection() throws SQLException, ClassNotFoundException { //1. 加载驱动
        try {
            Class<?> forName = Class.forName("com.mysql.jdbc.Driver");
            //2. 创建数据库连接字符串
            String dbURL = "jdbc:mysql://127.0.0.1:3306/hnb11";
            //3. 建立数据库连接
            Connection connection = DriverManager.getConnection(dbURL, "root","root");
            return connection ;
          return null
    }
            catch (ClassNotFoundException e) { e.printStackTrace();
    }
           return  null;
} private void insertData(int id,String accountValue,String password) throws ClassNotFoundException {

    Connection connection = null;
    Statement statement = null;
    try { connection = getConnection();
        //2. 构建添加数据的sql语句
        String sql = "insert into account " + "values(" + id + ",'" + accountValue + "','" + password + "')"; //System.out.println(sql);
        //3. 执行sql语句 statement = connection.createStatement();
        //4. 得到执行后的结果，确定是否添加成功
        int rows = statement.executeUpdate(sql); System.out.println("所影响的行数为：" + rows); } catch (SQLException e) { e.printStackTrace(); } finally {
        try { if(statement != null) { statement.close(); } if(connection != null) { connection.close(); } }
        catch (SQLException e) { e.printStackTrace(); } } } private void deleteData(int id) { Connection connection = null; Statement statement = null; try { connection = getConnection();
//2. 构建删除的sql语句
    String sql = "delete from account where id=" + id;
    //3. 执行删除语句 statement = connection.createStatement();
//4. 获取执行所影响的行数，判断是否执行成功
    int rows = statement.executeUpdate(sql);
    System.out.println("有" + rows + "行被删除成功！"); }
catch (SQLException e) { e.printStackTrace(); }
finally { try { if(statement != null) { statement.close(); }
    if(connection != null) { connection.close(); } }

catch (SQLException e) { e.printStackTrace(); } } }
    private void testUpdateData(int id,String account,String password) throws ClassNotFoundException { Connection connection = null; Statement statement = null;
        try { connection = getConnection();

//2. 创建update sql 语句
            String sql = "update account set user_account='" + account + "',user_password='" + password + "' where id=" + id;
            //3. 执行update 语句 statement = connection.createStatement();
//4. 得到执行结果，确定是否成功
int rows = statement.executeUpdate(sql); System.out.println("更新结果为：" + (rows > 0)); } catch (SQLException e) { e.printStackTrace(); } finally { try { if(statement != null) { statement.close(); }
            if(connection != null) { connection.close(); } }catch (SQLException e) { e.printStackTrace(); } } } private void findAllData() throws SQLException, ClassNotFoundException {
       // 1. 获取数据库连接
        Connection connection = getConnection(); Statement statement = null; ResultSet resultSet = null;
       // 2. 构建查询的sql语句
        String sql = "select user_account,user_password,id from account"; try {
        //3. 执行sql语句，并获得结果集
        statement = connection.createStatement(); resultSet = statement.executeQuery(sql);
        //4. 遍历结果集，输出每条记录的信息。
        StringBuffer buffer = new StringBuffer();buffer.append("------------------------------------------------------------------------------------------------" +System.lineSeparator());
        buffer.append("id\t\t\taccount\t\t\tpassword\t\t\t" +
        System.lineSeparator()); buffer.append("------------------------------------------------------------------------------------------------" + System.lineSeparator());
        while(resultSet.next())
        { int id = resultSet.getInt("id");
        String account = resultSet.getString("user_account");
        String password = resultSet.getString("user_password");
        buffer.append(id + "\t| " + account + "| \t" + password + "|" + System.lineSeparator()); } System.out.println(buffer.toString()); }
        catch (SQLException e) { e.printStackTrace(); } finally
        { try { if(resultSet !=

        }
