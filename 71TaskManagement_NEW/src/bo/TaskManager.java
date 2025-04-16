/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Task;

/**
 *
 * @author Admin
 */
public class TaskManager {

    private ArrayList<Task> listTask;
    private int lastId;

    public TaskManager() {
        listTask = new ArrayList<>();
        lastId = 0;
    }

    public TaskManager(ArrayList<Task> listTask) {
        this.listTask = listTask;
    }

    public Task addTask(Task t) {
        t.setId(++lastId);
        listTask.add(t);
        return t;
    }

    public Task deleteTask(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
           return listTask.remove(index);
        }
        throw new Exception("Task not exist");
    }

    public void displayTask() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-15s %-15s %-10s %-10s %-10s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : listTask) {
            String formatDate = sdf.format(task.getDate());
            System.out.printf("%-5d %-15s %-15s %-15s %-10.1f %-10s %-10s\n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskTypeID(),
                    formatDate,
                    task.getPlanForm(),
                    task.getAssignee(),
                    task.getReviewer());
        }
    }

    private int searchById(int id) {
        for (int index = 0; index < listTask.size(); index++) {
            if (listTask.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }
}
