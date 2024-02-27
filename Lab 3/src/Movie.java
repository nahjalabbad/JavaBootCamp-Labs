import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Movie extends Media {
    private int duration;


    public Movie(String title, String auteur, String ISBN, double price, int duration) {
        super(title, auteur, ISBN, price);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void watch(User user){
        System.out.println(getTitle()+"Movie has been watched.");
    }

    public List<Movie> recommendSimilarMovies(List<Movie> movieCatalog) {
        ArrayList<Movie> similarMovies = new ArrayList<>();
        for (Movie movieCat : movieCatalog) {
            if (movieCat != this && movieCat.getAuteur().equals(this.getAuteur())) {
                similarMovies.add(movieCat);
            }
        }
        return similarMovies;
    }

    @Override
    public String getMediaType() {
        if (duration>=120)
            return "\n"+getTitle()+" Titled as a Long Movie with "+getDuration()+" minutes";
        return "\n"+getTitle()+" Movie with "+getDuration()+" minutes";
    }

    @Override
    public String toString() {
        return "\nMovie: " +super.toString()+ getMediaType();
    }
}
