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

    public void init() {
        taskManager.initData();
    }

    public Task addTask() {
        taskInputer = new TaskInputer();
        Task t = taskInputer.inputInformation();
        boolean overlap = taskManager.isOverlap(t.getDate(), t.getAssignee(), t.getPlanForm(), t.getPlanTo());
        if (overlap) {
            System.err.println("Overlap task");
            return null;
        } else {
            taskManager.addTask(t);
            System.out.println("Add succesfully");
            return t;
        }

    }

    public void displayTask() {
        taskManager.displayTask();
    }

    public Task deleteTask() {
        taskInputer = new TaskInputer();
        int id = taskInputer.deleteInputById();
        try {
            Task deleted = taskManager.deleteTask(id);
            if (deleted != null) {
                System.out.println("Deleted task successfully.");
            }
            return deleted;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            return null;
        }
    }

}
