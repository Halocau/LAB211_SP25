/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Report;
import Model.Student;
import java.util.ArrayList;
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

    // init method to initial some date of list student 
    public void initData(ArrayList<Student> listStudent) {
        // khoi tao danh sach hoc sinh
        listStudent.add(new Student("S01", "Phan Ngoc Duc", "Java", 2));
        listStudent.add(new Student("S02", "Phan Ngoc Anh", "Java", 3));
        listStudent.add(new Student("S03", "Tran Ngoc Duc", ".Net", 4));
        listStudent.add(new Student("S04", "Tran Ngoc Duc", ".Net", 4));
        listStudent.add(new Student("S05", "Tran Ngoc Duc", ".Net", 4));
        listStudent.add(new Student("S06", "Tran Ngoc Duc", ".Net", 4));
        listStudent.add(new Student("S07", "Tran Ngoc Duc", ".Net", 4));
        listStudent.add(new Student("S08", "Tran Ngoc Duc", ".Net", 4));
        listStudent.add(new Student("S09", "Tran Ngoc Duc", ".Net", 4));
    }

    public int Menu() {
        System.out.println("");
        System.out.println("WELCOME TO STUDENT MANAGEMENT  \n"
                + "1. Create \n"
                + "2. Find and Sort \n"
                + "3. Update/Delete \n"
                + "4. Report \n"
                + "5. Exit \n");
        int choice = validation.checkInputIntLimit("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program): ", 1, 5);
        return choice;
    }

    public void createStudent(ArrayList<Student> list) {
        while (true) {
            int length = list.size();
            //enter Id
            String id = validation.checkDuplicateId("Enter student id: ", list);
            //enter studentName
            String studentName = validation.inputString("Enter student name: ");
            //enter courseName
            String courseName = validation.checkCourseName("Enter course name: ");
            //enter semester
            int semester = validation.checkInputIntLimit("Enter semester: ", 1, 9);
            //create object student
            Student student = new Student(id, studentName, courseName, semester);
            //add list
            list.add(student);

            // neu so luong hoc sinh lon hon 10 thi hien thi message 
            if (length > 10) {
                if (validation.checkYesNo("Do you want to continue (Y/N) ")) {
                    continue;
                } else {
                    break;
                }
            }// yeu cau nguoi dung nhap den khi so luong lon hon 10 thi thoi 
            else {
                System.out.println("Add Student Success ! Number student in list is " + (length + 1) + " , please input data student till to enough 10 student");
                continue;
            }
        }
    }

    public void findAndSort(ArrayList<Student> list) {
        //check list student empty
        if (list.isEmpty()) {
            System.out.println("the student list empty!");
            return;
        }

        String findStudentName = validation.inputString("Input name to find student by name:");
        ArrayList<Student> listStudentByName = getStudentListByName(list, findStudentName);
        if (listStudentByName.isEmpty()) {
            System.out.println("Student does not exist !!");
            return;
        } else {
            //display list student
            displayListStudent(listStudentByName, "List student sort by name: ");

            //use comparator interface ss
            Comparator c = new Comparator<Student>() {
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
            //sort by name use collection
            Collections.sort(list, c);

            displayListStudent(list, "List student find by name above: ");
        }
    }

    //find
    public ArrayList<Student> getStudentListByName(ArrayList<Student> list, String findStudentName) {
        ArrayList<Student> listStudentByName = new ArrayList<>();

        //access
        for (Student s : list) {
            if (s.getStudentName().contains(findStudentName)) {
                listStudentByName.add(s);
            }
        }
        return listStudentByName;
    }

    public void displayListStudent(ArrayList<Student> listStudentByName, String msg) {
        System.out.println(msg);
        int stt = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "STT", "Student Name", "Semester", "Course Name");
        for (Student s : listStudentByName) {
            System.out.printf("%-10d%-15s%-15d%-15s", stt, s.getStudentName(), s.getSemester(), s.getCourseName());
            System.out.println("");
            stt++;
        }
    }

    public void updateOrDeleteById(ArrayList<Student> list) {
        String findStudentById = validation.inputString("Input a id to find student in list: ");
        //get Student have id to find
        Student findId = searchStudentById(findStudentById, list);

        //id not exist
        if (findId == null) {
            System.out.println("Id does not exist the system");
        } //have exist
        else {
            //user choose update or delete
            boolean option = validation.checkUpdateOrDelete("Do you want Update(D) or Delete(D)");
            if (option) {
                updateStudent(findId, list);
            } else {
                deleteStudent(findId, list);
            }
        }
    }

    public Student searchStudentById(String findStudentById, ArrayList<Student> list) {
        //loop
        for (Student item : list) {
            if (item.getId().equals(findStudentById)) {
                return item;
            }
        }
        return null;
    }

    public void updateStudent(Student findId, ArrayList<Student> list) {
        System.out.println("Data student before update: ");
        findId.printData();
        System.out.println("");

        //enter studentName
        String studentName = validation.inputString("Enter student name: ");
        //enter courseName
        String courseName = validation.checkCourseName("Enter course name: ");
        //enter semester
        int semester = validation.checkInputIntLimit("Enter semester: ", 1, 9);
        //update object student
        findId.setStudentName(studentName);
        findId.setSemester(semester);
        findId.setCourseName(courseName);
        System.out.println("Update successfully");
    }

    public void deleteStudent(Student findId, ArrayList<Student> list) {
        list.remove(findId);
        System.out.println("Delete Successfully");
    }

    //4. display report with totatak cousera of this student
    public void reportStudents(ArrayList<Student> listStudent) {
        ArrayList<Report> listReport = getReportList(listStudent);
        for (Report report : listReport) {
            report.printData();
            System.out.println("");
        }
    }

    public ArrayList<Report> getReportList(ArrayList<Student> listStudent) {
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
        Set keys = reports.keySet();
        for (Object ke : keys) {
            String[] data = ke.toString().split("-");
            String studentName = data[0];
            String courseName = data[1];
            int totalCourse = reports.get(ke);
            Report rep = new Report(studentName, courseName, totalCourse);
            listReport.add(rep);
        }

        return listReport;
    }
}
