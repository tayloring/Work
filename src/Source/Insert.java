package Source;



import java.sql.SQLException;


/**
 * Created by 龚银超 on 2016/12/4.
 */
public class Insert   implements Connection {

   private JDBC_SQLsever J1;
    private SQL q1 =new SQL();






    @Override
    public void open() {
        J1 =new JDBC_SQLsever();
        J1.conn();
        long start=System.currentTimeMillis();
        System.out.println("正在插入"+start);

        insert();
        long end=System.currentTimeMillis();
        System.out.println("插入完成"+end);
        long wast=(end-start);
        System.out.println("用时:"+wast+"毫秒");


    }





    public void insert() {
        
      String sate="BULK INSERT MainTable  \n" +
              "FROM 'D:\\DataBase\\xml_data.txt' WITH (FORMATFILE='D:\\DataBase\\src\\XML_Data\\data1.tld')";

         try {

             J1.stmt.executeUpdate(sate);//执行SQL命令对象
             System.out.println("数据插入成功");
         } catch (SQLException e) {
             e.printStackTrace();
         }

    }






    @Override
    public void close() {
         J1.close();
    }


}
