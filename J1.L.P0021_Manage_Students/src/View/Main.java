/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Manager;
import Model.Student;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        ArrayList<Student> listStudent = new ArrayList<>();
        manager.initDate(listStudent);
        while (true) {
            int choice = manager.Menu();
            switch (choice) {
                case 1:
                    manager.createStudent(listStudent);
                    break;
                case 2:
                    manager.findAndSort(listStudent);
                    break;
                case 3:
                    manager.updateOrDelete(listStudent);
                    break;
                case 4:
                    manager.report(listStudent);
                    break;
                case 5:
                    return;
            }
        }
    }

    
}
