
package travels.and.turism;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author sandeep
 */
    public class CheckPackage extends JFrame{
        CheckPackage(){
            
            String p11[] = {"GOLD PACKAGE", "6 Days of compelte tour and stay","Spacial Nights show", "Daiy new surprises Places tour", "Personal vichal and Hotel at Beach", "Airport Assistance", "Spacial Nights show", "Dialy spacial Treat", "A accistence for all days", "30,000/- per person", "icons/package1.jpg" };
            String p12[] = {"SILVER PACKAGE", "4 Days of compelte tour and stay"," Nights show", "surprises Places tour", "Public vichal and Hotel", "Airport Assistance", "Spacial Nights show", "Dialy spacial Treat", "A accistence for all days", "15,000/- per person", "icons/package2.jpg" };
            String p13[] = {"BRONG PACKAGE", "2 Days of compelte tour and stay"," Nights one day show", " one day tour", "Hotel by own", " no Airport Assistance", "Spacial Nights show", "Dialy spacial Treat", "A accistence for all days", "8,000/- per person", "icons/package3.jpg" };
            setBounds(450, 200, 900, 600);
           
            
            JTabbedPane tab = new JTabbedPane();
            
            JPanel p1 = createPackage(p11);
            tab.addTab("Package 1", null, p1);
            
            JPanel p2 = createPackage(p12);
            tab.addTab("Package 2", null, p2);
            
            JPanel p3 = createPackage(p13);
            tab.addTab("Package 3", null, p3);
            
            
            add(tab);
            
            
            setVisible(true);
    }
        
        public JPanel createPackage(String p[]){
            JPanel p1 = new JPanel();
            p1.setLayout(null);
            p1.setBackground(Color.WHITE);
            
            JLabel l1 = new JLabel(p[0]);
            l1.setBounds(50, 5, 300, 30);
            l1.setForeground(Color.GRAY);
            l1.setFont(new Font("Tahoma", Font.PLAIN, 30));
            p1.add(l1);
            
            JLabel l2 = new JLabel(p[1]);
            l2.setBounds(30, 60, 300, 30);
            l2.setForeground(Color.cyan);
            l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l2);
            
            JLabel l3 = new JLabel(p[2]);
            l3.setBounds(30, 110, 300, 30);
            l3.setForeground(Color.cyan);
            l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l3);
            
            JLabel l4 = new JLabel(p[3]);
            l4.setBounds(30, 160, 300, 30);
            l4.setForeground(Color.cyan);
            l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l4);
            
            JLabel l5 = new JLabel(p[4]);
            l5.setBounds(30, 210, 300, 30);
            l5.setForeground(Color.cyan);
            l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l5);
            
            JLabel l6 = new JLabel(p[5]);
            l6.setBounds(30, 260, 300, 30);
            l6.setForeground(Color.cyan);
            l6.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l6);
            
            JLabel l7 = new JLabel(p[6]);
            l7.setBounds(30, 310, 300, 30);
            l7.setForeground(Color.cyan);
            l7.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l7);
            
            JLabel l8 = new JLabel(p[7]);
            l8.setBounds(30, 360, 300, 30);
            l8.setForeground(Color.cyan);
            l8.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l8);
            
            JLabel l9 = new JLabel(p[8]);
            l9.setBounds(30, 410, 300, 30);
            l9.setForeground(Color.cyan);
            l9.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l9);
            
            JLabel l10 = new JLabel(p[9]);
            l10.setBounds(350, 460, 300, 30);
            l10.setForeground(Color.cyan);
            l10.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l10);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(p[10]));
            Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l12 = new JLabel(i3);
            l12.setBounds(350, 100,500, 300 );
            p1.add(l12);
            
           return p1;
            
        }
    public static void main(String[] args){
      new CheckPackage();  
    }
}
