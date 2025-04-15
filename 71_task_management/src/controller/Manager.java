/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Task;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Manager {

    ArrayList<Task> listTask = new ArrayList<>();
    //ham de kiem tra xem tat ca cac thuoc tinh nhap vao co ko bi overlaps ko
    // => true => bi overlaps
    // => false => ko bi overlaps

    public boolean isOverlaps(Date date, String assignee, double from, double to) {
        for (Task task : listTask) {
            if (task.getDate().equals(date) && task.getAssignee().compareTo(assignee) == 0) {
                if (from < task.getPlanForm() && to > task.getPlanForm()) {
                    return true;
                }
                if (from == task.getPlanForm()) {
                    return true;
                }
                if (from > task.getPlanForm()
                        && from < task.getPlanTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param requirement
     * @param taskType
     * @param date
     * @param from
     * @param to
     * @param assignee
     * @param reviewer
     */
    public void addTask(String requirementName, int taskType, Date date, double from, double to, String assignee, String reviewer) {
        Task task = new Task(taskType, requirementName, date, from, to, assignee, reviewer);
        listTask.add(task);
    }

    public Task findTaskById(int findIdInput) {
        for (Task task : listTask) {
            if (task.getId() == findIdInput) {
                return task;
            }
        }
        return null;
    }

    public void remove(Task task) {
        listTask.remove(task);
    }

    public ArrayList<Task> getListTask() {
        return listTask;
    }

}
