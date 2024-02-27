import java.util.List;

public class Novel extends Book{
    private String genre;

    public Novel(String title, String auteur, String ISBN, double price, int stock, String genre) {
        super(title, auteur, ISBN, price, stock);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMediaType() {
        if (isBestseller()){
            return "\nTiteld as the best Selling Novel with rating of "+getAverageRating();
        }
        return "\nNovel with rating of "+getAverageRating();
    }

    @Override
    public String toString() {
        return "Novel "+super.toString();
    }
}
