package se.ecutb.magnus;
import UserInterface.SchoolManagement;
import data_acces.CourseDaoList;
import data_acces.StudentDaoList;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


public class AppTest {

    private static Student student1 = new Student(801009, "Karl Karlsson", "kalle@hotmail.com", "hemlös");
    private static StudentDaoList studentList = new StudentDaoList();
    private static CourseDaoList courseList = new CourseDaoList();

    @Test
    public void registerStudent_test(){
        SchoolManagement.setOrdinaryCourses();
        SchoolManagement.setOrdinaryStudents();
        Course newCourse = new Course(199, "Biology", LocalDate.parse("2019-10-01"), 10,null);
        courseList.saveCourse(newCourse);

        courseList.findById(199).register(student1);
        Assert.assertTrue(courseList.findById(199).getStudents().contains(student1));
    }
    @Test
    public void unRegisterStudent_test(){
        SchoolManagement.setOrdinaryCourses();
        SchoolManagement.setOrdinaryStudents();
        Course newCourse = new Course(199, "Biology", LocalDate.parse("2019-10-01"), 10,null);
        courseList.saveCourse(newCourse);
        courseList.findById(199).register(student1);
        Student newStudent = new Student(901011, "Peter Karlsson", "p@hotmail.com", "Landsvägen 1, 666 66 Stad");
        studentList.saveStudent(newStudent);
        courseList.findById(199).register(newStudent);

        courseList.findById(199).unregister(student1);
        Assert.assertFalse(courseList.findById(199).getStudents().contains(student1));
    }
}
