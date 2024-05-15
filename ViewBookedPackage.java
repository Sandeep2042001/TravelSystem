package travels.and.turism;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author sandeep
 */
public class ViewBookedPackage extends JFrame implements ActionListener{
    String username;
    JButton back;
    JLabel labelusername,labelpackage, labelpersons, lbid, labelid, labelnumber, labelemail, labelphone, labelprice; 
    public ViewBookedPackage(String username){
        this.username = username;
        
        
        setBounds(450, 200, 900, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.PLAIN,20 ));
        text.setBounds(60, 0, 300, 30);
        add(text);
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(30, 50, 300, 25);
        add(lbusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(180, 50, 300, 25);
        add(labelusername);
        
        JLabel lbpackage = new JLabel("Package Name");
        lbpackage.setBounds(30, 90, 300, 25);
        add(lbpackage);
        
        labelpackage = new JLabel();
        labelpackage.setBounds(180, 90, 300, 25);
        add(labelpackage);
        
        JLabel lbpersons = new JLabel("Total persons");
        lbpersons.setBounds(30, 130, 300, 25);
        add(lbpersons);
        
        labelpersons = new JLabel();
        labelpersons.setBounds(180, 130, 300, 25);
        add(labelpersons);
        
        lbid = new JLabel("ID");
        lbid.setBounds(30, 170, 300, 25);
        add(lbid);
        
        labelid = new JLabel();
        labelid.setBounds(180, 170, 300, 25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30, 210, 300, 25);
        add(lbnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(180, 210, 300, 25);
        add(labelnumber);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(30, 250, 300, 25);
        add(lbphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(180, 250, 300, 25);
        add(labelphone);
        
        JLabel lbprice = new JLabel("Price");
        lbprice.setBounds(30, 290, 300, 25);
        add(lbprice);
        
        labelprice = new JLabel();
        labelprice.setBounds(180, 290, 300, 25);
        add(labelprice);
        
        back = new JButton("Back");
        back.setBounds(150, 360, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);
        
        try{
            Conn c = new Conn();
            String query = "Select * from bookpackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
            labelusername.setText(rs.getString("username"));
            labelid.setText(rs.getString("id"));
            labelnumber.setText(rs.getString("number"));
            labelpackage.setText(rs.getString("package"));
            labelprice.setText(rs.getString("price"));
            labelpersons.setText(rs.getString("persons"));
            labelphone.setText(rs.getString("phone"));
            
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new ViewBookedPackage("");
    }
}
