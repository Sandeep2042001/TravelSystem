
package travels.and.turism;

/**
 *
 * @author sandeep
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable{
    
    Thread t;
    JProgressBar bar;
    String username,name;
    
    public void run(){
        try{
            for(int i=1; i <= 101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if(value < max){
                    bar.setValue(bar.getValue() +1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                    
                }
                Thread.sleep(10);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String username){
        this.username = username;
        t = new Thread(this);
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel and Tourism App");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading please wait...");
        loading.setBounds(220, 130, 200, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);
        
        try{
            Conn c = new Conn();
            String query = "SELECT * from account where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                 name = rs.getString("name");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lbusername = new JLabel("Welcome  " +name);
        lbusername.setBounds(20, 310, 400, 40);
        lbusername.setForeground(Color.RED);
        lbusername.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lbusername);
        t.start();
        setVisible(true);
    }
    public static void main(String[] args){
        new Loading("");
    }
}
