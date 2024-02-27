import java.util.ArrayList;
import java.util.List;

class Book extends Media {
    private int stock;
    private List<Review> reviews;

    public Book(String title, String auteur, String ISBN, double price, int stock) {
        super(title, auteur, ISBN, price);
        this.stock = stock;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        double rnd = Math.round(sum / reviews.size()*1000.0)/1000.0;
        return rnd;
    }

    public void purchase(User user) {
        if (stock > 0) {
            stock--;
            System.out.println("Thank You for purchasing!");
        } else {
            System.out.println("Sorry, this book is out of stock.");
        }
    }

    public boolean isBestseller() {
        return getAverageRating() >= 4.5;
    }

    public void restock(int quantity) {
        stock += quantity;
        System.out.println("\nThe book: "+getTitle()+" has been restocked with "+quantity+" copies.");
    }

    @Override
    public String getMediaType() {
        if (isBestseller()){
            return "\nTiteld as the best Selling Book with rating of "+getAverageRating();
        }
        return "\nBook with rating of "+getAverageRating();
    }

    @Override
    public String toString() {
        return "Book: " + super.toString()+getMediaType();
    }
}