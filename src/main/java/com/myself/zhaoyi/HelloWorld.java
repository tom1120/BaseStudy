package com.myself.zhaoyi;/**
 * Created by hasee on 2017/9/5.
 */

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author zhaoyi
 * @createTime 2017-09-2017/9/5-22:35
 */
public class HelloWorld {
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel firstPanel;

    public HelloWorld() {

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("登录按钮鼠标点击事件");
            }
        });
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("取消按钮鼠标点下事件");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println("取消按钮鼠标松开事件");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorld");
        frame.setContentPane(new HelloWorld().firstPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
