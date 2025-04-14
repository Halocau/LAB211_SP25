/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Student {
    private String id, studentName, courseName;
    private int semester;

    public Student(String id, String studentName, String courseName, int semester) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.semester = semester;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", studentName=" + studentName + ", courseName=" + courseName + ", semester=" + semester + '}';
    }
    
    public void printData(){
        System.out.printf("%-15s-10s-10s-15d",this.studentName,this.courseName,this.semester);
    }
}
