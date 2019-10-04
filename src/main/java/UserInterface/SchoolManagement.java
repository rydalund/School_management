package UserInterface;

import data_acces.CourseDaoList;
import data_acces.StudentDaoList;
import se.ecutb.magnus.Course;
import se.ecutb.magnus.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SchoolManagement {
    private static List<Student> tempList = new ArrayList<>();
    private static Course course1 = new Course(153, "Math", LocalDate.parse("2019-08-01"), 20, tempList);
    private static Course course2 = new Course(154, "Math", LocalDate.parse("2019-08-01"), 20);
    private static Course course3 = new Course(277, "English", LocalDate.parse("2019-08-01"), 20);
    private static Course course4 = new Course(3, "Spanish", LocalDate.parse("2019-10-15"), 10, tempList);
    private static Course course5 = new Course(4450, "Geography", LocalDate.parse("2019-08-01"), 10, tempList);
    private static Course course6 = new Course(40, "History", LocalDate.parse("2019-10-01"), 20);

    //Några standardstudenter
    private static Student student1 = new Student(801009, "Karl Karlsson", "kalle@hotmail.com", "hemlös");
    private static Student student2 = new Student(900117, "Eva Bengtsson", "e_s@hotmail.com", "Storgatan 1, 366 66 Storstad");
    private static Student student3 = new Student(771228, "Bengt Zorn", "bengan77@hotmail.com", "Slottet, 456 45 Gävle");

    private static Student tempStudent;
    private static StudentDaoList studentList = new StudentDaoList();
    private static CourseDaoList courseList = new CourseDaoList();
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner scannerChar = new Scanner(System.in);
    private static Scanner scannerInt = new Scanner(System.in);
    private static Scanner scannerString = new Scanner(System.in);
    private static Scanner scannerDate = new Scanner(System.in);
    private static boolean keepAliveTemp = true;
    private static int tempInt;

    public static void schoolMenu() {
        System.out.println("---1-Find Course-----------");
        System.out.println("---2-Add Course------------");
        System.out.println("---3-Remove Course---------");
        System.out.println("---4-Edit Course- ---------");
        System.out.println("---5-Find Student----------");
        System.out.println("---6-Add Student-----------");
        System.out.println("---7-Remove Student--------");
        System.out.println("---8-Register Student------");
        System.out.println("---9-Unregister Student----");
        System.out.println("---10-Edit Student---------");
        System.out.println("---11 Quit-----------------");
        System.out.print("---Please make a choice: ");

        Course tempCourse;
        String tempString;
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                do {
                    System.out.println("---Find Course/Courses-----");
                    System.out.println("---Show all Courses press 1");
                    System.out.println("---Find by ID-------press 2");
                    System.out.println("---Find by Name-----press 3");
                    System.out.println("---Find by Date-----press 4");
                    System.out.print("Please make a choice: ");

                    switch (Integer.parseInt(scannerInt.nextLine())) {
                        case 1:
                            List<Course> tempList;
                            tempList = courseList.findAll();
                            if (tempList.size() == 0) {
                                System.out.println("No courses are found!");
                            } else {
                                System.out.println(Arrays.toString(tempList.toArray()));
                            }
                            break;
                        case 2:
                            System.out.println("Enter Course id: ");
                            tempInt = Integer.parseInt(scannerInt.nextLine());

                            if (courseList.findById(tempInt) == null) {
                                System.out.println("No course with id: " + tempInt + " exists!");
                            } else {
                                System.out.println(courseList.findById(tempInt).toString());
                            }
                            break;
                        case 3:
                            System.out.println("Enter Course name: ");
                            tempString = scannerString.nextLine();
                            tempList = courseList.findByName(tempString);

                            if (tempList.size() == 0) {
                                System.out.println("No course with name: " + tempString + " exists!");
                            } else {
                                System.out.println(courseList.findByName(tempString));
                            }
                            break;
                        case 4:
                            System.out.println("Enter Course start date (YYYY-MM-DD): ");
                            LocalDate tempDate = LocalDate.parse(scannerDate.nextLine());
                            tempList = courseList.findByDate(tempDate);

                            if (tempList.size() == 0) {
                                System.out.println("No course with start date: " + tempDate + " exists!");
                            } else {
                                System.out.println(Arrays.toString(tempList.toArray()));
                            }
                            break;
                    }

                    System.out.println("New Course search press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();
                }
                while (keepAliveTemp);
                schoolMenu();
                break;
            case 2:
                do {
                    System.out.println("---Adding new Course!---");
                    System.out.print("Enter new Course id: ");
                    int id = Integer.parseInt(scannerInt.nextLine());
                    System.out.print("Enter new Course name: ");
                    String name = scannerString.nextLine();
                    System.out.print("Enter new Course start date: ");
                    LocalDate date = LocalDate.parse(scannerDate.nextLine());
                    System.out.println("Enter new Course duration in weeks: ");
                    int duration = Integer.parseInt(scannerInt.nextLine());
                    Course newCourse = new Course(id, name, date, duration,null);
                    courseList.saveCourse(newCourse);
                    System.out.println("Course: " + newCourse.toString() + " was added.");
                    System.out.println("Add another Course press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();

                }
                while (keepAliveTemp);
                schoolMenu();
                break;
            case 3:
                do {
                    System.out.println("Enter id of Course to remove: ");
                    tempInt = Integer.parseInt(scannerInt.nextLine());
                    tempCourse = courseList.findById(tempInt);
                    try{
                        courseList.removeCourse(tempCourse);
                        System.out.println("Course: " + tempCourse.toString() + " was removed.");
                    }catch (NullPointerException e){
                        System.out.println("Error! No course with id: " + tempInt + " exists!");
                    }
                    System.out.println("Remove another Course search press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();
                }
                while (keepAliveTemp);
                schoolMenu();
                break;
            case 5:
                do {
                    System.out.println("---Find Student/Students-----");
                    System.out.println("---Show all Student---press 1");
                    System.out.println("---Find by ID/pers.nr-press 2");
                    System.out.println("---Find by Name-------press 3");
                    System.out.print("Please make a choice: ");

                    switch (Integer.parseInt(scannerInt.nextLine())) {
                        case 1:
                            List<Student> tempList;
                            tempList = studentList.findAll(); //Lägga till loop, kanske rubrik
                            if (tempList.size() == 0) {
                                System.out.println("No student are found!");
                            } else {
                                System.out.println(Arrays.toString(tempList.toArray()));
                            }
                            break;
                        case 2:
                            System.out.println("Enter Student id/birthdate: ");
                            tempInt = Integer.parseInt(scannerInt.nextLine());

                            if (studentList.findById(tempInt) == null) {
                                System.out.println("No student with id: " + tempInt + " exists!");
                            } else {
                                System.out.println(studentList.findById(tempInt).toString());
                            }
                            break;
                        case 3:
                            System.out.println("Enter Students name: ");
                            tempString = scannerString.nextLine();
                            tempList = studentList.findByName(tempString);

                            if (tempList.size() == 0) {
                                System.out.println("No student with name: " + tempString + " exists!");
                            } else {
                                System.out.println(studentList.findByName(tempString));
                            }
                            break;
                    }
                    System.out.println("New Student search press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();
                }
                while (keepAliveTemp);
                schoolMenu();
                break;
            case 6:
                do {
                    System.out.println("---Adding new Student!---");
                    System.out.print("Enter Student id or birthdate: ");
                    int id = Integer.parseInt(scannerInt.nextLine());
                    System.out.print("Enter Student name: ");
                    String name = scannerString.nextLine();
                    System.out.print("Enter Student email: ");
                    String email = scannerString.nextLine();
                    System.out.print("Enter Student address: ");
                    String address = scannerString.nextLine();
                    Student newStudent = new Student(id, name, email, address);
                    studentList.saveStudent(newStudent);
                    System.out.println("Student: " + newStudent.toString() + " was added.");
                    System.out.println("Add another Student press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();

                }
                while (keepAliveTemp);
                schoolMenu();
                break;
            case 7:
                do {
                    System.out.println("Enter id of Student to remove: ");
                    tempInt = Integer.parseInt(scannerInt.nextLine());
                    tempStudent = studentList.findById(tempInt);
                    try{
                        studentList.deleteStudent(tempStudent);
                        System.out.println("Student: " + tempStudent.toString() + " was removed.");
                    }catch (NullPointerException e){
                        System.out.println("Error! No student with id: " + tempInt + " exists!");
                    }
                    System.out.println("Remove another Student press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();
                }
                while (keepAliveTemp);
                schoolMenu();
                break;
            case 8:
                do {
                    boolean keepAlive2 = true;
                    boolean keepAlive3 = true;
                    while (keepAlive2){
                        System.out.println("Enter id of Student to register: ");
                        tempInt = Integer.parseInt(scannerInt.nextLine());
                        tempStudent = studentList.findById(tempInt);
                        if (tempStudent == null) {
                            System.out.println("No student with id: " + tempInt + " exists!");
                        } else {
                            keepAlive2=false;
                        }
                    }
                    while (keepAlive3){
                        System.out.println("Enter id of Course to register: ");
                        tempInt = Integer.parseInt(scannerInt.nextLine());
                        tempCourse = courseList.findById(tempInt);
                        if (tempCourse == null) {
                            System.out.println("No course with id: " + tempInt + " exists!");
                        } else {
                            keepAlive3=false;
                        }
                    }
                    courseList.findById(tempInt).register(tempStudent);
                    System.out.println("Confirmation! Student: " + tempStudent + " was registered to: " + courseList.findById(tempInt));
                    System.out.println("Register another Student press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();
                }
                while (keepAliveTemp);
                schoolMenu();
                break;
            case 9:
                do {
                    boolean keepAlive2 = true;
                    boolean keepAlive3 = true;
                    while (keepAlive2){
                        System.out.println("Enter id of Student to unregister: ");
                        tempInt = Integer.parseInt(scannerInt.nextLine());
                        tempStudent = studentList.findById(tempInt);
                        if (tempStudent == null) {
                            System.out.println("No student with id: " + tempInt + " exists!");
                        } else {
                            keepAlive2=false;
                        }
                    }
                    while (keepAlive3){
                        System.out.println("Enter id of Course: ");
                        tempInt = Integer.parseInt(scannerInt.nextLine());
                        tempCourse = courseList.findById(tempInt);
                        if (tempCourse == null) {
                            System.out.println("No course with id: " + tempInt + " exists!");
                        } else {
                            keepAlive3=false;
                        }
                    }
                    try {
                        courseList.findById(tempInt).unregister(tempStudent);
                        System.out.println("Confirmation! Student: " + tempStudent + " was unregistered from: " + courseList.findById(tempInt));
                        System.out.println("Unregister another Student press 1\nTo return to main menu press 2\nPlease make a choice: ");
                        evaluateChoice();
                    } catch (NullPointerException e){
                        System.out.println("Error! Student: " + tempStudent + " was never registered to: " + courseList.findById(tempInt));
                    }
                }
                while (keepAliveTemp);
                schoolMenu();
                break;

            case 4:
                do {
                    //får inte att fungera med en scanner
                    System.out.println("---Edit Course!---");
                    System.out.print("Enter Course id to edit: ");
                    tempInt = Integer.parseInt(scannerInt.nextLine());
                    if (courseList.findById(tempInt) == null) {
                        System.out.println("No course with id: " + tempInt + " exists!");
                    } else {
                        System.out.print("Edit Course name? y/n: ");
                        char choice1 = scannerChar.next().charAt(0);
                        if (choice1 == 'y' || choice1 == 'Y') {
                            System.out.print("Enter new Course name: ");

                            String name = scannerString.next();
                            courseList.findById(tempInt).setCourseName(name);
                            System.out.println("Name was updated to: " + courseList.findById(tempInt).getCourseName());
                        }
                        System.out.print("Edit Course start date? y/n: ");
                        char choice2 = scannerChar.next().charAt(0);
                        if (choice2 == 'y' || choice2 == 'Y') {
                            System.out.print("Enter new start date (YYYY-MM-DD): ");
                            LocalDate date = LocalDate.parse(scannerDate.next());
                            courseList.findById(tempInt).setStartDate(date);
                        }
                        System.out.print("Edit Course duration? y/n: ");
                        char choice3 = scannerChar.next().charAt(0);
                        if (choice3 == 'y' || choice3 == 'Y') {
                            System.out.print("Enter new duration in weeks: ");
                            int duration = Integer.parseInt(scannerInt.next());
                            courseList.findById(tempInt).setWeekDuration(duration);
                        }
                        System.out.println("Updated course: " + courseList.findById(tempInt).toString());
                        System.out.println("Edit another Course press 1\nTo return to main menu press 2\nPlease make a choice: ");
                        evaluateChoice();
                    }
                }
                while (keepAliveTemp);
                schoolMenu();
                break;
            case 10:
                do {
                    //får inte att fungera med en scanner
                    System.out.println("---Edit Student!---");
                    System.out.print("Enter Student id to edit: ");
                    tempInt = Integer.parseInt(scannerInt.nextLine());
                    if (studentList.findById(tempInt) == null) {
                        System.out.println("No student with id: " + tempInt + " exists!");
                    } else {
                        System.out.print("Edit Student name? y/n: ");
                        char choice1 = scannerChar.next().charAt(0);
                        if (choice1 == 'y' || choice1 == 'Y') {
                            System.out.print("Enter new Student name: ");
                            String name = scannerString.next();
                            studentList.findById(tempInt).setName(name);
                            System.out.println("Name was updated to: " + studentList.findById(tempInt).getName());
                        }
                        System.out.print("Edit email? y/n: ");
                        char choice2 = scannerChar.next().charAt(0);
                        if (choice2 == 'y' || choice2 == 'Y') {
                            System.out.print("Enter new email: ");
                            String email = scannerString.next();
                            studentList.findById(tempInt).setEmail(email);
                        }
                        System.out.print("Edit address? y/n: ");
                        char choice3 = scannerChar.next().charAt(0);
                        if (choice3 == 'y' || choice3 == 'Y') {
                            System.out.print("Enter new email: ");
                            String address = scannerString.next();
                            studentList.findById(tempInt).setAddress(address);

                        }
                        System.out.println("Updated student: " + studentList.findById(tempInt).toString());
                        System.out.println("Edit another Course press 1\nTo return to main menu press 2\nPlease make a choice: ");
                        evaluateChoice();
                    }
                }
                while (keepAliveTemp);
                schoolMenu();
                break;
            case 11:
                break;
        }
    }
    private static void evaluateChoice(){
        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                keepAliveTemp = true;
                break;
            case 2:
                keepAliveTemp = false;
                break;
        }
    }

    public static void setOrdinaryCourses(){
        courseList.saveCourse(course1);
        courseList.saveCourse(course2);
        courseList.saveCourse(course3);
        courseList.saveCourse(course4);
        courseList.saveCourse(course5);
        courseList.saveCourse(course6);
        tempList.add(student1);
        tempList.add(student2);
        tempList.add(student3);
    }

    public static void setOrdinaryStudents(){
        studentList.saveStudent(student1);
        studentList.saveStudent(student2);
        studentList.saveStudent(student3);
    }
}
