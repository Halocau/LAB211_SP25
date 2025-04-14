/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Manager;
import Model.Employee;
import java.util.ArrayList;

/**
 *
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.initData();
        while (true) {
            //1.display menu and enter selection
            int choice = manager.displayMenu();
            //2. based on input select go to function
            switch (choice) {
                case 1:
                    Manager.addEmployee();
                    break;
                case 2:
                    Manager.updateEmployee();
                    break;
                case 3:
                    Manager.removeEmployee();
                    break;
                case 4:
                    Manager.searchEmployee();
                    break;
                case 5:
                    Manager.sortEmployeeBySalary();
                    break;
                case 6://exit
                    return;
            }
        }

    }

}
