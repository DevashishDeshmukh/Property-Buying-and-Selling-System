import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class jodscsdf extends JFrame {

    private JPanel contentPane;
    public String[] po = new String[5] ;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    jodscsdf frame = new jodscsdf();
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
    public jodscsdf() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1129, 730);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(455, 44, 306, 46);
        contentPane.add(panel);
        panel.setLayout(null);


        JLabel lblNewLabel = new JLabel("uihdvhad");
        lblNewLabel.setBounds(0, 0, 306, 46);
        panel.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

        JButton btnNewButton = new JButton("jk");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement ps;
                String url="jdbc:mysql://localhost:3306/opms";
                String uname="root";
                String pass="123456";
                Connection con = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(url, uname, pass);
                    Statement stmt=con.createStatement();
                    ResultSet res=stmt.executeQuery("Select clients2.username, clients3.password ,clients3.client_type From clients2 INNER JOIN clients3 ON clients2.client_id = clients3.client_id");
                    int a=0;
                    while(res.next()){
                        String df="\""+res.getString(1)+"\"";
                        System.out.println(df);
                        po[a] = df;
                        a++;
                    }
                    JComboBox gh = new JComboBox(po);
                    gh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                    gh.setForeground(Color.WHITE);
                    gh.setBackground(Color.BLACK);
                    gh.setBounds(295, 201, 662, 366);
                    contentPane.add(gh);
                }
                catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(589, 588, 85, 21);
        contentPane.add(btnNewButton);
        System.out.println(po[0]);
//        String sd[] = new String[5];
//        sd[0] = po[0];
//        JComboBox gh = new JComboBox(po);
//        gh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
//        gh.setForeground(Color.WHITE);
//        gh.setBackground(Color.BLACK);
//        gh.setBounds(295, 201, 662, 366);
//        contentPane.add(gh);
//        gh.setVisible(true);
    }

}
