package jdbc;
 
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Main {
 
    public static void init(Connection conn) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "CONTACT", null);
        if (rs.next()) {
            System.out.println("Table " +  rs.getString(3) + " exists");
        } else {
            Statement stmt = conn.createStatement();
            String query = "CREATE TABLE Contact (id INT PRIMARY KEY, name VARCHAR(32), mail VARCHAR(32))";
            stmt.executeUpdate(query);
            stmt.close();
 
            stmt = conn.createStatement();
            query = "INSERT INTO Contact VALUES "
            		+ "(1, 'John Doe', 'john_doe@gmail.com'), "
            		+ "(2, 'Trevelyan Garey Dubicki', 'dubicki@gmail.com'), "
            		+ "(3, 'Flamur Sachin Leon', 'sachin@gmail.com'), "
            		+ "(4, 'Pavel Novak', 'novakp@gmail.com'), "
            		+ "(5, 'Sandu Victor', 'sanduv@gmail.com')";
            stmt.executeUpdate(query);
            stmt.close();
        }
    }
 
    public static void main(String[] args) throws Exception {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver).newInstance();
        String protocol = "jdbc:derby:";
        Connection conn = DriverManager.getConnection(protocol + "derbyDB;create=true");
        init(conn);
 
        Statement stmt = conn.createStatement();
        String query = "SELECT name, mail FROM Contact";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println("Name: " + rs.getString("name") + " Mail: " + rs.getString("mail") );
        }
        stmt.close();
        conn.close();
    }
 
}