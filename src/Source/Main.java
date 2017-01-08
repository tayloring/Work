package Source;

import Source.DATA.Data_Source;
import Source.Fun.Insert;
import Source.Gui.GUI;
import Source.Gui.Login;


/**
 * Created by 龚银超 on 2016/12/4.
 */
public class Main {


    public static void main(String args[]) {
        Data_Source data_source = new Data_Source();
        data_source.createFile();
        data_source.data();
        Insert insert =new Insert();
        insert.open();
        insert.close();
        new Login();

    }


}
