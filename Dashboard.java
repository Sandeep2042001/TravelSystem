
package travels.and.turism;

/**
 *
 * @author sandeep
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addPersonalDetails, upPersonalDetails, viewPersonalDetails, checkPackages,viewbookPakage,  bookPakage;
    Dashboard(String username){
       this.username  = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 128, 0));
        p1.setBounds(0,0,1920, 65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70,70);
        p1.add(icon);
        
        
        JLabel heading = new JLabel("Home Page");
        heading.setBounds(90, 10, 300, 40);
        p1.add(heading);
        heading.setForeground(Color.LIGHT_GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25 ));
       
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 128, 0));
        p2.setBounds(0,65,300 ,1015);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0, 128, 0));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0,0,0,75));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        upPersonalDetails = new JButton("Update Personal Details");
        upPersonalDetails.setBounds(0,50,300,50);
        upPersonalDetails.setBackground(new Color(0, 128, 0));
        upPersonalDetails.setForeground(Color.WHITE);
        upPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        upPersonalDetails.setMargin(new Insets(0,0,0,60));
        upPersonalDetails.addActionListener(this);
        p2.add(upPersonalDetails);
        
        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0, 128, 0));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,75));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        JButton deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0, 128, 0));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,65));
        p2.add(deletePersonalDetails);
        
        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0,200,300,50);
        checkPackages.setBackground(new Color(0, 128, 0));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackages.setMargin(new Insets(0,0,0,135));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);
        
        bookPakage = new JButton("Book Package");
        bookPakage.setBounds(0,250,300,50);
        bookPakage.setBackground(new Color(0, 128, 0));
        bookPakage.setForeground(Color.WHITE);
        bookPakage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPakage.setMargin(new Insets(0,0,0,145));
        bookPakage.addActionListener(this);
        p2.add(bookPakage);
        
        viewbookPakage = new JButton("View Packages");
        viewbookPakage.setBounds(0,300,300,50);
        viewbookPakage.setBackground(new Color(0, 128, 0));
        viewbookPakage.setForeground(Color.WHITE);
        viewbookPakage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookPakage.setMargin(new Insets(0,0,0,145));
        viewbookPakage.addActionListener(this);
        p2.add(viewbookPakage);
        
        JButton viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0, 128, 0));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0,0,0,145));
        p2.add(viewhotels);
        
        JButton bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(0, 128, 0));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotel.setMargin(new Insets(0,0,0,145));
        p2.add(bookhotel);
        
        JButton viewbookedhotel = new JButton(" View Booked Hotels");
        viewbookedhotel.setBounds(0,450,300,50);
        viewbookedhotel.setBackground(new Color(0, 128, 0));
        viewbookedhotel.setForeground(Color.WHITE);
        viewbookedhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookedhotel.setMargin(new Insets(0,0,0,75));
        p2.add(viewbookedhotel);
        
        JButton destinations = new JButton("Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0, 128, 0));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0,0,0,140));
        p2.add(destinations);
        
        JButton payments = new JButton("Payment Here");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0, 128, 0));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0,0,0,115));
        p2.add(payments);
        
        JButton calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0, 128, 0));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0,0,0,140));
        p2.add(calculator);
        
        JButton notepade = new JButton("Open Notepade");
        notepade.setBounds(0,650,300,50);
        notepade.setBackground(new Color(0, 128, 0));
        notepade.setForeground(Color.WHITE);
        notepade.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepade.setMargin(new Insets(0,0,0,100));
        p2.add(notepade);
        
        JButton about = new JButton("About Us");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0, 128, 0));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0,0,0,140));
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1920, 1080);
        add(image);
        
        JLabel text = new JLabel("Have Fun With Sandeep's Software");
        text.setBounds(500, 70, 1000, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN,50 ));
        image.add(text);
        
        
        
        setVisible(true);

    }
    
    
    public void actionPerformed(ActionEvent ae){
        
            if(ae.getSource() == addPersonalDetails){
                new AddCustomer(username);
            }
            else if(ae.getSource() == viewPersonalDetails){
                new ViewCustomer(username);
            }
            else if(ae.getSource() == upPersonalDetails){
                new UpdateCustomer(username);
            }
            else if(ae.getSource() == checkPackages){
                new CheckPackage();
            }
        
            else if(ae.getSource() == bookPakage){
                new BookPackage(username);
            }
            else if(ae.getSource() == viewbookPakage){
                new ViewBookedPackage(username);
            }
    }
    public static void main(String[] args){
        new Dashboard("");
    }
}
