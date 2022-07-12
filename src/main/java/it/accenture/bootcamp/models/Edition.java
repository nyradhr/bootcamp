package it.accenture.bootcamp.models;

import java.time.LocalDate;

public class Edition {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Course course;
    private Classroom classroom;

    public Edition(long id, LocalDate startDate, LocalDate endDate, Course course, Classroom classroom) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.classroom = classroom;
    }

    public Edition() {
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
