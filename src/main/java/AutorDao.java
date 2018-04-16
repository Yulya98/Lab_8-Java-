import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDao implements DaoInterface {
    FileWriter fileWriter = new FileWriter("C:\\Users\\Yulya\\IdeaProjects\\databaseexam\\exam.txt",true);
    static Connection connection;

    public AutorDao() throws IOException {
    }

    public List<Autor> getInfo() throws SQLException, IOException {
        List<Autor> list = new ArrayList<Autor>();
        AutorDao autorDao = new AutorDao();
        autorDao.openConnection();
        PreparedStatement statement = connection.prepareStatement("Select * from Author");
        ResultSet rs = statement.executeQuery("Select * from Author");
        while (rs.next()) {
            Autor autor = new Autor();
            autor.NameOfAuthor = rs.getString("NameOfAuthor");
            autor.Country = rs.getString("Country");
            list.add(autor);
            System.out.println(autor.toString());
            fileWriter.write("Выбор информации о авторах "+" NameOfAuthor: "+ rs.getString("NameOfAuthor")+", Country: "+ rs.getString("Country") );
            fileWriter.flush();
        }
        autorDao.closeConnection();
        return list;
    }

    public void Delete() throws SQLException, IOException {
        AutorDao autorDao = new AutorDao();
        autorDao.openConnection();
        PreparedStatement statement = connection.prepareStatement("Select * from Author where 2<(Select count(*) from Books where Author.NameOfAuthor = books.NameOfAuhtor)");
        ResultSet rs = statement.executeQuery("Select * from Author where 2<(Select count(*) from Books where Author.NameOfAuthor = books.NameOfAuhtor)");
        while (rs.next()) {
            Autor autor = new Autor();
            autor.NameOfAuthor = rs.getString("NameOfAuthor");
            autor.Country = rs.getString("Country");
            System.out.println(autor.toString());
            fileWriter.write("Выбор информации о авторах,которые написали более 2 книг "+" NameOfAuthor: "+ rs.getString("NameOfAuthor")+", Country: "+ rs.getString("Country") );
        }
        autorDao.closeConnection();

    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public void openConnection() throws SQLException {
        String URL  ="jdbc:mysql://localhost:3306/Libary";
        String USERNAME = "root";
        String PASSWORD = "Admin1";
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
    }

    public static void main(String[] args) throws SQLException, IOException {
        AutorDao autorDao = new AutorDao();
        autorDao.Delete();
    }
}
