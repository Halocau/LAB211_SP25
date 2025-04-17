/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TaskController;
import utils.ValidationAndNormalizationTextUtil;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        taskController.init();
        while (true) {
            System.out.println("");
            String menu = ("====== Task program ======\n"
                    + "1.      Add Task\n"
                    + "2.      Delete Task\n"
                    + "3.      Display Task\n"
                    + "4.      Exit\n"
                    + "Your choice: ");
            int choice = ValidationAndNormalizationTextUtil.getInt(menu, "Must input an integer number!", "Must input an integer in range 1 -> 4", 1, 4);
            switch (choice) {
                case 1:
                    taskController.addTask();
                    break;
                case 2: 
                    taskController.deleteTask();
                    break;
                case 3:
                    taskController.displayTask();
                    break;
                case 4:
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        }
    }
}
