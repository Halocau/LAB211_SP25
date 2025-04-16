/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import model.Task;
import utils.ValidationAndNormalizationTextUtil;

/**
 *
 * @author Admin
 */
public class TaskInputer {

    private Task task;

    public TaskInputer() {
        task = new Task();
    }

    public Task inputInformation() {
        ValidationAndNormalizationTextUtil valid = new ValidationAndNormalizationTextUtil();
        task.setRequirementName(valid.getStringByRegex("Requiment Name: ", "Please enter character only!", "[a-zA-Z ]+"));

        //task type
        int type = valid.getInt("Task type: ", "Number only!", "Out of range", 1, 4);
        task.setTaskTypeID(Task.TaskType.getTypeByInt(type));

        task.setDate(valid.getDate("Date: ", "Please input must be in format dd-MM-yyyy", "\\d{1,2}[-]\\d{1,2}[-]\\d{1,4}"));
        task.setPlanForm(valid.getDouble("From: ", "Number only!", "Out of range 8 -> 17", 8, 17));
        task.setPlanTo(valid.getDouble("To: ", "Number only!", "Out of range 8 -> 17", (task.getPlanForm() + 0.5), 17.5));
        task.setAssignee(valid.getStringByRegex("Assignee: ", "Please enter character only!", "[a-zA-Z ]+"));
        task.setReviewer(valid.getStringByRegex("Reviewer: ", "Please enter character only!", "[a-zA-Z ]+"));
        return task;
    }

    public int deleteInputById() {
        return ValidationAndNormalizationTextUtil.getInt("ID: ", "Number only!", "Out of range", 0, Integer.MAX_VALUE);
    }
}
