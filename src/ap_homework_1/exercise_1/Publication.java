package exercise_1;
public class Publication {
    // private or not? do I need a constructor if not otherwise specified
    private String title;
    private int year;

    public Publication(String title, int year){
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getInfo(){
        return title + ", published in " + year + ", by";
    }
}
