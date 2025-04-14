package View;

import Controller.Manager;
import Model.Student;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class main {

    public static void main(String[] args) {
        Manager manager = new Manager();
         ArrayList<Student> listStudent = new ArrayList<Student>();
         manager.initData(listStudent);
        //loop until user input exit
        while (true) {
            int choice = manager.Menu();
            switch (choice) {
                case 1://Create
                    manager.createStudent(listStudent);
                    break;
                case 2://Find and Sort
                    manager.findAndSort(listStudent);
                    break;
                case 3://Update/Delete
                   manager.updateOrDeleteById(listStudent);
                    break;
                case 4://Report
                    manager.reportStudents(listStudent);
                    break;
                case 5://exit
                   return;
            }

        }
    }
}
