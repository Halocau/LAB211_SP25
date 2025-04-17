/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TaskController;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ValidationAndNormalizationTextUtil;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        String menu = ("====== Task program =====\n"
                + "1. Add Task\n"
                + "2. Delete Task\n"
                + "3. Display Task\n"
                + "4. Exit\n"
                + "Your choice: ");
        int choice = ValidationAndNormalizationTextUtil.getInt(menu, "Must only!", "Out of range", 1, 4);
        switch (choice) {
            case 1: {
                try {
                    taskController.addTask();
                    System.out.println("\nAdd Succesfully");
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
            break;

            case 2: {
                try {
                    taskController.deleteTask();
                    System.out.println("\nDelete Succesfully");
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
            break;

            case 3:
                taskController.getDataTasks();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                throw new AssertionError();
        }
    }

}
