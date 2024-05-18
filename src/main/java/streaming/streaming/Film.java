package streaming.streaming;

public class Film {
    private int id;
    private String name;
    private String description;
    private int ageMin;
    private int duration;
    private int releaseYear;
    private String trailer;

    public Film(String name, String description, int ageMin, int duration, int releaseYear, String trailer) {
        this.id=0;
        this.name = name;
        this.description = description;
        this.ageMin = ageMin;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.trailer = trailer;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
