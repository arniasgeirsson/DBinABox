import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExample2 {

  public static void main(String args[]) {
    Connection conn = null;

    try {
        /*
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Arniermysql");
      */
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:"+1521+":xe", 
                                           "SYSTEM", "CarharttDatabase");

      if(!conn.isClosed())
        System.out.println("Successfully connected to MySQL server using TCP/IP...");

    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    } finally {
      try {
        if(conn != null)
          conn.close();
      } catch(SQLException e) {}
    }
  }
}