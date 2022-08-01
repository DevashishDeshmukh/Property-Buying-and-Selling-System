package com.company;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Statement;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Property_Add extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Property_Add frame = new Property_Add();
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
    public Property_Add() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 808, 579);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 182, 193));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(236, 26, 405, 29);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Property");
        lblNewLabel.setBounds(10, 0, 367, 29);
        panel.add(lblNewLabel);
        lblNewLabel.setBackground(new Color(204, 102, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));

        JLabel lblNewLabel_1 = new JLabel("Property Name");
        lblNewLabel_1.setBackground(new Color(255, 255, 255));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1.setBounds(144, 132, 139, 29);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Address");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1.setBackground(Color.WHITE);
        lblNewLabel_1_1.setBounds(144, 184, 75, 29);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Description");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1_1.setBackground(Color.WHITE);
        lblNewLabel_1_1_1.setBounds(144, 234, 110, 29);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Price");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1_2.setBackground(Color.WHITE);
        lblNewLabel_1_1_2.setBounds(144, 283, 87, 29);
        contentPane.add(lblNewLabel_1_1_2);

        JLabel lblNewLabel_1_1_3 = new JLabel("Propert Type");
        lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1_3.setBackground(Color.WHITE);
        lblNewLabel_1_1_3.setBounds(146, 338, 119, 29);
        contentPane.add(lblNewLabel_1_1_3);

        JLabel lblNewLabel_1_1_4 = new JLabel("Property Status");
        lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1_4.setBackground(Color.WHITE);
        lblNewLabel_1_1_4.setBounds(139, 385, 125, 29);
        contentPane.add(lblNewLabel_1_1_4);

        textField = new JTextField();
        textField.setBounds(293, 132, 297, 26);
        contentPane.add(textField);
        textField.setColumns(50);

        textField_1 = new JTextField();
        textField_1.setColumns(150);
        textField_1.setBounds(293, 184, 297, 26);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(50);
        textField_2.setBounds(293, 234, 297, 26);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(20);
        textField_3.setBounds(293, 284, 297, 26);
        contentPane.add(textField_3);

        String[] ced = {"Buyer", "Seller"};
        JComboBox gh = new JComboBox(ced);
        gh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        gh.setModel(new DefaultComboBoxModel(new String[] {"Sold", "Unsold"}));
        gh.setForeground(new Color(0, 0, 0));
        gh.setBounds(293, 389, 156, 25);
        contentPane.add(gh);

        String[] ghd = {"Plots","Flats"};
        JComboBox gh_1 = new JComboBox(ghd);
        gh_1.setModel(new DefaultComboBoxModel(new String[] {"Plots", "Flats"}));
        gh_1.setForeground(Color.BLACK);
        gh_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        gh_1.setBounds(293, 341, 156, 25);
        contentPane.add(gh_1);

        JButton btnNewButton = new JButton("Submit");
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
                    String pa = textField_1.getText();
                    String pq = textField_2.getText();
                    String pe = textField_3.getText();
                    String pt = (String) gh_1.getItemAt(gh_1.getSelectedIndex());
                    String py = (String) gh.getItemAt(gh.getSelectedIndex());
                    System.out.println("Value of queries is: "+paa + ", "+pa+","+pq+", "+pe+", "+pt+", "+py);
                    String query = "INSERT INTO propertyr(name, address) VALUES('"+ paa +"','" + pa + "');";
//                    String query2 = "INSERT INTO clients2(username) VALUES('"+pe + "');";
//                    String query3 = "INSERT INTO clients3(password, client_type) VALUES('" + pt + "','" + py+ "');";
//
                    //to store primary key auto-increment should be there in it.
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(query,stmt.RETURN_GENERATED_KEYS);
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    Statement stmt1 = con.createStatement();
                    String df = "Select property_id From propertyr where name = '"+paa+"'& address = '"+pa;
                    System.out.println(df);
                    ResultSet res=stmt1.executeQuery("Select property_id From propertyr where name = '"+paa+"' and address = '"+pa+"'");
                    res.next();
                    String query1 = "INSERT INTO propertyr1(property_id,description, price, property_type, property_status) VALUES('"+res.getInt(1)+"','"+ pq+"','"+pe+"','" + pt +"','" + py+"');";
                    stmt1.executeUpdate(query1);
//                    stmt.executeUpdate(query2,stmt.RETURN_GENERATED_KEYS);
//                    stmt.executeUpdate(query3,stmt.RETURN_GENERATED_KEYS);


                }
                catch ( ClassNotFoundException | SQLException ex ){
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBackground(new Color(153, 50, 204));
        btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        btnNewButton.setBounds(432, 462, 156, 36);
        contentPane.add(btnNewButton);

    }
}
