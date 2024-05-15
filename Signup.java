
package travels.and.turism;
import java.awt.Color;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author sandeep
 */

public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfans;
    Choice security;
    Signup(){
        setBounds(450, 250, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
      
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(149, 99, 49));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setFont(new Font("Tohoma", Font.BOLD, 14));
        lbusername.setBounds(50, 20, 125, 25);
        p1.add(lbusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
          
        JLabel lbname = new JLabel("Name");
        lbname.setFont(new Font("Tohoma", Font.BOLD, 14));
        lbname.setBounds(50, 60, 125, 25);
        p1.add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setFont(new Font("Tohoma", Font.BOLD, 14));
        lbpassword.setBounds(50, 100, 125, 25);
        p1.add(lbpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        setVisible(true);
          
        JLabel lbsecurity = new JLabel("Security Question");
        lbsecurity.setFont(new Font("Tohoma", Font.BOLD, 14));
        lbsecurity.setBounds(50, 140, 125, 25);
        p1.add(lbsecurity);
        
        security = new Choice();
        security.add("Fav Charactor of the criket team");
        security.add("Fav game");
        security.add("Your fav class Teacher");
        security.add("Your fav book");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);
        
        JLabel lbans = new JLabel("Answer");
        lbans.setFont(new Font("Tohoma", Font.BOLD, 14));
        lbans.setBounds(50, 180, 125, 25);
        p1.add(lbans);
        
        tfans= new JTextField();
        tfans.setBounds(190, 180, 180, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);
       
        
         create = new JButton("Create");
         create.setBackground(Color.white);
         create.setForeground(new Color(149, 99, 49));
         create.setFont(new Font("Tohoma", Font.BOLD, 14));
         create.setBounds(80, 250, 100, 30); // Corrected
         create.addActionListener(this);
         p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(149, 99, 49));
        back.setFont(new Font("Tohoma", Font.BOLD, 14));
        back.setBounds(250, 250, 100, 30); // Corrected
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,40,250,250);
        add(image);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfans.getText();
            
            String query = "insert into account values('"+username+"','"+name+"', '"+password+"','"+question+"', '"+answer+"')";
            try{
               Conn c = new Conn(); 
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Account Create succsessfully");
               setVisible(false);
               new Login();
            }catch(Exception e){
                    e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args){
        new Signup();
    }
}
