/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.TaskInputer;
import bo.TaskManager;
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

    public Task addTask() throws Exception {
        taskInputer = new TaskInputer();
        Task t = taskInputer.inputInformation();
        taskManager.addTask(t);
        return t;
    }

    public Task deleteTask() throws Exception {
        taskInputer = new TaskInputer();
        return taskManager.deleteTask(taskInputer.inputId());
    }

    public void getDataTasks() {
        taskManager.showTask();
    }

}
