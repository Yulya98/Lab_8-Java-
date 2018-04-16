import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface DaoInterface<T> {
//    static final String URL  ="jdbc:mysql://localhost:3306/Libary";
//
//    static  final String USERNAME = "root";
//    static  final String PASSWORD = "Admin1";
    public List<T> getInfo() throws SQLException, IOException;
    public void Delete() throws SQLException, IOException;
    public void closeConnection() throws SQLException;
    public void openConnection() throws SQLException;
//    default Connection getConnection(){
//        Connection connection = null;
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            return  connection;
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return connection;
//    }
}
