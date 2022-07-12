package it.accenture.bootcamp.models;

public class Course {
    private long id;
    private String title;
    private int numHours;

    public Course() {

    }

    public Course(long id, String title, int hours) {
        this.id = id;
        this.title = title;
        this.numHours = hours;
    }

    public int getNumHours() {
        return numHours;
    }

    public void setNumHours(int numHours) {
        this.numHours = numHours;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
