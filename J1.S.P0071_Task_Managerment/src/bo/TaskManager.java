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

    public void initData() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse("13-09-2003");
            listTask.add(new Task(99, "hia", Task.TaskType.Code, date, 9.0, 17.5, "dev", "lead"));
            listTask.add(new Task(100, "hia", Task.TaskType.Design, date, 9.5, 17.0, "dev", "lead"));
            listTask.add(new Task(101, "hia", Task.TaskType.Test, date, 8.0, 17.0, "dev", "lead"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addTask(Task t) throws Exception {
        if (isOverlap(t.getDate(), t.getAssignee(), t.getPlanFrom(), t.getPlanTo())) {
            throw new Exception("Task is overlapping with existing task");
        }
        if (checkFromAndTo(t.getPlanFrom(), t.getPlanTo())) {
            throw new Exception("Task invalid. Task must planFrom < planTo");
        }
        t.setId(++lastId);//tức là tăng trước rồi gán
        return listTask.add(t);
    }

    public Task deleteTask(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listTask.remove(index);
        }
        throw new Exception("Id not exist in the system");
    }

    public void checkEmpty() throws Exception {
        if (listTask.isEmpty()) {
            throw new Exception("List task empty !!");
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String display = String.format("%-5s %-15s %-15s %-15s %-10s %-10s %-12s\n",
                "ID", "Name", "TaskType", "Date", "Time", "Assignee", "Reviewer");
        for (Task t : listTask) {
            String formatDate = sdf.format(t.getDate());
            double time = t.getPlanTo() - t.getPlanFrom();
            display += String.format("%-5s %-15s %-15s %-15s %-10s %-10s %-12s\n",
                    t.getId(),
                    t.getRequirementName(),
                    t.getTaskTypeId(),
                    formatDate,
                    time,
                    t.getAssignee(),
                    t.getReviewer());
        }
        return display;
    }

    private int searchById(int id) {
        for (int index = 0; index < listTask.size(); index++) {
            if (listTask.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    private boolean isOverlap(Date date, String assignee, double from, double to) {
        for (Task task : listTask) {
            if (task.getDate().equals(date) && task.getAssignee().equalsIgnoreCase(assignee)) {
                double existFrom = task.getPlanFrom();
                double existTo = task.getPlanTo();
                if (from < existTo && to > existFrom) {
                    return true; // duplicate
                }
            }
        }
        return false;// no duplicate
    }

    private boolean checkFromAndTo(double from, double to) {
        return from >= to ? true : false;
    }
}
