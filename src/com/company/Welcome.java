package com.company;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;

public class Welcome extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Welcome frame = new Welcome();
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
    public Welcome() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hariom\\Desktop\\360_F_362562495_Gau0POzcwR8JCfQuikVUTqzMFTo78vkF.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 812 , 568);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(169, 169, 169));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JDesktopPane desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);

        Box horizontalBox = Box.createHorizontalBox();
        desktopPane.setBackground(new Color(169, 123, 169));
        horizontalBox.setBounds(187, 10, 477, 77);
        desktopPane.add(horizontalBox);

        JPanel panel = new JPanel();
        horizontalBox.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome To Online Property Management System");
        lblNewLabel.setBounds(44, 24, 392, 30);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        panel.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 16));

        JButton admin_login = new JButton("Admin Login");
        admin_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login lg = new Login();
                lg.setVisible(true);
            }
        });
        admin_login.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
        admin_login.setBackground(new Color(205, 92, 92));
        admin_login.setBounds(134, 158, 133, 39);
        desktopPane.add(admin_login);

        JButton Client_login = new JButton("Client Login");
        Client_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    Cl_login cl = new Cl_login();
                    cl.setVisible(true);
            }
        });
        Client_login.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
        Client_login.setBackground(new Color(154, 205, 50));
        Client_login.setBounds(134, 266, 125, 39);
        desktopPane.add(Client_login);

        JButton Client_registration = new JButton("Client Registration");
        Client_registration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Registration rg = new Registration();
                rg.setVisible(true);
            }
        });
        Client_registration.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
        Client_registration.setBackground(new Color(154, 205, 50));
        Client_registration.setBounds(134, 387, 181, 39);
        desktopPane.add(Client_registration);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hariom\\Desktop\\download.jfif"));
        lblNewLabel_1.setBounds(429, 125, 303, 338);
        desktopPane.add(lblNewLabel_1);
    }
}
