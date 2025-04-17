/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Task {

    public enum TaskType {
        Code,
        Test,
        Design,
        Review;

        public static TaskType getTypeByInt(int type) {
            switch (type) {
                case 1:
                    return Code;
                case 2:
                    return Test;
                case 3:
                    return Design;
                case 4:
                    return Review;
                default:
                    throw new AssertionError();
            }
        }
    }
    private int id;
    private String requirementName;
    private TaskType taskTypeId;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String requirementName, TaskType taskTypeId, Date date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskTypeId = taskTypeId;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public TaskType getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(TaskType taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formatDate = sdf.format(date);
        double time = planTo - planFrom;
        return String.format("%-5s %-15s %-15s %-15s %-10s %-10s %-12s\n",
                id,
                requirementName,
                taskTypeId,
                formatDate,
                time,
                assignee,
                reviewer);
    }

}
