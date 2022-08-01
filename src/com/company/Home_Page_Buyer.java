package com.company;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Home_Page_Buyer extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home_Page_Buyer frame = new Home_Page_Buyer();
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
    public Home_Page_Buyer() {
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

        JLabel lblNewLabel = new JLabel("Buyer's Desktop");
        lblNewLabel.setBounds(0, 0, 333, 56);
        panel.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));

        JButton btnNewButton = new JButton("Property");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 23));
        btnNewButton.setBounds(153, 148, 199, 39);
        contentPane.add(btnNewButton);

        JButton btnPropertyComments = new JButton("Comments");
        btnPropertyComments.setHorizontalAlignment(SwingConstants.LEFT);
        btnPropertyComments.setFont(new Font("Times New Roman", Font.ITALIC, 23));
        btnPropertyComments.setBounds(153, 229, 199, 39);
        contentPane.add(btnPropertyComments);

        JButton btnPropertyOwners = new JButton("Property Owner's");
        btnPropertyOwners.setHorizontalAlignment(SwingConstants.LEFT);
        btnPropertyOwners.setFont(new Font("Times New Roman", Font.ITALIC, 23));
        btnPropertyOwners.setBounds(153, 312, 250, 39);
        contentPane.add(btnPropertyOwners);

//        JButton btnBuyProperty = new JButton("Buy Property");
//        btnBuyProperty.setHorizontalAlignment(SwingConstants.LEFT);
//        btnBuyProperty.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//        btnBuyProperty.setFont(new Font("Times New Roman", Font.ITALIC, 23));
//        btnBuyProperty.setBounds(153, 397, 193, 39);
//        contentPane.add(btnBuyProperty);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Downloads\\tierra-mallorca-rgj1j8sdeay-un.jpg"));
        lblNewLabel_1.setBounds(455, 129, 456, 342);
        contentPane.add(lblNewLabel_1);

    }
}
