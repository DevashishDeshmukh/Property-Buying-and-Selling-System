package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.sql.*;
public class Main
{
    public static void main (String[]args)
    {
//    Connection con = null;
        Statement statement = null;
        try
        {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection conn =DriverManager.getConnection ("jdbc:mysql://localhost:3306/online_property","root", "123456");

            Statement stmt = conn.createStatement ();


            Scanner sc = new Scanner (System.in);
//            Switch 1
//
            System.out.println("1.Admin Login");
            System.out.println("2.Client Login");
            int choice0;
            choice0=sc.nextInt();
            switch (choice0){
                case 1:
//           switch 2
                    System.out.println ("Select option to proceed : ");
                    System.out.println ("1.Insert");
                    System.out.println ("2.View");
                    int choice;
                    choice = sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            int choice1;
                            System.out.println("Select option to proceed : ");
                            System.out.println("1.Insert Property Details");
                            System.out.println("2.Insert Client Details");
//                            System.out.println("3.Insert Comment Details");
                            System.out.println("3.Delete Property Details ");
                            choice1 = sc.nextInt();



                            switch (choice1) {

                                case 1:
                                    System.out.println("Enter the PropertyName : ");
                                    String demo = sc.nextLine();
                                    String pname = sc.nextLine();
                                    System.out.println("Enter the Address :  ");
                                    String paddress = sc.nextLine();
                                    System.out.println("Enter the Description :  ");
                                    String pdesc = sc.nextLine();
                                    System.out.println("Enter the Price  :  ");
                                    String pprice = sc.nextLine();
                                    System.out.println("Enter the Property Type :  ");
                                    String ptype = sc.nextLine();
                                    System.out.println("Enter the Property Status :  ");
                                    String pstatus = sc.nextLine();
                                    stmt.executeUpdate(" insert into propertyr values("+pname+","+paddress+")" );
                                    stmt.executeUpdate(" insert into propertyr1 values("+pdesc+","+pprice+","+ptype+","+pstatus+")" );

                                    break;
                                case 2:
                                    System.out.println ("Please select Client Type : ");
                                    System.out.println ("1.Buyer");
                                    System.out.println ("2.Seller");
                                    String dummy = sc.nextLine ();
                                    int choice3 = sc.nextInt ();

                                    switch (choice3)
                                    {
                                        case 1:
                                        {
                                            System.out.println ("Please enter Client Details : ");


                                            System.out.print ("Enter Name : ");
                                            String cname = sc.nextLine ();



                                            System.out.print ("Enter Email Address : ");
                                            String cemail = sc.nextLine ();


                                            System.out.print ("Enter Resedential Address : ");
                                            String caddress = sc.nextLine ();


                                            String q ="Insert Into clients Values (8, " + cname + ", " + cemail + ", " + caddress +", Buyer)";

                                            stmt.executeUpdate (q);

                                        }





                                        break;

                                        case 2:

                                        {
                                            System.out.println ("Please enter Client Details : ");


                                            System.out.print ("Enter Name : ");
                                            String cname = sc.nextLine ();



                                            System.out.print ("Enter Email Address : ");
                                            String cemail = sc.nextLine ();


                                            System.out.print ("Enter Resedential Address : ");
                                            String caddress = sc.nextLine ();


                                            String q ="Insert Into clients Values (8, " + cname + ", " + cemail + ", " + caddress +", Seller)";

                                            stmt.executeUpdate (q);

                                        }

                                        break;

                                        default:

                                    }

                                    break;
//                                case 3:
//                                    System.out.println ("Please enter your comment : ");
//                                    String c=sc.next();
//
//                                    LocalDate date = java.time.LocalDate.now();
//                                    LocalTime time = java.time.LocalTime.now();
//
//                                    String q="Insert Into commentr Values (8, "+date+", " +time+", "+c+")";
//
//                                    stmt.executeUpdate (q);
//                                    break;
                                case 3:
                                    ResultSet rs = stmt.executeQuery ("select * from propertyr1  ");
                                    while (rs.next ())
                                        System.out.println (rs.getInt (1) + "  " + rs.getString (2) +"  " + rs.getString (3)+"  " + rs.getString (4)+"  " + rs.getString (5));

                                    System.out.println("Enter the Property ID whose property to be deleted : ");
                                    int pid=sc.nextInt();

                                    stmt.executeUpdate ("Delete * from propertyr where property_id="+pid);
                                    stmt.executeUpdate ("Delete * from propertyr1 where property_id="+pid);
                                    break;


                                default:
                            }



                            break;

                        case 2:
                            int choice3;
                            System.out.println("1. View Property Detials");
                            System.out.println("2. View Comment Detials");
                            choice3 = sc.nextInt();
                            switch (choice3){
                                case 1:
                                    ResultSet rs = stmt.executeQuery ("select * from admin_propr  ");
                                    while (rs.next ())
                                        System.out.println (rs.getInt (1) + "  " + rs.getString (2) +"  " + rs.getString (3)+"  " + rs.getString (4)+"  " + rs.getString (5));
                                    break;
                                case 2:
                                    ResultSet rs1 = stmt.executeQuery ("select * from commentr  ");
                                    while (rs1.next ())
                                        System.out.println (rs1.getInt (1) + "  " +
                                                rs1.getString (2) + "  " +
                                                rs1.getString (3) + "  " +
                                                rs1.getString (4) +"\n");

                                    break;
                                default:
                            }
                            ResultSet rs = stmt.executeQuery ("select * from admin_propr  ");

                        default:

                    }

                    break;

                case 2:
                    System.out.println ("Select option to proceed : ");
                    System.out.println ("1.Insert");
                    System.out.println ("2.View");
                    int choice4;
                    choice4=sc.nextInt();
                    switch (choice4){
                        case 1:
                            int choice1;
                            System.out.println("Select option to proceed : ");
                            System.out.println("1.Insert Property Details");
//                    System.out.println("2.Insert Client Details");
                            System.out.println("2.Insert Comment Details");
//                    System.out.println("4.Delete Property Details ");
                            choice1 = sc.nextInt();



                            switch (choice1) {

                                case 1:
                                    System.out.println("Enter the PropertyName : ");
                                    String demo = sc.nextLine();
                                    String pname = sc.nextLine();
                                    System.out.println("Enter the Address :  ");
                                    String paddress = sc.nextLine();
                                    System.out.println("Enter the Description :  ");
                                    String pdesc = sc.nextLine();
                                    System.out.println("Enter the Price  :  ");
                                    String pprice = sc.nextLine();
                                    System.out.println("Enter the Property Type :  ");
                                    String ptype = sc.nextLine();
                                    System.out.println("Enter the Property Status :  ");
                                    String pstatus = sc.nextLine();
                                    stmt.executeUpdate(" insert into propertyr values("+pname+","+paddress+")" );
                                    stmt.executeUpdate(" insert into propertyr1 values("+pdesc+","+pprice+","+ptype+","+pstatus+")" );

                                    break;
//                        case 2:
//
//                            break;
                                case 2:
                                    System.out.println ("Please enter your comment : ");
                                    String c=sc.next();

                                    LocalDate date = java.time.LocalDate.now();
                                    LocalTime time = java.time.LocalTime.now();

                                    String q="Insert Into commentr Values (8, "+date+", " +time+", "+c+")";

                                    stmt.executeUpdate (q);
                                    break;
//                        case 4:
//                            ResultSet rs = stmt.executeQuery ("select * from propertyr1  ");
//                            while (rs.next ())
//                                System.out.println (rs.getInt (1) + "  " + rs.getString (2) +"  " + rs.getString (3)+"  " + rs.getString (4)+"  " + rs.getString (5));
//
//                            System.out.println("Enter the Property ID whose property to be deleted : ");
//                           int pid=sc.nextInt();
//
//                            stmt.executeUpdate ("Delete * from propertyr where property_id="+pid);
//                            stmt.executeUpdate ("Delete * from propertyr1 where property_id="+pid);
//                            break;


                                default:
                            }



                            break;

                        case 2:
                            int choice3;
                            System.out.println("View Property Detials");
                            System.out.println("View Comment Detials");
                            choice3 = sc.nextInt();
                            switch (choice3){
                                case 1:
                                    ResultSet rs = stmt.executeQuery ("select * from admin_propr  ");
                                    while (rs.next ())
                                        System.out.println (rs.getInt (1) + "  " + rs.getString (2) +"  " + rs.getString (3)+"  " + rs.getString (4)+"  " + rs.getString (5));
                                    break;
                                case 2:
                                    ResultSet rs1 = stmt.executeQuery ("select * from commentr  ");
                                    while (rs1.next ())
                                        System.out.println (rs1.getInt (1) + "  " +
                                                rs1.getString (2) + "  " +
                                                rs1.getString (3) + "  " +
                                                rs1.getString (4) +"\n");

                                    break;
                                default:
                            }
                            ResultSet rs = stmt.executeQuery ("select * from admin_propr  ");

                        default:


                    }

                    break;
                default:
                    System.out.println("Not valid input");
            }
            System.out.println ("Select option to proceed : ");
            System.out.println ("1.Insert");
            System.out.println ("2.View");
            int choice;
            choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    int choice1;
                    System.out.println("Select option to proceed : ");
                    System.out.println("1.Insert Property Details");
//                    System.out.println("2.Insert Client Details");
                    System.out.println("2.Insert Comment Details");
//                    System.out.println("4.Delete Property Details ");
                    choice1 = sc.nextInt();



                    switch (choice1) {

                        case 1:
                            System.out.println("Enter the PropertyName : ");
                            String demo = sc.nextLine();
                            String pname = sc.nextLine();
                            System.out.println("Enter the Address :  ");
                            String paddress = sc.nextLine();
                            System.out.println("Enter the Description :  ");
                            String pdesc = sc.nextLine();
                            System.out.println("Enter the Price  :  ");
                            String pprice = sc.nextLine();
                            System.out.println("Enter the Property Type :  ");
                            String ptype = sc.nextLine();
                            System.out.println("Enter the Property Status :  ");
                            String pstatus = sc.nextLine();
                            stmt.executeUpdate(" insert into propertyr values("+pname+","+paddress+")" );
                            stmt.executeUpdate(" insert into propertyr1 values("+pdesc+","+pprice+","+ptype+","+pstatus+")" );

                            break;
//                        case 2:
//
//                            break;
                        case 2:
                            System.out.println ("Please enter your comment : ");
                            String c=sc.next();

                            LocalDate date = java.time.LocalDate.now();
                            LocalTime time = java.time.LocalTime.now();

                            String q="Insert Into commentr Values (8, "+date+", " +time+", "+c+")";

                            stmt.executeUpdate (q);
                            break;
//                        case 4:
//                            ResultSet rs = stmt.executeQuery ("select * from propertyr1  ");
//                            while (rs.next ())
//                                System.out.println (rs.getInt (1) + "  " + rs.getString (2) +"  " + rs.getString (3)+"  " + rs.getString (4)+"  " + rs.getString (5));
//
//                            System.out.println("Enter the Property ID whose property to be deleted : ");
//                           int pid=sc.nextInt();
//
//                            stmt.executeUpdate ("Delete * from propertyr where property_id="+pid);
//                            stmt.executeUpdate ("Delete * from propertyr1 where property_id="+pid);
//                            break;


                        default:
                    }



                    break;

                case 2:
                    int choice3;
                    System.out.println("View Property Detials");
                    System.out.println("View Comment Detials");
                    choice3 = sc.nextInt();
                    switch (choice3){
                        case 1:
                            ResultSet rs = stmt.executeQuery ("select * from admin_propr  ");
                            while (rs.next ())
                                System.out.println (rs.getInt (1) + "  " + rs.getString (2) +"  " + rs.getString (3)+"  " + rs.getString (4)+"  " + rs.getString (5));
                            break;
                        case 2:
                            ResultSet rs1 = stmt.executeQuery ("select * from commentr  ");
                            while (rs1.next ())
                                System.out.println (rs1.getInt (1) + "  " +
                                        rs1.getString (2) + "  " +
                                        rs1.getString (3) + "  " +
                                        rs1.getString (4) +"\n");

                            break;
                        default:
                    }
                    ResultSet rs = stmt.executeQuery ("select * from admin_propr  ");

                default:

            }

            conn.close ();
        }

        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }
}