package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JLabel pass;
    private JButton login;
    private JTextField password;
    private String Us,paa;
    private TextField inputNumber;
    private Label display;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setBackground(SystemColor.scrollbar);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.scrollbar);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login Page");
        lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 14));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(154, 29, 102, 18);
        contentPane.add(lblNewLabel);

        JLabel user = new JLabel("Username");
        user.setFont(new Font("Cambria", Font.BOLD, 16));
        user.setBounds(55, 84, 109, 18);
        contentPane.add(user);
        username = new JTextField();
        username.setBounds(26, 112, 163, 25);
        contentPane.add(username);
        username.setColumns(10);



        pass = new JLabel("Password");
        pass.setFont(new Font("Cambria", Font.BOLD, 16));
        pass.setBounds(259, 84, 109, 18);
        contentPane.add(pass);

        login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement ps;
                String url="jdbc:mysql://localhost:3306/online_property";
                String uname="root";
                String pass="123456";
//                String query="select * from admin_records";
                Connection con = null;
                try {
                    Us = username.getText();
                    paa = password.getText();
                    String query1 = "Select * from commentr";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(url, uname, pass);
                    Statement stmt=con.createStatement();
                    ResultSet res=stmt.executeQuery("Select username, password From admin_records");
                    int a=0;
                    while(res.next()){
//                        System.out.println(res.getString(1) + "  " + res.getString(2));
                        if(Us.equals(res.getString(1)) && (paa.equals(res.getString(2))) ){
                            System.out.println("Login Successfull..........");

                                Home_Page_Seller home = new Home_Page_Seller();
                                home.setVisible(true);
                            a=1;
                            break;

                        }
                    }

                    if(a==0){
                        System.out.println("Incorrect username or password");
                    }
                }
                catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        login.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        login.setBounds(156, 177, 100, 25);
        contentPane.add(login);

        password = new JTextField();
        password.setBounds(237, 112, 145, 25);
        contentPane.add(password);

    }
}
