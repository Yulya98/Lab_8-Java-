import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDao implements DaoInterface{

    static Connection connection;
    FileWriter fileWriter = new FileWriter("C:\\Users\\Yulya\\IdeaProjects\\databaseexam\\exam.txt",true);

    public BooksDao() throws IOException {
    }

    public List<Books> getInfo() throws SQLException, IOException {
        List<Books> list = new ArrayList<Books>();
        BooksDao autorDao = new BooksDao();
        autorDao.openConnection();
        PreparedStatement statement = connection.prepareStatement("Select * from books where years = 2018 Or years = 2017");
        ResultSet rs = statement.executeQuery("Select * from books where years = 2018 Or years = 2017");
        while (rs.next()) {
            Books book = new Books();
            book.NameOfBook = rs.getString("NameOfBook");
            book.NameOfProduction = rs.getString("NameOfProduction");
            book.Yaer = Integer.parseInt(rs.getString("Years"));
            System.out.println(book.toString());
            System.out.print(rs.getString("NameOfAuhtor"));
            list.add(book);
            fileWriter.write("Выбор книг, публикация которых была 2018 или 2017 году "+"NameOfBook :" + rs.getString("NameOfBook") + "NameOfProduction"+ rs.getString("NameOfProduction")+"NameOfAutor:"+rs.getString("NameOfAuhtor"));
            fileWriter.flush();
        }
        autorDao.closeConnection();
        return  list;
    }

    public void Delete() throws SQLException, IOException {
        BooksDao autorDao = new BooksDao();
        autorDao.openConnection();
        PreparedStatement statement = connection.prepareStatement("Delete From Books where years>1990");
        statement.execute();
        fileWriter.write("Удалены строки из таблицы Books");
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

    public void insertIntoDatabase() throws SQLException, IOException {
        BooksDao autorDao = new BooksDao();
        autorDao.openConnection();
        BooksDao.connection.setAutoCommit(false);
        try{
            PreparedStatement preparedStatement = BooksDao.connection.prepareStatement("insert into Books values('NNN','Иванов',1992,'Artezio')");
            BooksDao.connection.commit();

        }catch (SQLException e){
            BooksDao.connection.rollback();
        }
        finally {
            BooksDao.connection.setAutoCommit(true);
        }
    }

    public static void main(String[] args) throws IOException, SQLException {
        BooksDao booksDao = new BooksDao();
        booksDao.insertIntoDatabase();
        booksDao.getInfo();
        booksDao.Delete();
    }
}
