package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<Student>();

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {return name;}

    public int getAge() {
        return age;
    }

    private String name;
    private int age;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {return students;}

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averGrade) {
        for (Student student : students) {
            if (student.getAverageGrade() == averGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        int max = 0;
        for (int i = 1; i < students.size(); i++)
            if (students.get(max).getAverageGrade() < students.get(i).getAverageGrade())
                max = i;
        return students.size() == 0 ? null : students.get(max);

        //TODO:
    }

    public Student getStudentWithMinAverageGrade() {
        double avergrade = students.get(0).getAverageGrade();
        int min = 0;
        for (int i = 1; i < students.size(); i++)
            if (avergrade > students.get(i).getAverageGrade()) {
                avergrade = students.get(i).getAverageGrade();
                min = i;
            }
        return students.get(min);
    }
    public void expel(Student student) {
        students.remove(student);
    }
}