package Source.Database;

import java.sql.*;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by 龚银超 on 2016/12/4.
 */
public class JDBC_SQLsever {

    //加载数据库引擎，返回给定字符串名的类
    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=student";
    //software为数据库的名称
    String user = "sa";
    String password = "123";
    //连接数据库对象
    public Statement stmt = null;
    public Connection conn = null;


    public void conn() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("连接数据库成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("连接失败");
        }

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void close() {


        //最后关闭连接
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
