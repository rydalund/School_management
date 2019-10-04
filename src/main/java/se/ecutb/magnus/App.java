package se.ecutb.magnus;

import UserInterface.SchoolManagement;
public class App {


    public static void main(String[] args) {
        SchoolManagement.setOrdinaryCourses();
        SchoolManagement.setOrdinaryStudents();
        System.out.println("---WELCOME TO SCHOOL MANAGEMENT---");
        SchoolManagement.schoolMenu();
        System.out.println("---HAVE A NICE DAY AT SCHOOL :)---");
    }
}