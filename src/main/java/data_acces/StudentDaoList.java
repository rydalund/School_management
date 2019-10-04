package data_acces;

import se.ecutb.magnus.Course;
import se.ecutb.magnus.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student> students;
    public StudentDaoList(){
        students = new ArrayList<>();
    }


    @Override
    public Student saveStudent(Student student) { //eventuellt koll om student redan är registrerad, utskrift
        students.add(student);
        return student; //lämnpligt att testa?
    }

    @Override
    public Student findByEmail(String email) { //kanke ändra lite
        for (Student student : students) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) { //kanske fattat fel student, students?
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return students;
            }
        }
        return null;
    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == (id)) {
                return student;
            }
        }
        return null;
    }


    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return students.remove(student);
    }
}
