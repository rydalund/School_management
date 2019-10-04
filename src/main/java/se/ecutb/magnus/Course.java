package se.ecutb.magnus;

import java.time.LocalDate;
import java.util.*;

public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }

    public Course(int id, String courseName, LocalDate startDate, int weekDuration, List<Student> students) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents (List<Student> students) {
        this.students = students;
    }

    public void register (Student student) {
        if (students == null) {
            List<Student> students = new ArrayList<>();
            setStudents(students);
            students.add(student);
        }else{
            students.add(student);
        }
    }

    public void unregister (Student student){
        students.remove(student);
    }

    @Override
    public String toString() {
        ;
        return "Course: " + getId() + ", " + getCourseName() + ", Start date " + getStartDate() + ", " + getWeekDuration() + " Weeks" + ", Students: " + getStudents();
    }
}