package Source;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 龚银超 on 2016/12/7.
 */
public class Data_Source {




    public String createFile(){

          String path2=null;

//path表示所创建文件的路径
        String path = "D:/DataBase";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
// fileName表示创建的文件名；为txt类型；
        String fileName="xml_data.txt";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
                 path2 =file.getPath();

                System.out.println("成功创建数据文件"+path2);

            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            return file.getPath();


        }


        return path2;

    }



    public void data(){



        String path = createFile();
        FileWriter writer;
        try {

            writer = new FileWriter(path,true);

            for(int i=0;i<100000;i++) {

                String str=("Jam"+i)+"\r"+i+"\r\n";
                    writer.write(str);
                     writer.flush();


            }
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
