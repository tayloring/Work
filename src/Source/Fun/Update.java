package Source.Fun;

import Source.Interface.Connection;
import Source.Database.JDBC_SQLsever;
import Source.Database.SQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * on 2016/12/5.
 */
public class Update implements Connection {

    private JDBC_SQLsever J1;
    private SQL q1 = new SQL();
    private PreparedStatement ps = null;
    String number, age;

    public Update(String number, String name) {

        this.number = number;
        this.age = name;


    }


    @Override
    public void open() {
        J1 = new JDBC_SQLsever();
        J1.conn();
        long start = System.currentTimeMillis();
        System.out.println("正在更新" + start);

        int result = update();
        if (result == 1) {
            long end = System.currentTimeMillis();
            System.out.println("更新成功" + end);
            long wast = (end - start);
            System.out.println("用时:" + wast + "毫秒");
        } else {
            System.out.println("更新失败");
        }
    }


    private int update() {

        String sql = "UPDATE firstTable SET age=" + age + " WHERE number=" + number;
        try {
            ps = J1.conn.prepareStatement(sql);
            int back;
            back = ps.executeUpdate();
            return back;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }


    @Override
    public void close() {
        try {
            ps.close();
            J1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
