import java.util.List;

public class Books {
    public String getNameOfBook() {
        return NameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        NameOfBook = nameOfBook;
    }

    public  String NameOfBook;

    public int getYaer() {
        return Yaer;
    }

    public void setYaer(int yaer) {
        Yaer = yaer;
    }

    public int Yaer;
    public String NameOfProduction;

    public List<Autor> getNameOfAuthor() {
        return NameOfAuthor;
    }

    public void setNameOfAuthor(List<Autor> nameOfAuthor) {
        NameOfAuthor = nameOfAuthor;
    }

    public String getNameOfProduction() {

        return NameOfProduction;
    }

    public void setNameOfProduction(String nameOfProduction) {
        NameOfProduction = nameOfProduction;
    }

    public List<Autor> NameOfAuthor;

    @Override
    public  String toString(){
        System.out.println("NameOfBook:"+this.NameOfBook);
        return "";
    }
}
