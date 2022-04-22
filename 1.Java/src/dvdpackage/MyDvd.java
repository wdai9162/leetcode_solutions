package dvdpackage;

public class MyDvd {
    public String name;
    public int releaseYear;
    public String director;

    public MyDvd(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public String toString() {
        return this.name + ", directed by " + this.director + ", released in " + this.releaseYear;
    }
}