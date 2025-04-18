/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TaskController;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Task;
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
                        Task addTask = taskController.addTask();
                        System.out.println("Add Succesfully");
                        System.out.println(addTask);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                break;
                case 2: {
                    try {
                        Task deletedTask = taskController.deleteTask();
                        System.out.println("Delete Succesfully");
                        System.out.println(deletedTask.toString());
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                break;
                case 3:
                    System.out.println(taskController.getDataTasks());
                    break;
                case 4:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

}
