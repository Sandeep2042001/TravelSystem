package travels.and.turism;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author sandeep
 */
public class BookPackage extends JFrame implements ActionListener{
    String username;
    JLabel lbusername,labelusername, lbtotal, lbphone,labelphone, lbnumber, lbid,labelid, labelnumber, labeltotal;
    JTextField tfpersons;
    JButton checkprice, bookpackage, back;
    Choice cpackage;
    
    public BookPackage(String username){
        this.username = username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 250, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        lbusername = new JLabel("Username");
        lbusername.setBounds(50, 70, 150, 25);
        lbusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 70, 200, 25);
        add(labelusername);
        
        JLabel lbpackage = new JLabel("Select Package");
        lbpackage.setBounds(50, 120, 150, 25);
        lbpackage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(220, 120, 180, 40);
        add(cpackage);
        
//        JLabel labelid = new JLabel();
//        labelid.setBounds(180, 110, 200, 25);
//        add(labelid);
        
        JLabel lbperson = new JLabel("Total Person");
        lbperson.setBounds(50, 170, 300, 25);
        lbperson.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbperson);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(220, 170, 180, 25);
        add(tfpersons);
        
        
        lbid = new JLabel("ID");
        lbid.setBounds(50, 220, 300, 25);
        lbid.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbid);
        
        labelid = new JLabel();
        labelid.setBounds(220, 220, 180, 25);
        add(labelid);
        
        lbnumber = new JLabel("Number");
        lbnumber.setBounds(50, 270, 300, 25);
        lbnumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220, 270, 180, 25);
        add(labelnumber);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 270, 300, 25);
        add(labelgender);
        
        lbphone = new JLabel("Phone");
        lbphone.setBounds(50, 320, 300, 25);
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(220, 320, 300, 25);
        add(labelphone);
        
        lbtotal = new JLabel("Total price");
        lbtotal.setBounds(50, 370, 300, 25);
        lbtotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbtotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(220, 370, 300, 25);
        add(labeltotal);
        
        try{
            Conn c = new Conn();
            ResultSet rs =  c.s.executeQuery("select * from customer WHERE username = '"+username+"'");
               while(rs.next()){
                   labelusername.setText(rs.getString("username"));
                   labelid.setText(rs.getString("id"));
                   labelphone.setText(rs.getString("phone"));
                   labelnumber.setText(rs.getString("number"));
        }}catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(290, 420, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Packages");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(460, 420, 150, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(660, 420, 120, 25);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        int cost = 0;
        if(ae.getSource() == back){
            setVisible(false);
        }
        else if(ae.getSource() == bookpackage){
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");
                    
                        
                    JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                    
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
        }else{
            String pack = cpackage.getSelectedItem();
            if(pack.equals("Gold Package")){
                cost += 30000;

            }if(pack.equals("Silver Package")){
                    cost +=  15000;

            }if(pack.equals("Bronze Package")){
                    cost += 8000;
                }
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labeltotal.setText("Rs "+cost+"/-");
    
    }
    }
    
    public static void main(String[] args){
        new BookPackage("");
    }
}
