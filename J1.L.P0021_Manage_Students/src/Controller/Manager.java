/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Report;
import Model.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class Manager {

    Validation validation = new Validation();

    public void initDate(ArrayList<Student> listStudent) {
        listStudent.add(new Student("s01", "quat", ".Net", 1));
        listStudent.add(new Student("s02", "quat1", ".Net", 1));
        listStudent.add(new Student("s03", "quat2", ".Net", 1));
        listStudent.add(new Student("s04", "quat3", ".Net", 1));
        listStudent.add(new Student("s05", "taka1", ".Net", 1));
        listStudent.add(new Student("s06", "taka14", ".Net", 1));
        listStudent.add(new Student("s07", "taka13", ".Net", 1));
        listStudent.add(new Student("s08", "taka12", ".Net", 1));
        listStudent.add(new Student("s09", "taka11", ".Net", 1));

    }

    public int Menu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update and Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("");
        int choice = validation.checkLimitInt("Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program", 1, 5);
        return choice;
    }

    //Create student
    public void createStudent(ArrayList<Student> listStudent) {
        while (true) {
            //input infomation student
            //enter Id
            String idStudent = validation.inputIdValid("Enter student id: ", listStudent);
            //enter studentName
            String studentName = validation.inputStringValid("Enter student name: ");
            //enter courseName (Java, .Net)
            String courseName = validation.inputSemesterValid("Enter course name: ");
            //enter semester (1->9)
            int semester = validation.checkLimitInt("Enter semester: ", 1, 9);

            //Object student
            Student student = new Student(idStudent, studentName, courseName, semester);
            listStudent.add(student);
            if (listStudent.size() > 10) {
                if (validation.checkYesNo(" Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.")) {
                    continue;
                } else {
                    break;
                }
            } else {
                System.out.println("The current student list is" + listStudent.size() + ".You must enter at least 10 students");
                continue;
            }
        }
    }

    //2.Find student by name and sort student by collection
    public void findAndSort(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("Current list student empty");
            return;
        }
        //find student
        String studentName = validation.inputStringValid("Input student by name you want to find: ");
        ArrayList<Student> findStudentName = findStudentByName(studentName, listStudent);
        //check
        if (findStudentName.isEmpty()) {
            System.out.println("Student name not found !!!");
            return;
        } else {
            //display after find student by name
            displayListStudent(findStudentName, "List students after find: ");
            //sort student by name
            Comparator<Student> compare = new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int ss = o1.getStudentName().compareTo(o2.getStudentName());
                    if (ss > 0) {
                        return 1;
                    } else if (ss < 0) {
                        return -1;
                    }
                    return 0;
                }
            };
            Collections.sort(listStudent, compare);

            //display student after sort
            displayListStudent(listStudent, "List students after sort: ");
        }

    }

    public ArrayList<Student> findStudentByName(String studentName, ArrayList<Student> listStudent) {
        ArrayList<Student> findListStudent = new ArrayList<>();
        for (Student find : listStudent) {
            if (find.getStudentName().contains(studentName)) {
                findListStudent.add(find);
            }
        }
        return findListStudent;
    }

    public void displayListStudent(ArrayList<Student> listStudent, String msg) {
        System.out.println(msg);
        //%s: String
        //%d: int
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Id", "Student Name", "Course Name", "Semester");

        for (Student s : listStudent) {
            System.out.printf("%-10s%-15s%-15s%-15d",
                    s.getId(),
                    s.getStudentName(),
                    s.getCourseName(),
                    s.getSemester());
            System.out.println("");
        }
    }

    //3. Update or Delete a student
    public void updateOrDelete(ArrayList<Student> listStudent) {

        String idStudent = validation.inputStringValid("Enter student id input: ");
        Student searchStudent = searchStudentById(idStudent, listStudent);
        if (searchStudent == null) {
            System.out.println("Student not found.");
            return;
        } else {
            boolean option = validation.checkUpdateOrDelete("Do you want to update (U) or delete (D) student: ");
            if (option) {
                updateStudent(searchStudent);
            } else {
                deleteStudent(searchStudent, listStudent);
            }
        }
    }

    public Student searchStudentById(String idStudent, ArrayList<Student> listStudent) {
        for (Student s : listStudent) {
            if (s.getId().equals(idStudent)) {
                return s;
            }
        }
        return null;
    }

    public void updateStudent(Student searchStudent) {
        System.out.println("Information student before update: ");
        System.out.printf("%-10s%-15s%-15s%-15d\n",
                searchStudent.getId(),
                searchStudent.getStudentName(),
                searchStudent.getCourseName(),
                searchStudent.getSemester());

        System.out.println("");
        //input infomation student

        //enter studentName
        String studentName = validation.inputStringValid("Enter student name: ");
        //enter courseName (Java, .Net)
        String courseName = validation.inputSemesterValid("Enter course name: ");
        //enter semester (1->9)
        int semester = validation.checkLimitInt("Enter semester: ", 1, 9);

        searchStudent.setStudentName(studentName);
        searchStudent.setCourseName(courseName);
        searchStudent.setSemester(semester);
        System.out.println("Update Succesfully");
        System.out.println("Information student After update: ");
        System.out.printf("%-10s%-15s%-15s%-15d\n",
                searchStudent.getId(),
                searchStudent.getStudentName(),
                searchStudent.getCourseName(),
                searchStudent.getSemester());
        System.out.println("");
    }

    public void deleteStudent(Student searchStudent, ArrayList<Student> listStudent) {
        listStudent.remove(searchStudent);
        System.out.println("Delete succesfully");
    }

    public void report(ArrayList<Student> listStudent) {
        ArrayList<Report> reports = getReportStudent(listStudent);
        for(Report report: reports){
            report.printData();
            System.out.println("");
        }
    }

    public ArrayList<Report> getReportStudent(ArrayList<Student> listStudent) {
        ArrayList<Report> listReport = new ArrayList<>();
        HashMap<String, Integer> reports = new HashMap<>();
        for (Student s : listStudent) {
            String key = s.getStudentName() + "-" + s.getCourseName();
            if (reports.containsKey(key)) {
                int oldTotal = reports.get(key);
                reports.put(key, oldTotal + 1);
            } else {
                reports.put(key, 1);
            }
        }
        //lọc ra trùng
        Set keys = reports.keySet();
        for (Object obj : keys) {
            String[] data = obj.toString().split("-");
            String studentName = data[0];
            String courseName = data[1];
            int totalCourseName = reports.get(obj);
            Report report = new Report(studentName, courseName, totalCourseName);
            listReport.add(report);
        }
        return listReport;
    }

}
