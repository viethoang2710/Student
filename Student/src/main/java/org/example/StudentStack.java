package org.example;

public class StudentStack {
    private Student[] stack;
    private int top;
    private int maxSize;

    // Constructor
    public StudentStack(int size) {
        this.maxSize = size;
        this.stack = new Student[maxSize];
        this.top = -1; // Stack is empty initially
    }

    // Push method
    public void push(Student student) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push.");
        } else {
            stack[++top] = student;
        }
    }

    // Pop method
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        } else {
            return stack[top--];
        }
    }

    // Peek method
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            return stack[top];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }
}
