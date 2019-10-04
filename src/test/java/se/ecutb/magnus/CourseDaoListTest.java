package se.ecutb.magnus;

import data_acces.CourseDaoList;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoListTest {

    private Course course1 = new Course(153, "Science", LocalDate.parse("2019-08-01"), 20);
    private Course course2 = new Course(154, "Math", LocalDate.parse("2019-08-01"), 20);
    private List<Course> courses = new ArrayList<>();
    private CourseDaoList courseDaoTest = new CourseDaoList();

    @Test
    public void saveCourse_test() {
        Course expectedCourse = course2;
        courseDaoTest.saveCourse(course2);

        Assert.assertEquals(expectedCourse, courseDaoTest.findById(154));
    }

    @Test
    public void findByName_test() {
        courseDaoTest.saveCourse(course1);
        courseDaoTest.saveCourse(course2);
        courses.add(course1);

        Assert.assertEquals(courses, courseDaoTest.findByName("Science"));
    }


    @Test
    public void findByDate_test() {
        LocalDate date = LocalDate.parse("2019-08-01");
        courseDaoTest.saveCourse(course1);
        courses.add(course1);

        Assert.assertEquals(courses, courseDaoTest.findByDate(LocalDate.parse("2019-08-01")));
    }

    @Test
    public void findAll_test() {
        courseDaoTest.saveCourse(course1);
        courseDaoTest.saveCourse(course2);
        courses.add(course1);
        courses.add(course2);

        Assert.assertEquals(courses, courseDaoTest.findAll());
    }

    @Test
    public void removeCourse_test() {
        courseDaoTest.saveCourse(course1);
        courseDaoTest.saveCourse(course2);
        List<Course> expectedList = new ArrayList<>();
        expectedList.add(course2);
        courses.add(course1);
        courses.add(course2);
        courseDaoTest.removeCourse(course1);

        Assert.assertEquals(expectedList, courseDaoTest.findAll());
    }
}

