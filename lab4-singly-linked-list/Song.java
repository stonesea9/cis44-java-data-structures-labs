public class Song {
    private final String title;
    private final String artist;

    public Song(String title, String artist) {
        this.title = title == null ? "" : title.trim();
        this.artist = artist == null ? "" : artist.trim();
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + artist;
    }
}
