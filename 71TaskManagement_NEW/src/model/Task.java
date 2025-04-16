/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
        return String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s",
                Id,
                requirementName,
                taskTypeID,
                date,
                planForm,
                planTo,
                assignee,
                reviewer);
    }

}
