public class Song {

    private int id;
    private String title;
    private String authorName;
    private String albumName;
    private int year;

    public Song(int id, String title, String authorName, String albumName, int year) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.albumName = albumName;
        this.year = year;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "id:" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", year=" + year;
    }
}