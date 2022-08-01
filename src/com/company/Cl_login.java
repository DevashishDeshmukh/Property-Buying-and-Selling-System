package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Cl_login extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JLabel pass;
    private JButton login;
    private JTextField password;
    private String Us,paa;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cl_login frame = new Cl_login();
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
    public Cl_login() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Client Login Page");
        lblNewLabel.setFont(new Font("Rockwell Bold", Font.ITALIC, 14));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(144, 29, 160, 18);
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
                String url="jdbc:mysql://localhost:3306/temmm";
                String uname="root";
                String pass="123456";
                Connection con = null;
                try {
                    Us = username.getText();
                    paa = password.getText();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(url, uname, pass);
                    Statement stmt=con.createStatement();
                    ResultSet res=stmt.executeQuery("Select clients2.username, clients3.password ,clients3.client_type From clients2 INNER JOIN clients3 ON clients2.client_id = clients3.client_id");
                    int a=0;

                    while(res.next()){
                        if(Us.equals(res.getString(1)) && (paa.equals(res.getString(2)))){
                            String opf =  res.getString(3);
                            System.out.println(opf);
                            if(opf.equals("Buyer")){
                                Home_Page_Buyer home = new Home_Page_Buyer();
                                home.setVisible(true);
                            }
                            else
                            {
                                Home_Page_Seller homer = new Home_Page_Seller();
                                homer.setVisible(true);
                            }
                        }
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
