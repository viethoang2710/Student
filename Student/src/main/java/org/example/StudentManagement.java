package org.example;

public class StudentManagement {
    private StudentStack students;

    // Constructor
    public StudentManagement(int stackSize) {
        this.students = new StudentStack(stackSize);
    }

    // Add
    public void addStudent(Student student) {
        students.push(student);
    }

    // Update
    public void updateStudent(int id, String newName, double newGrade) {
        StudentStack tempStack = new StudentStack(100);
        boolean found = false;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() == id) {
                tempStack.push(new Student(id, newName, newGrade));
                found = true;
            } else {
                tempStack.push(student);
            }
        }

        // Restore original stack
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Delete
    public void deleteStudent(int id) {
        StudentStack tempStack = new StudentStack(100);
        boolean found = false;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() != id) {
                tempStack.push(student);
            } else {
                found = true;
            }
        }

        // Restore stack without deleted students
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Search
    public Student searchStudent(int id) {
        StudentStack tempStack = new StudentStack(100);
        Student foundStudent = null;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() == id) {
                foundStudent = student;
            }
            tempStack.push(student);
        }

        // Restore original stack
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (foundStudent == null) {
            System.out.println("Student with ID " + id + " not found.");
        }
        return foundStudent;
    }

    // Show all students
    public void displayStudents() {
        StudentStack tempStack = new StudentStack(100);

        while (!students.isEmpty()) {
            Student student = students.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        // Restore original stack
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }

    // Sort students by grade
    public void sortStudentsByGrade() {
        StudentStack sortedStack = new StudentStack(100);
        StudentStack tempStack = new StudentStack(100);

        while (!students.isEmpty()) {
            Student current = students.pop();

            // Sort by descending order of score
            while (!sortedStack.isEmpty() && sortedStack.peek().getGrade() > current.getGrade()) {
                tempStack.push(sortedStack.pop());
            }
            sortedStack.push(current);


            while (!tempStack.isEmpty()) {
                sortedStack.push(tempStack.pop());
            }
        }


        students = sortedStack;
    }
}




