package LIFEGAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  public static Connection DBConnect() {
    Connection con = null;
    String user = "sys as sysdba";
    String password = "1111";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection(url, user, password);
//      System.out.println("Connection Success");
    } catch (ClassNotFoundException e) {
      System.out.println("Driver Not Found");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("Load Fail");
      e.printStackTrace();
    } 
    return con;
  }
}
