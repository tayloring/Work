package Source.Fun;

import Source.Interface.Connection;
import Source.Database.JDBC_SQLsever;
import Source.Database.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  on 2016/12/5.
 */
public class Delete implements Connection {
    private JDBC_SQLsever J1;
    private SQL q1 = new SQL();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    String test;

    public Delete(String test) {

        this.test = test;

    }


    @Override
    public void open() {
        J1 = new JDBC_SQLsever();
        J1.conn();
        long start = System.currentTimeMillis();
        System.out.println("正在删除" + start);

        int result = delete();
        if (result == 1) {
            long end = System.currentTimeMillis();
            System.out.println("删除成功" + end);
            long wast = (end - start);
            System.out.println("用时:" + wast + "毫秒");
        } else {
            System.out.println("删除失败");
        }
    }


    private int delete() {

        String sql = "DELETE FROM firstTable WHERE number=" + test;
        try {
            ps = J1.conn.prepareStatement(sql);
            int back = ps.executeUpdate();
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
