
package travels.and.turism;

/**
 *
 * @author sandeep
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;


    public class UpdateCustomer extends JFrame implements ActionListener{
        String username;
        JLabel labelusername, labelname;
        JComboBox comboid;
        JButton add, back;
        JTextField tfno, tfcountry,tfgender, tfaddress,tfid, tfemail, tfphone;
        JRadioButton rbmale, rbfemale, rbother;
   
        UpdateCustomer(String username){
            this.username = username;
            setBounds(450, 200, 850, 550);
            setLayout(null);
            getContentPane().setBackground(Color.white);
            
            JLabel text = new JLabel("UPDATE CUTOMER DETAILS");
            text.setBounds(50, 0, 300, 25);
            text.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(text);
            
            JLabel lbusername = new JLabel("Username");
            lbusername.setBounds(30, 50, 300, 25);
//            lbusername.setFont(new Font("Tahoma", Font.BOLD, 20));
            add(lbusername);
            
            labelusername = new JLabel();
            labelusername.setBounds(220, 50, 300, 25);
            add(labelusername);
            
            JLabel lbid = new JLabel("ID");
            lbid.setBounds(30, 90, 300, 25);
//            lbusername.setFont(new s("Tahoma", Font.BOLD, 20));
            add(lbid);
            
            tfid = new JTextField();
            tfid.setBounds(220, 90, 300, 25);
            add(tfid);
            
            JLabel lbno = new JLabel(" ID Number");
            lbno.setBounds(30, 130, 300, 25);
            add(lbno);
            
            tfno = new JTextField();
            tfno.setBounds(220, 130, 300, 25);
            add(tfno);
            
            JLabel lbname = new JLabel("Name");
            lbname.setBounds(30, 170, 300, 25);
            add(lbname);
            
            labelname = new JLabel();
            labelname.setBounds(220, 170, 300, 25);
            add(labelname);
            
            JLabel lbgender = new JLabel("Gender");
            lbgender.setBounds(30, 210, 300, 25);
            add(lbgender);
            
            tfgender = new JTextField();
            tfgender.setBounds(220, 210, 300, 25);
            add(tfgender);
            
            JLabel lbcountry = new JLabel("Country");
            lbcountry.setBounds(30, 250, 300, 25);
            add(lbcountry);
            
            tfcountry = new JTextField();
            tfcountry.setBounds(220, 250, 300, 25);
            add(tfcountry);
            
            JLabel lbaddress = new JLabel("Address");
            lbaddress.setBounds(30, 290, 300, 25);
            add(lbaddress);
            
            tfaddress = new JTextField();
            tfaddress.setBounds(220, 290, 300, 25);
            add(tfaddress);
            
            JLabel lbphone = new JLabel("Phone");
            lbphone.setBounds(30, 330, 300, 25);
            add(lbphone);
            
            tfphone = new JTextField();
            tfphone.setBounds(220, 330, 300, 25);
            add(tfphone);
            
            JLabel lbemail = new JLabel("Email");
            lbemail.setBounds(30, 370, 300, 25);
            add(lbemail);
            
            tfemail = new JTextField();
            tfemail.setBounds(220, 370, 300, 25);
            add(tfemail);
            
            add = new JButton("Update");
            add.setBackground(Color.BLACK);
            add.setForeground(Color.WHITE);
            add.setBounds(70, 430, 100, 25);
            add.addActionListener(this);
            add(add);
            
            back = new JButton("BACK");
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.setBounds(220, 430, 100, 25);
            back.addActionListener(this);
            add(back);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
            Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(450, 40, 450, 420);
            add(image);
            
            try{
               Conn c = new Conn();
              
               ResultSet rs =  c.s.executeQuery("select * from customer WHERE username = '"+username+"'");
               while(rs.next()){
                   labelusername.setText(rs.getString("username"));
                   labelname.setText(rs.getString("name"));
                   tfid.setText(rs.getString("id"));
                   tfno.setText(rs.getString("number"));
                   tfgender.setText(rs.getString("gender"));
                   tfcountry.setText(rs.getString("country"));
                   tfaddress.setText(rs.getString("address"));
                   tfphone.setText(rs.getString("phone"));
                   tfemail.setText(rs.getString("email"));
                   
               }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
            setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == add){
                
                String id = tfid.getText();
                String number = tfno.getText();
                
                String gender = tfgender.getText();
               
                String country = tfcountry.getText();
                String address = tfaddress.getText();
                String phone = tfphone.getText();
                String email = tfemail.getText();
                
                try{
                    Conn c = new Conn();
                    String query = "update customer set id = '"+id+"', number = '"+number+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"',email =  '"+email+"' where username = '"+username+"'";
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Customer Details Updated successfull");
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }else{
                setVisible(false);
            }
        }
        public static void main(String[] args){
            new UpdateCustomer("");
        }
    }
