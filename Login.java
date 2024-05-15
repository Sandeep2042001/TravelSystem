
package travels.and.turism;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author sandeep
 */
public class Login extends JFrame implements ActionListener{
    JButton login, signup, password;
    JTextField tfusername, tfpassword;
    Login(){
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        JPanel p1 = new JPanel();
        
        p1.setBackground(new Color(149, 99, 49));
        p1.setBounds(0,0,400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 90, 200, 200);
        p1.add(image);
        
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(60, 20, 100, 25);
        lbusername.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        p2.add(lbusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
         p2.add(tfusername);
         
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setBounds(60, 105, 100, 25);
        lbpassword.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        p2.add(lbpassword);
         
        tfpassword = new JTextField();
        tfpassword.setBounds(60, 145, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(149, 99, 49));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(149, 99, 49)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(149, 99, 49));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(149, 99, 49)));
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forget Password");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(149, 99, 49));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(149, 99, 49)));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(300, 250, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        
       
        
         setVisible(true);
                

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
            String username = tfusername.getText();
            String password1 = tfpassword.getText();
            String query = "Select * from account where username = '"+username+"' AND password = '"+password1+"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Loading(username);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
            }
        }catch(Exception e){
                e.printStackTrace();
                }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
