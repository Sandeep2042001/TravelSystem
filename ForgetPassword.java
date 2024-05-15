
package travels.and.turism;

/**
 *
 * @author sandeep
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
        
        JTextField tfusername, tfname, tfans, tfquestion, tfpassword;
        JButton search, retrieve, back;
    
    ForgetPassword(){
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);
        
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(40, 20, 100, 25);
        lbusername.setFont(new Font("Tohomo", Font.BOLD, 14));
        p1.add(lbusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(200, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search  = new JButton("search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(360, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lbname = new JLabel("name");
        lbname.setBounds(40, 60, 100, 25);
        lbname.setFont(new Font("Tohomo", Font.BOLD, 14));
        p1.add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
         JLabel lbquestion = new JLabel("security Question");
        lbquestion.setBounds(40, 100, 150, 25);
        lbquestion.setFont(new Font("Tohomo", Font.BOLD, 14));
        p1.add(lbquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(200, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lbans = new JLabel("security answer");
        lbans.setBounds(40, 140, 150, 25);
        lbans.setFont(new Font("Tohomo", Font.BOLD, 14));
        p1.add(lbans);
        
        tfans = new JTextField();
        tfans.setBounds(200, 140, 150, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans); 
        
        retrieve  = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(360, 140, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        
        JLabel lbpassword = new JLabel("password");
        lbpassword.setBounds(40, 180, 150, 25);
        lbpassword.setFont(new Font("Tohomo", Font.BOLD, 14));
        p1.add(lbpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(200, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back  = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 220, 100, 25);
        back.addActionListener(this);
        p1.add(back);
        
        
        
        
        
        
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                    String ans = rs.getString("answer");
                }
               
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == retrieve){
                try{
                String query = "select * from account where answer = '"+tfans.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                   
                }
               
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
            
        }
    }
    public static void main(String[] args){
        
        new ForgetPassword();
    }
}
