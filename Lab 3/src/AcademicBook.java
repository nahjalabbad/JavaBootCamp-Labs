import java.util.List;

public class AcademicBook extends Book{
    private String subject;

    public AcademicBook(String title, String auteur, String ISBN, double price, int stock, String subject) {
        super(title, auteur, ISBN, price, stock);
        this.subject = subject;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMediaType() {
        if (isBestseller()){
            return "\nTiteld as the best Selling AcademicBook with rating of "+getAverageRating();
        }
        return "\nAcademicBook with rating of "+getAverageRating();
    }

    @Override
    public String toString() {
        return "Academic Book "+super.toString();
    }
}
