package Source.Dialog;

import Source.Fun.Query;
import Source.Fun.Squery;
import Source.Fun.Update;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

/**
 * Created by GYC on 2017/1/4.
 */

public class Querydialog extends JDialog implements WindowListener, ActionListener {

    private JButton b1, b2;
    private JTextField t1, t2;
    private JLabel l1, l2, l3;
    private JPanel j1, j2, j3;


    public Querydialog() {
        // setSize(300,400);
        setLocation(1100, 400);
        b1 = new JButton("SURE");
        b2 = new JButton("EXIT");
        t1 = new JTextField(20);
        // t2=new JTextField(20);
        l3 = new JLabel();
        l1 = new JLabel("查询学号:  ");
        l2 = new JLabel("查询结果:  ");
        j1 = new JPanel();
        j2 = new JPanel();
        j3 = new JPanel();
        setLayout(new GridLayout(3, 1));
        j1.add(l1);
        j1.add(t1);
        j3.add(l2);
        j3.add(l3);

        j2.add(b1);
        j2.add(b2);

        add(j1);
        add(j3);
        add(j2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);

        pack();


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            String number = t1.getText();
            Squery squery = new Squery(number);
            squery.open();
            squery.close();
            try {
                String name = squery.rs.getString("name");
                l3.setText(name);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


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
