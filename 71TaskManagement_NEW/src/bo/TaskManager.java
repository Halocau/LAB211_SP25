/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public void initData() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse("13-09-2003");
            listTask.add(new Task(99, Task.TaskType.Code, "hia", date, 9.0, 17.5, "dev", "lead"));
            listTask.add(new Task(100, Task.TaskType.Design, "hi2", date, 9.5, 17.0, "dev", "lead"));
            listTask.add(new Task(101, Task.TaskType.Test, "hi1", date, 8.0, 17.0, "dev", "lead"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Task addTask(Task t) {
        t.setId(++lastId);
        listTask.add(t);
        return t;
    }

//    public Task deleteTask(int id) {
//        if (listTask.isEmpty()) {
//            System.err.println("Task list is empty!");
//            return null;
//        }
//
//        int index = searchById(id);
//        if (index != -1) {
//            return listTask.remove(index);
//        } else {
//            System.err.println("Task with ID " + id + " not found.");
//            return null;
//        }
//    }
    public Task deleteTask(int id) throws Exception {
        if (listTask.isEmpty()) {
            throw new Exception("Task list is empty!");
        }

        int index = searchById(id);
        if (index != -1) {
            return listTask.remove(index);
        } else {
            throw new Exception("Task with ID " + id + " not found.");
        }
    }

    public void displayTask() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-15s %-15s %-10s %-10s %-10s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : listTask) {
            System.out.println(task);
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

    public boolean isOverlap(Date date, String assignee, double from, double to) {
        for (Task task : listTask) {
            if (task.getDate().equals(date) && task.getAssignee().equalsIgnoreCase(assignee)) {
                double existForm = task.getPlanForm();
                double existTo = task.getPlanTo();
                //intersect
                if (!(to <= existForm || from >= existTo)) {
                    return true;
                }
            }
        }
        return false;
    }
}
