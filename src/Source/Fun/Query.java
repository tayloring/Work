package Source.Fun;

import Source.Interface.Connection;
import Source.Database.JDBC_SQLsever;
import Source.Database.SQL;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 龚银超 on 2016/12/5.
 */
public class Query implements Connection {

    private JDBC_SQLsever J1;
    private SQL q1 = new SQL();
    private PreparedStatement ps = null;
    ResultSet rs = null;
    public JTable table;
    TextArea t = new TextArea();
    String[] title =
            {"姓名", "学号", "年龄", "成绩", "备注"};

    @Override
    public void open() {
        J1 = new JDBC_SQLsever();
        J1.conn();
        long start = System.currentTimeMillis();
        System.out.println("正在查询" + start);

        query();
        long end = System.currentTimeMillis();
        System.out.println("查询成功" + end);
        long wast = (end - start);
        System.out.println("用时:" + wast + "毫秒");


    }

    public void query() {


        //String sql=q1.query+"student";
        String sql = "SELECT * FROM firstTable";
        Object[][] data = new Object[100000][];
        int i = 0;

        //DataModel dataModel= null;

        try {
            ps = J1.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // new DataModel(rs);
            while (rs.next()) {

                System.out.println(rs.getString("name") + ":" + rs.getString("number"));

                //t.append(rs.getString("name")+":    "+rs.getString("age")+"\n");
                data[i] = new Object[5];
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getString("number");
                data[i][2] = rs.getString("age");
                data[i][3] = rs.getString("grade");
                data[i][4] = rs.getString("ps");
                i++;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        table = new JTable(data, title);

    }


    @Override
    public void close() {
        try {
            ps.close();
            rs.close();
            J1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
