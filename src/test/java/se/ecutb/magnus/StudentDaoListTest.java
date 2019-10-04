package se.ecutb.magnus;

import data_acces.StudentDaoList;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoListTest {
    private static Student student1 = new Student(801009, "Karl Karlsson", "kalle@hotmail.com", "hemlös");
    private static Student student2 = new Student(900117, "Eva Bengtsson", "e_s@hotmail.com", "Storgatan 1, 366 66 Storstad");
    private List<Student> students = new ArrayList<>();
    private StudentDaoList studentDaoTest = new StudentDaoList();

    @Test
    public void saveStudent_test() {
        Student studentExpected  = student2;
        studentDaoTest.saveStudent(student2);

        Assert.assertEquals(studentExpected, studentDaoTest.findById(900117));
    }

    @Test
    public void findByEmail_test() {
        String expected = "e_s@hotmail.com";
        studentDaoTest.saveStudent(student1);
        studentDaoTest.saveStudent(student2);

        Assert.assertEquals(expected, studentDaoTest.findById(900117).getEmail());
    }

    @Test
    public void findByName_test() {
        studentDaoTest.saveStudent(student1);
        students.add(student1);

        Assert.assertEquals(students, studentDaoTest.findByName("Karl Karlsson"));
    }

    @Test
    public void findAll_test() {
        studentDaoTest.saveStudent(student1);
        studentDaoTest.saveStudent(student2);
        students.add(student1);
        students.add(student2);

        Assert.assertEquals(students, studentDaoTest.findAll());
    }

    @Test
    public void deleteStudent_test() {
        studentDaoTest.saveStudent(student1);
        studentDaoTest.saveStudent(student2);
        students.add(student2);

        studentDaoTest.deleteStudent(student1);
        Assert.assertEquals(students, studentDaoTest.findAll());
    }

}
