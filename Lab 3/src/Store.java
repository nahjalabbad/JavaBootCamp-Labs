import java.util.ArrayList;
import java.util.List;

class Store {
    private List<Media> medias;
    private List<User> users;

    public Store() {
        this.medias = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void addMedia(Media media) {
        medias.add(media);
    }

    public void displayMedias() {
        for (Media media : medias) {
            System.out.println(media);
        }
    }
    public Book searchBook(String title) {
        for (Media media : medias) {
            if (media instanceof Book && media.getTitle().equals(title)) {
                return (Book) media;
            }
        }
        return null;
    }

    public List<Music> getMusicCatalog() {
        List<Music> musicCatalog = new ArrayList<>();
        for (Media media : medias) {
            if (media instanceof Music) {
                musicCatalog.add((Music) media);
            }
        }
        return musicCatalog;
    }

    public List<Movie> getMovieCatalog() {
        List<Movie> movieCatalog = new ArrayList<>();
        for (Media media : medias) {
            if (media instanceof Movie) {
                movieCatalog.add((Movie) media);
            }
        }
        return movieCatalog;
    }
}