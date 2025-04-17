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

    private Task t;

    public TaskInputer() {
        t = new Task();
    }

    public Task inputInformation() {
        ValidationAndNormalizationTextUtil valid = new ValidationAndNormalizationTextUtil();
        t.setRequirementName(valid.getStringByRegex("Requirement Name: ", "Please enter character only!", "[a-zA-z ]+"));

        //task type
//        int type = valid.
        int type = ValidationAndNormalizationTextUtil.getInt("Task Type: ", "Number only!", "Out of range", Integer.MIN_VALUE, Integer.MAX_VALUE);
        t.setTaskTypeId(Task.TaskType.getTypeByInt(type));

        t.setDate(valid.getDate("Date: ", "Please ener date format dd-MM-yyyy", "\\d{1,2}[-]\\d{1,2}[-]\\d{1,4}"));
        t.setPlanFrom(valid.getDouble("From: ", "Number only!", "Out of range", 8, 17));
        t.setPlanTo(valid.getDouble("To: ", "Number only!", "Out of range", t.getPlanFrom() + 0.5, 17.5));
        t.setAssignee(valid.getNonEmptyString("Assignee: "));
        t.setReviewer(valid.getNonEmptyString("Reviewer: "));
        return t;
    }

    public int inputId() {
        int id = ValidationAndNormalizationTextUtil.getInt("ID: ", "Number only!", "Out of range", Integer.MIN_VALUE, Integer.MAX_VALUE);
        return id;
    }
}
