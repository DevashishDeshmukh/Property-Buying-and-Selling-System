package com.company;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registration frame = new Registration();
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
    public Registration() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 808, 579);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 250, 205));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(236, 26, 405, 29);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Client Registration ");
        lblNewLabel.setBounds(10, 0, 367, 29);
        panel.add(lblNewLabel);
        lblNewLabel.setBackground(new Color(204, 102, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));

        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setBackground(new Color(255, 255, 255));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1.setBounds(144, 132, 75, 29);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Address");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1.setBackground(Color.WHITE);
        lblNewLabel_1_1.setBounds(144, 184, 75, 29);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Email");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1_1.setBackground(Color.WHITE);
        lblNewLabel_1_1_1.setBounds(144, 234, 75, 29);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Username");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1_2.setBackground(Color.WHITE);
        lblNewLabel_1_1_2.setBounds(144, 283, 87, 29);
        contentPane.add(lblNewLabel_1_1_2);

        JLabel lblNewLabel_1_1_3 = new JLabel("Password");
        lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1_3.setBackground(Color.WHITE);
        lblNewLabel_1_1_3.setBounds(146, 338, 119, 29);
        contentPane.add(lblNewLabel_1_1_3);

        JLabel lblNewLabel_1_1_4 = new JLabel("Client Type");
        lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1_1_4.setBackground(Color.WHITE);
        lblNewLabel_1_1_4.setBounds(139, 385, 92, 29);
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

        textField_4 = new JTextField();
        textField_4.setColumns(16);
        textField_4.setBounds(293, 338, 297, 26);
        contentPane.add(textField_4);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("D:\\Downloads\\360_F_362562495_Gau0POzcwR8JCfQuikVUTqzMFTo78vkF.jpg"));
        label.setBounds(82, 123, 50, 55);
        contentPane.add(label);

        String[] ced = {"Buyer", "Seller"};
        JComboBox gh = new JComboBox(ced);
        gh.setForeground(Color.RED);
        gh.setBounds(286, 396, 156, 25);
        contentPane.add(gh);

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
                    String pt = textField_4.getText();
                    String py = (String) gh.getItemAt(gh.getSelectedIndex());
                    String query = "INSERT INTO clients(name, address) VALUES('"+ paa +"','" + pa + "');";
                    String query1 = "INSERT INTO clients1(email) VALUES('"+ pq+"');";
                    String query2 = "INSERT INTO clients2(username) VALUES('"+pe + "');";
                    String query3 = "INSERT INTO clients3(password, client_type) VALUES('" + pt + "','" + py+ "');";

                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(query,stmt.RETURN_GENERATED_KEYS);
                    stmt.executeUpdate(query1,stmt.RETURN_GENERATED_KEYS);
                    stmt.executeUpdate(query2,stmt.RETURN_GENERATED_KEYS);
                    stmt.executeUpdate(query3,stmt.RETURN_GENERATED_KEYS);
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();

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
