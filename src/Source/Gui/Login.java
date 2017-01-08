package Source.Gui;

import Source.Gui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by GYC on 2017/1/3.
 */
public class Login extends JFrame implements WindowListener, ActionListener {

    private JTextField t1 = new JTextField(20);
    private JPasswordField t2 = new JPasswordField(20);
    private JButton b1 = new JButton("SURE");
    private JButton b2 = new JButton("EXIT");
    private JLabel l1 = new JLabel("username:");
    private JLabel l2 = new JLabel("password:");
    private JLabel title = new JLabel("Welcome to Student info center");

    public Login() {


        //设置标题
        super("登陆");
        //设置大小
        setSize(600, 300);
        //设置位置
        setLocation(400, 200);
        String path = "F:\\DataBase\\Work\\src\\Image\\back.jpg";
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
        imagePanel.setLayout(new GridLayout(4, 1, 5, 5));
        imagePanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        JPanel j1 = new JPanel();
        JPanel j2 = new JPanel();
        JPanel j3 = new JPanel();
        JPanel J4 = new JPanel();
        J4.add(title);
        title.setSize(100, 50);
        J4.setOpaque(false);
        // j1.setLayout(new FlowLayout());
        j1.add(b1);
        j1.add(b2);

        j1.setOpaque(false);
        j2.setLayout(new FlowLayout());
        j2.add(l1);
        j2.add(t1);
        j3.add(l2);
        j3.add(t2);
        j3.setOpaque(false);
        t1.setBounds(200, 100, 200, 50);
        b1.setSize(new Dimension(600, 500));
        b2.setSize(new Dimension(600, 500));
        // t1.setSize(200,50);
        j2.setOpaque(false);
        imagePanel.add(J4);
        imagePanel.add(j2);
        imagePanel.add(j3);
        imagePanel.add(j1);


        b1.addActionListener(this);
        b2.addActionListener(this);


        //设置可见
        setVisible(true);
        //点关闭按钮时退出
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void login() {

        String name = t1.getText();
        String passwd = t2.getText();
        // Password passwd =new Password();


        if ((name.equals("gyc")) && (passwd.equals("123"))) {
            new GUI();
            //  G.exetu();
        } else {

            System.out.println("登陆失败");

        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            login();


        }
        if (e.getSource() == b2) {
            System.exit(0);
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
