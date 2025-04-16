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
        Code, Test, Design, Review;

        public int getIntType() {
            switch (this) {
                case Code:
                    return 1;
                case Test:
                    return 2;
                case Design:
                    return 3;
                case Review:
                    return 4;
                default:
                    throw new AssertionError();
            }
        }

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
    private int Id;
    private TaskType taskTypeID;
    private String requirementName;
    private Date date;
    private double planForm;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int Id, TaskType taskTypeID, String requirementName, Date date, double planForm, double planTo, String assignee, String reviewer) {
        this.Id = Id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planForm = planForm;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public TaskType getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(TaskType taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanForm() {
        return planForm;
    }

    public void setPlanForm(double planForm) {
        this.planForm = planForm;
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
        double time = getPlanTo() - getPlanForm();
        return String.format("%-5d %-15s %-15s %-15s %-10.1f %-10s %-10s",
                Id,
                requirementName,
                taskTypeID,
                formatDate,
                time,
                assignee,
                reviewer);
    }
}
