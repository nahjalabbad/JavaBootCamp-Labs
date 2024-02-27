import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
//Add Books:
        Book b1 = new Book("The Hunger Games", "Suzanne Collins", "0439023483", 13.39, 10);
        b1.addReview(new Review("nahj", 4, "Best one I've read"));
        b1.addReview(new Review("Anas", 5));
        b1.addReview(new Review("Mohammad", 5));
        //----------------------------------------------------------------------------------------
        Novel b2 = new Novel("Spy x Family", "Tatsuya Endo", "1974715469", 6.49, 15, "Fiction");
        b2.addReview(new Review("nahj", 3.5, "Best one I've read"));
        b2.addReview(new Review("Anas", 2.8));
        b2.addReview(new Review("Mohammad", 5));
        //-------------------------------------------------------------------------------------------------
        AcademicBook b3 = new AcademicBook("Inclusive Education for the 21st Century", "Linda J. Graham", "9781032396859", 36.99, 5, "Theory, Policy and Practice");
        b3.addReview(new Review("nahj", 5, "Best one I've read"));
        b3.addReview(new Review("Anas", 3.8));
        b3.addReview(new Review("Mohammad", 4));
        //---------------------------------------------------------------------

        //Add Movies:
        Movie mov1 = new Movie("Oppenheimer", "Christopher Nolan", "0571381316", 40.0, 180);
        Movie mov2 = new Movie("Madame Web", "S.J. Clarkson", "0571381316", 31.0, 116);
        Movie mov3 = new Movie("Dune: Part Two", "Denis Villeneuve", "0571381316", 19.0, 166);
        Movie mov4 = new Movie("The Dark Knight", "Christopher Nolan", "0571381316", 35.0, 152);
        Movie mov5 = new Movie("Tenet", "Christopher Nolan", "0571381316", 32.0, 150);
        Movie mov6 = new Movie("Inception", "Christopher Nolan", "0571381316", 29.0, 148);
        //--------------------------------------------------------------------------
        //Add Music:
        Music mus1 = new Music("Bad Liar", "Imagine Dragon", "2342342342", 13, "Imagine Dragon");
        Music mus2 = new Music("Demons", "Imagine Dragon", "2342342342", 8, "Imagine Dragon");
        Music mus3 = new Music("Thunder", "Imagine Dragon", "2342342342", 13, "Imagine Dragon");
        Music mus4 = new Music(". . . Baby One More Time", "Britney Spears", "2342342342", 19, "Britney Spears");

        //----------------------------------------------------------------------------------------------------------------------
        Store store = new Store();
        store.addMedia(b1);
        store.addMedia(b2);
        store.addMedia(b3);
        store.addMedia(mov1);
        store.addMedia(mov2);
        store.addMedia(mov3);
        store.addMedia(mov4);
        store.addMedia(mov5);
        store.addMedia(mov6);
        store.addMedia(mus1);
        store.addMedia(mus2);
        store.addMedia(mus3);
        store.addMedia(mus4);

        User user1 = new User("Nahj", "nahj@gmail.com");
        User user2 = new User("Noun", "noun@gmail.com");

        //Add Media to User 1
        user1.addToCart(b1);
        user1.addToCart(mov2);
        user1.addToCart(mov3);

        System.out.println("\nHello "+user1.getUsername()+" Showing your Shopping Cart: "+user1.getShoppingCart());

        //Add Media to User 2
        user2.addToCart(b3);
        user2.addToCart(mus1);
        user2.addToCart(mus4);

        //Showing Listen and Watch method
        mov3.watch(user1);
        mus1.listen(user1);

        System.out.println("\nHello "+user2.getUsername()+" Showing your Shopping Cart: "+user2.getShoppingCart());
        //Display available medias
        store.displayMedias();

        //Display registered users
        store.addUser(user1);
        store.addUser(user2);
        store.displayUsers();

        //Removing Media from User1 cart
        user1.removeFromCart(b1);
        System.out.println("\nHello "+user1.getUsername()+" Showing your Shopping Cart after removing: "+user1.getShoppingCart());


        //Completing Purchase
        user1.checkout();

        //View purchased list
        System.out.println("\nPurchased List:");
        user1.getPurchasedMediaList().forEach(System.out::println);

        //Calculating Average Ratings
        double averageRatingBook1 = b3.getAverageRating();
        System.out.println("\nAverage Rating for "+b3.getTitle() +" : "+ averageRatingBook1);

        //Searching for Media
        System.out.println("Enter a book title to search for: ");
        String input=inp.nextLine();
        Book foundBook = store.searchBook(input);
        if (foundBook != null) {
            System.out.println("\nBook found: " + foundBook);
        } else {
            System.out.println("\nBook not found.");
        }

        //Restocking Books
        b1.restock(5);

        //Generating Playlist
        List<Music> musicCatalog = store.getMusicCatalog();
        List<Music> playlist = mus1.generatePlaylist(musicCatalog);
        System.out.println("\nGenerated Playlist based on the artist "+mus1.getArtist()+" :");
        playlist.forEach(System.out::println);

        List<Movie> movieCatalog = store.getMovieCatalog();
        List<Movie> series = mov1.recommendSimilarMovies(movieCatalog);
        System.out.println("\nGenerated Series of movies based on the director "+mov1.getAuteur()+" :");
        series.forEach(System.out::println);

    }
}
