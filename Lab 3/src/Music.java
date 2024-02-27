import java.util.ArrayList;
import java.util.List;

public class Music extends Media{
    private String artist;

    public Music(String title, String auteur, String ISBN, double price,String artist) {
        super(title, auteur, ISBN, price);
        this.artist=artist;
    }

    public void listen(User user){
        System.out.println(getTitle()+" has been listened to.");
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Music> generatePlaylist(List<Music> musicCatalog) {
        List<Music> playlist = new ArrayList<>();
        for (Music music : musicCatalog) {
            if (!music.getTitle().equals(this.getTitle()) && music.getArtist().equals(this.artist)) {
                playlist.add(music);
            }
        }
        return playlist;
    }


    @Override
    public String getMediaType() {
        if (getPrice()>=10){
            return "\n"+getTitle()+" Titled as a Premium Music";
        }
        return "\n"+getTitle()+" Music";
    }

    @Override
    public String toString() {
        return "\nMusic: "+super.toString()+getMediaType();
    }
}
