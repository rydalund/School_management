package data_acces;

import se.ecutb.magnus.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseDaoList implements CourseDao {
    private static List<Course> courses;
       public CourseDaoList(){
        courses = new ArrayList<>();
    }

    @Override
    public Course saveCourse(Course course) { //eventuellt kolla om kurs redan finns
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses){
            if (course.getId() == id){
                return course;
            }
        }
        return null; //kanske utskrift också?
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course>temp = new ArrayList<>();
        for (Course course : courses){
            if (course.getCourseName().equalsIgnoreCase(name)){
                temp.add(course);
            }
        }
        return temp;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course>temp = new ArrayList<>();
        for (Course course : courses){
            if (course.getStartDate().isEqual(date)){
                temp.add(course);
            }
        }
        return temp;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }
}
