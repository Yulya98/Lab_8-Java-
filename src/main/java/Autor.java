import java.io.FileWriter;
import java.io.IOException;

public class Autor {

    public String getNameOfAuthor() {
        return NameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        NameOfAuthor = nameOfAuthor;
    }

    public String NameOfAuthor;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public  String Country;
    public Autor() throws IOException {

    }
    @Override
    public String toString(){
        return "NameOfAutor:"+ this.NameOfAuthor+", Contry:"+this.Country;

    }
}
