/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.TaskInputer;
import bo.TaskManager;
import model.Task;
import utils.ValidationAndNormalizationTextUtil;

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
        if (taskManager.addTask(t)) {
            return t;
        }
        return null;
    }

    public Task deleteTask() throws Exception {
        taskManager.checkEmpty();
        int id = ValidationAndNormalizationTextUtil.getInt("ID: ", "Number only!", "Out of range", Integer.MIN_VALUE, Integer.MAX_VALUE);
        return taskManager.deleteTask(id);
    }

    public String getDataTasks() {
        return taskManager.toString();
    }

    public void init(){
        taskManager.initData();
    }
}
