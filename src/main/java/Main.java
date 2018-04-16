import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class Main {
    private  static final String URL  ="jdbc:mysql://localhost:3306/Libary";
    private static  final String USERNAME = "root";
    private  static  final String PASSWORD = "Admin1";

    public static void main(String[] args) {
        Connection connection;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Соединение с БД установлено");
            }
            connection.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
