package data_acces;

import se.ecutb.magnus.Student;

import java.util.List;

public interface StudentDao {
    Student saveStudent (Student student);
    Student findByEmail (String email);
    List<Student>findByName (String Name);
    Student findById (int id);
    List<Student>findAll();
    boolean deleteStudent (Student student);

}
