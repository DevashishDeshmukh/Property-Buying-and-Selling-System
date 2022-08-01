package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_Page_Seller extends JFrame {


    String url="jdbc:mysql://localhost:3306/online_property";
    String uname="root";
    String pass="123456";
    private JPanel contentPane;
    private JTextField tablename;
    private String Us,paa;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home_Page_Seller frame = new Home_Page_Seller();
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
    public Home_Page_Seller() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1043, 680);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 182, 193));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalGlue.setBounds(182, 446, 0, 0);
        contentPane.add(horizontalGlue);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(380, 10, 333, 56);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Seller's Desktop");
        lblNewLabel.setBounds(0, 0, 333, 56);
        panel.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));

        JButton btnNewButton = new JButton("Property Details");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement ps;
                String query="select * from admin_records";
                Connection con = null;
                try {
                    String query1 = "Select * from propertyr";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(url, uname, pass);
                    Statement stmt=con.createStatement();
                    ResultSet res=stmt.executeQuery(query1);
                    int a=0;
                    while(res.next()){
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
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 23));
        btnNewButton.setBounds(153, 148, 229, 39);
        contentPane.add(btnNewButton);

        JButton btnPropertyComments = new JButton("Comments");
        btnPropertyComments.setHorizontalAlignment(SwingConstants.LEFT);
        btnPropertyComments.setFont(new Font("Times New Roman", Font.ITALIC, 23));
        btnPropertyComments.setBounds(153, 229, 199, 39);
        contentPane.add(btnPropertyComments);

        JButton btnPropertyOwners = new JButton("Add Property");
        btnPropertyOwners.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Property_Add lg = new Property_Add();
                lg.setVisible(true);
            }
        });
        btnPropertyOwners.setHorizontalAlignment(SwingConstants.LEFT);
        btnPropertyOwners.setFont(new Font("Times New Roman", Font.ITALIC, 23));
        btnPropertyOwners.setBounds(153, 312, 199, 39);
        contentPane.add(btnPropertyOwners);

        JButton btnBuyProperty = new JButton("Buyer's Details");
        btnBuyProperty.setHorizontalAlignment(SwingConstants.LEFT);
        btnBuyProperty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBuyProperty.setFont(new Font("Times New Roman", Font.ITALIC, 23));
        btnBuyProperty.setBounds(153, 397, 216, 39);
        contentPane.add(btnBuyProperty);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Downloads\\tierra-mallorca-rgj1j8sdeay-un.jpg"));
        lblNewLabel_1.setBounds(455, 129, 456, 342);
        contentPane.add(lblNewLabel_1);

    }
}
