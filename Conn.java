
package travels.and.turism;

import java.sql.*;

/**
 *
 * @author sandeep
 */
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms","root", "8955");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
