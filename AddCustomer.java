
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


    public class AddCustomer extends JFrame implements ActionListener{
        String username;
        JLabel labelusername, labelname;
        JComboBox comboid;
        JButton add, back;
        JTextField tfno, tfcountry, tfaddress, tfemail, tfphone;
        JRadioButton rbmale, rbfemale, rbother;
   
        AddCustomer(String username){
            this.username = username;
            setBounds(450, 200, 850, 550);
            setLayout(null);
            getContentPane().setBackground(Color.white);
            
            JLabel lbusername = new JLabel("Username");
            lbusername.setBounds(30, 50, 150, 25);
//            lbusername.setFont(new Font("Tahoma", Font.BOLD, 20));
            add(lbusername);
            
            labelusername = new JLabel();
            labelusername.setBounds(220, 50, 150, 25);
            add(labelusername);
            
            JLabel lbid = new JLabel("ID");
            lbid.setBounds(30, 90, 150, 25);
//            lbusername.setFont(new s("Tahoma", Font.BOLD, 20));
            add(lbid);
            
            comboid = new JComboBox(new String[] {"Passport", "Aadhar Chad", "Pan Card", "DL"});
            comboid.setBounds(220, 90, 150, 25);
            comboid.setBackground(Color.WHITE);
            add(comboid);
            
            JLabel lbno = new JLabel(" ID Number");
            lbno.setBounds(30, 130, 150, 25);
            add(lbno);
            
            tfno = new JTextField();
            tfno.setBounds(220, 130, 150, 25);
            add(tfno);
            
            JLabel lbname = new JLabel("Name");
            lbname.setBounds(30, 170, 150, 25);
            add(lbname);
            
            labelname = new JLabel();
            labelname.setBounds(220, 170, 150, 25);
            add(labelname);
            
            JLabel lbgender = new JLabel("Gender");
            lbgender.setBounds(30, 210, 150, 25);
            add(lbgender);
            
            rbmale = new JRadioButton("Male");
            rbmale.setBounds(220, 210, 70, 25);
            rbmale.setBackground(Color.WHITE);
            add(rbmale);
            
            rbfemale = new JRadioButton("Female");
            rbfemale.setBounds(295, 210, 70, 25);
            rbfemale.setBackground(Color.WHITE);
            add(rbfemale);
            
            ButtonGroup bg = new ButtonGroup();
            bg.add(rbmale);
            bg.add(rbfemale);
            bg.add(rbother);
            
            JLabel lbcountry = new JLabel("Country");
            lbcountry.setBounds(30, 250, 150, 25);
            add(lbcountry);
            
            tfcountry = new JTextField();
            tfcountry.setBounds(220, 250, 150, 25);
            add(tfcountry);
            
            JLabel lbaddress = new JLabel("Address");
            lbaddress.setBounds(30, 290, 150, 25);
            add(lbaddress);
            
            tfaddress = new JTextField();
            tfaddress.setBounds(220, 290, 150, 25);
            add(tfaddress);
            
            JLabel lbphone = new JLabel("Phone");
            lbphone.setBounds(30, 330, 150, 25);
            add(lbphone);
            
            tfphone = new JTextField();
            tfphone.setBounds(220, 330, 150, 25);
            add(tfphone);
            
            JLabel lbemail = new JLabel("Email");
            lbemail.setBounds(30, 370, 150, 25);
            add(lbemail);
            
            tfemail = new JTextField();
            tfemail.setBounds(220, 370, 150, 25);
            add(tfemail);
            
            add = new JButton("ADD");
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
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
            Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400, 40, 450, 420);
            add(image);
            
            try{
               Conn c = new Conn();
              
               ResultSet rs =  c.s.executeQuery("select * from account WHERE username = '"+username+"'");
               while(rs.next()){
                   labelusername.setText(rs.getString("username"));
                   labelname.setText(rs.getString("name"));
               }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
            setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == add){
                String username = labelusername.getText();
                String id = (String)comboid.getSelectedItem();
                String number = tfno.getText();
                String name = labelname.getText();
                String gender = null;
                if(rbmale.isSelected()){
                    gender = "Male";
                }else{
                    gender = "Female";
                }
                String country = tfcountry.getText();
                String address = tfaddress.getText();
                String phone = tfphone.getText();
                String email = tfemail.getText();
                
                try{
                    Conn c = new Conn();
                    String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Customer Details added successfull");
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }else{
                setVisible(false);
            }
        }
        public static void main(String[] args){
            new AddCustomer("");
        }
    }
