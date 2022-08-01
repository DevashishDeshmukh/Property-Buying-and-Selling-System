package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Seller_comment extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Seller_comment frame = new Seller_comment();
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
    public Seller_comment() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1414, 769);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 182, 193));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(581, 36, 240, 53);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel(" Comments Section");
        lblNewLabel.setBounds(0, 0, 240, 53);
        panel.add(lblNewLabel);
        lblNewLabel.setBackground(new Color(255, 182, 193));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));

        JPanel panel_1 = new JPanel();
        panel_1.setForeground(new Color(0, 0, 205));
        panel_1.setBounds(209, 174, 505, 53);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 505, 53);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(218, 112, 214));
        panel_3.setBounds(0, 0, 505, 53);
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 0));
        panel_4.setBounds(0, 0, 505, 43);
        panel_3.add(panel_4);
        panel_4.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Leave a Comment");
        lblNewLabel_1.setBounds(0, 0, 505, 53);
        panel_4.add(lblNewLabel_1);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));

        JPanel panel_8 = new JPanel();
        panel_8.setBounds(213, 273, 505, 296);
        contentPane.add(panel_8);
        panel_8.setLayout(null);

        textField = new JTextField();
        textField.setBounds(0, 0, 505, 296);
        panel_8.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Hariom\\Desktop\\The_Comment_Section_logo.png"));
        lblNewLabel_2.setBounds(806, 273, 472, 285);
        contentPane.add(lblNewLabel_2);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(0, 255, 255));
        panel_5.setBounds(628, 624, 90, 27);
        contentPane.add(panel_5);
        panel_5.setLayout(null);

        JButton btnNewButton = new JButton("Post");
        btnNewButton.setBounds(0, 0, 90, 27);
        panel_5.add(btnNewButton);
        btnNewButton.setBackground(getForeground());
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection con = null;
                String url="jdbc:mysql://localhost:3306/opmsa";
                String uname="root";
                String pass="123456";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(url, uname, pass);

                    String paa = textField.getText();
                    LocalDate date = java.time.LocalDate.now();
                    LocalTime time = java.time.LocalTime.now();
                    String query = "INSERT INTO commentr(Date, Comment_time, Comment) VALUES('"+ date +"','" + time + "','" +paa + "');";
                    System.out.println("Value of queries is: "+date + ", "+time+","+paa);
//                    String query1 = "INSERT INTO propertyr1(description, price, property_type, property_status) VALUES('"+ pq+"','"+pe+"','" + pt +"','" + py+"');";
//                    String query2 = "INSERT INTO clients2(username) VALUES('"+pe + "');";
//                    String query3 = "INSERT INTO clients3(password, client_type) VALUES('" + pt + "','" + py+ "');";
//
                    //to store primary key auto-increment should be there in it.
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(query,stmt.RETURN_GENERATED_KEYS);
//                    stmt.executeUpdate(query1,stmt.RETURN_GENERATED_KEYS);
//                    stmt.executeUpdate(query2,stmt.RETURN_GENERATED_KEYS);
//                    stmt.executeUpdate(query3,stmt.RETURN_GENERATED_KEYS);
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();

                }
                catch ( ClassNotFoundException | SQLException ex ){
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBackground(new Color(153, 50, 204));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
    }
}
