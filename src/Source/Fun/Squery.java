package Source.Fun;

import Source.Database.JDBC_SQLsever;
import Source.Database.SQL;
import Source.Interface.Connection;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GYC on 2017/1/4.
 */

public class Squery implements Connection {

    private JDBC_SQLsever J1;
    private SQL q1 = new SQL();
    private PreparedStatement ps = null;
    public ResultSet rs = null;
    public JTable table;
    TextArea t = new TextArea();
    String[] title =
            {"姓名", "学号", "年龄", "成绩", "备注"};

    String number;

    public Squery(String number) {
        this.number = number;

    }

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
        String sql = "SELECT " + number + " FROM firstTable";


        try {
            ps = J1.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // new DataModel(rs);
            //  while (rs.next()){


          //  System.out.println(rs.getString("name") + ":" + rs.getString("age"));


            //  }


        } catch (SQLException e) {
            e.printStackTrace();
        }


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
