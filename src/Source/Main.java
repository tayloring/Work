package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by 龚银超 on 2016/12/4.
 */
public class Main extends JFrame implements WindowListener,ActionListener{
    private Button b1=new Button("sure");
    private Button b2=new Button("quit");
    private JPanel p1= new JPanel();
    private JPanel p2=new JPanel();
    Container c;
    CInstead c1=new CInstead();
    private JTextArea t1=new JTextArea();

    public Main(){
        super("数据库");

        setContentPane(c1);
        c=getContentPane();
        c.setLayout(new BorderLayout());
       // setLayout(new GridLayout(1,2));

       // add(p1);
      //  add(c1);
        t1.append("hello");
       // p1.add(t1);
        p2.setLayout(new FlowLayout());
     //   p2.setBackground();
        c.add("Center",t1);
        c.add("East",p2);
        p2.add(b1);
        p2.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);


        setSize(700,500);
        setLocation(300,100);
        setVisible(true);


    }





    public static void main(String[] args){

     //   Main m1=new Main();
       // Insert h1= new Insert();
      //  h1.open();
      //  h1.close();
       Data_Source d1= new Data_Source();
        d1.data();
        Insert h1= new Insert();
         h1.open();
         h1.close();

    }

    class CInstead extends JPanel {
        ImageIcon icon;
        Image img;

        public CInstead() {
           icon = new ImageIcon("Image/back.jpg");
            img = icon.getImage();


        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0,null);

        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){}
        if(e.getSource()==b2){
            System.exit(0);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {


    }

    @Override
    public void windowClosing(WindowEvent e) {
             System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
