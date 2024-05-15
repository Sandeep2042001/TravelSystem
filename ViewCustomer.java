package travels.and.turism;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
        
        
        


/**
 *
 * @author sandeep
 */
public class ViewCustomer extends JFrame implements ActionListener{
    String username;
    JButton back;
    JLabel labelusername,labelid, labelnumber, lbname, labelname, labelcountry, labelgender, labelemail, labelphone, labeladdress; 
    public ViewCustomer(String username){
        this.username = username;
        
        
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(30, 50, 300, 25);
        add(lbusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(180, 50, 300, 25);
        add(labelusername);
        
        JLabel lbid = new JLabel("ID");
        lbid.setBounds(30, 110, 300, 25);
        add(lbid);
        
        labelid = new JLabel();
        labelid.setBounds(180, 110, 300, 25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30, 170, 300, 25);
        add(lbnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(180, 170, 300, 25);
        add(labelnumber);
        
        lbname = new JLabel("Name");
        lbname.setBounds(30, 230, 300, 25);
        add(lbname);
        
        labelname = new JLabel();
        labelname.setBounds(180, 230, 300, 25);
        add(labelname);
        
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(30, 290, 300, 25);
        add(lbgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(180, 290, 300, 25);
        add(labelgender);
        
        JLabel lbcountry = new JLabel("Country");
        lbcountry.setBounds(450, 50, 300, 25);
        add(lbcountry);
        
        labelcountry = new JLabel();
        labelcountry.setBounds(550, 50, 300, 25);
        add(labelcountry);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(450, 110, 300, 25);
        add(lbaddress);
        
        labeladdress = new JLabel();
        labeladdress.setBounds(550, 110, 300, 25);
        add(labeladdress);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(450, 170, 300, 25);
        add(lbphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(550, 170, 300, 25);
        add(labelphone);
        
        JLabel lbemail = new JLabel("Email");
        lbemail.setBounds(450, 230, 300, 25);
        add(lbemail);
        
        labelemail = new JLabel();
        labelemail.setBounds(550, 230, 300, 25);
        add(labelemail);
        
        back = new JButton("Back");
        back.setBounds(450, 290, 90, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(130, 350, 600, 200);
        add(image);
        
        try{
            Conn c = new Conn();
            String query = "Select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
            labelusername.setText(rs.getString("username"));
            labelid.setText(rs.getString("id"));
            labelnumber.setText(rs.getString("number"));
            labelname.setText(rs.getString("name"));
            labelgender.setText(rs.getString("gender"));
            labelcountry.setText(rs.getString("country"));
            labeladdress.setText(rs.getString("address"));
            labelphone.setText(rs.getString("phone"));
            labelemail.setText(rs.getString("email"));
            
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

    public static void main(String[] args){
        new ViewCustomer("");
    }
}
