package Source;

/**
 * Created by 龚银超 on 2016/12/5.
 */

//基本SQL语句
public class SQL {
    public String insert= "INSERT INTO MainTable VALUES('name','char')";//插入数据
    public String delete="DELETE FROM MainTable";//删除数据
    public String create="CREATE TABLE";//创建表
    public String drop  ="DROP TABLE";//删除表
    public String query ="SELECT FROM";//查询
    public String update="update MainTable SET";//更新
    public String large_insert="BULK INSERT MainTable";

}
