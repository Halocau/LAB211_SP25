/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.TaskInputer;
import bo.TaskManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Task;

/**
 *
 * @author Admin
 */
public class TaskController {

    private TaskInputer taskInputer;
    private TaskManager taskManager;

    public TaskController() {
        taskManager = new TaskManager();
    }

    public Task addTask() {
        taskInputer = new TaskInputer();
        Task t = taskInputer.inputInformation();
        taskManager.addTask(t);
        return t;
    }
    public void displayTask(){
        taskManager.displayTask();
    }

    public Task deleteTask() {
    taskInputer = new TaskInputer();
    int id = taskInputer.deleteInputById();
    try {
        Task deletedTask = taskManager.deleteTask(id);
        System.out.println("Delete successfully: " + deletedTask.getRequirementName());
        return deletedTask;
    } catch (Exception ex) {
        Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }
}

    
}
