public class Movie {
    private int id;
    private String title;
    private String category;
    private String trailerUrl;
    private String showTime;

    public Movie(int id, String title, String category, String trailerUrl, String showTime) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.trailerUrl = trailerUrl;
        this.showTime = showTime;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
