import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {
  
  static Connection conn = null;

  public static Connection connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String DB_URL = "jdbc:mysql://localhost:3306/Reservation";
      String USER = "root";
      String PASS = "hrishabh@2106";
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      //System.out.println("Database Created Successfully////Congrats! HAHA");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }
}
