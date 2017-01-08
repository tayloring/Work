package Source.Gui;

import Source.Dialog.Deldialog;
import Source.Dialog.Querydialog;
import Source.Dialog.Updatedialog;
import Source.Fun.Delete;
import Source.Fun.Insert;
import Source.Fun.Query;
import Source.Fun.Update;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by GYC on 2017/1/1.
 */
public class GUI extends JFrame implements WindowListener, ActionListener {


    private JButton b1 = new JButton("sure");
    private JButton b2 = new JButton("quit");
    private JButton b3 = new JButton("插入");
    private JButton b4 = new JButton("查询");
    private JButton b5 = new JButton("更新");
    private JButton b6 = new JButton("删除");
    private JButton b7 = new JButton("刷新");
    private JLabel l1 = new JLabel("学生信息管理系统");
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JTable p4 = new JTable();
    private JTextArea t1 = new JTextArea();
    private JScrollPane scroll;

    public GUI() {
        super("数据库");
        setSize(1000, 600);
        setLocation(400, 200);
        //setSize(600, 400);
        //设置位置
        //  setLocation(400, 200);
        String path = "F:\\DataBase\\Work\\src\\Image\\back2.jpg";
        // 背景图片
        //背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
        // String path = "Image\\back.jpg";
        // 背景图片
        ImageIcon background = new ImageIcon(path);
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        JPanel imagePanel = (JPanel) this.getContentPane();
        imagePanel.setLayout(new BorderLayout());
        imagePanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));


        Query q = new Query();
        q.open();
        q.close();

        scroll = new JScrollPane(q.table);
        p1.add(scroll);
        p1.setOpaque(false);


        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p2.setOpaque(false);
        p3.add(b1);
        p3.add(b2);
        p3.setOpaque(false);
        p4.add(l1);
        p4.setOpaque(false);

        imagePanel.add("Center", p1);
        imagePanel.add("North", p2);
        imagePanel.add("South", p3);
        // imagePanel.add(p4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setVisible(true);
        // pack();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {


        }
        if (e.getSource() == b2) {
            System.exit(0);
        }

        if (e.getSource() == b3) {
            Insert I = new Insert();
            I.open();
            I.close();

        }
        if (e.getSource() == b4) {

            new Querydialog();


        }

        if (e.getSource() == b5) {


            new Updatedialog();


        }
        if (e.getSource() == b6) {

            new Deldialog();

            //Delete delete=new Delete();
            //   delete.open();
            // delete.close();

        }
        if (e.getSource() == b7) {

            new GUI();

        }


    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

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