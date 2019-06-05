public class Vinilo {
    private String name_Artist;
    private String title_LP;
    private int year;

    public Vinilo(String name_Artist, String title_LP, int year) {
        this.name_Artist = name_Artist;
        this.title_LP = title_LP;
        this.year = year;
    }

    public String getName_Artist() {
        return name_Artist;
    }

    public void setName_Artist(String name_Artist) {
        this.name_Artist = name_Artist;
    }

    public String getTitle_LP() {
        return title_LP;
    }

    public void setTitle_LP(String title_LP) {
        this.title_LP = title_LP;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vinilo{" +
                "name_Artist='" + name_Artist + '\'' +
                ", title_LP='" + title_LP + '\'' +
                ", year=" + year +
                '}';
    }
}
