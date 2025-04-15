/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import constant.Constant;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Task {

    private static int auto_Increment = 1;
    private int Id;
    private int taskTypeID;
    private String requirementName;
    private Date date;
    private double planForm;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task( int taskTypeID, String requirementName, Date date, double planForm, double planTo, String assignee, String reviewer) {
        this.Id = auto_Increment++;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planForm = planForm;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public Task() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
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

    public String getTaskTypeString(int taskTypeId) {
        String result = null;
        switch (taskTypeId) {
            case Constant.TASK_TYPE_CODE:
                result = "Code";
                break;
            case Constant.TASK_TYPE_TEST:
                result = "Test";
                break;
            case Constant.TASK_TYPE_DESIGN:
                result = "Desing";
                break;
            case Constant.TASK_TYPE_REVIEW:
                result = "Review";
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s",
                Id,
                requirementName,
                getTaskTypeString(taskTypeID),
                date,
                planForm,
                planTo,
                assignee,
                reviewer);
    }

}
