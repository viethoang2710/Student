package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement(100);

        // Add Student
        sm.addStudent(new Student(1, "Hieu", 8));
        sm.addStudent(new Student(2, "Hoang", 9));
        sm.addStudent(new Student(3, "Phuc", 7));


        //Sort students by score
        sm.sortStudentsByGrade();
        System.out.println("\nList of students after sorting by score:");
        sm.displayStudents();


        //Search students by ID
        System.out.println("\nFind student with ID 2:");
        System.out.println(sm.searchStudent(2));


        //Student Update
        System.out.println("\nUpdate student information with ID 2:");
        sm.updateStudent(2, "Bob Updated", 10);
        sm.displayStudents();


        //Delete student
        System.out.println("\nDelete student with ID 1:");
        sm.deleteStudent(1);
        sm.displayStudents();




    }
}