/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controller.Manager;
import entity.Task;
import java.util.Date;
import utils.Utility;

/**
 *
 * @author Admin
 */
public class UiTask {

    Manager manager = new Manager();

    public static int displayMenu() {
        System.out.println("====== Task program ======\n"
                + "1.      Add Task\n"
                + "2.      Delete Task\n"
                + "3.      Display Task\n"
                + "4.      Exit");
        int option = Utility.getIntegerLimit("Option: ", "Option must be digits", 1, 4);
        return option;
    }

    void addTask() {
        //input information + check valid data
        System.out.println("------------Add Task---------------");
        String requirement = getRequimentName();
        int taskType = getTaskType();
        Date date = getDate();
        double from = getPlanForm();
        double to = getPlanTo(from);
        String assignee = getAssignee();
        String reviewer = getReviewer();
        
        boolean isOverlap = manager.isOverlaps(date, assignee, from, to);
        if (isOverlap) {
            System.err.println("Overlap task");
        } else {
            manager.addTask(requirement, taskType, date, from, to, assignee, reviewer);
            System.out.println("Add successfull !");
        }
        

    }
    
    //3.display task
    void displayTask() {
        for(Task task: manager.getListTask()){
            System.out.println(task);
        }
    }

    //delete task
    void deleteTask() {
        int findIdInput = Utility.getIntegerLimit("Enter id: ", "Id does not exist in the system", 0, Integer.MAX_VALUE);
        Task task = manager.findTaskById(findIdInput);
        if (task == null) {
            System.out.println("Not found task");
        } else {
            manager.remove(task);
            System.out.println("Remove successfully");
        }
    }

    private String getRequimentName() {
        String requirementName = Utility.getStringName("Enter requirement name: ", "Requirement name must be letters or digits", "[a-zA-Z0-9 ]+");
        return requirementName;
    }

    private int getTaskType() {
        int taskType = Utility.getIntegerLimit("Enter task type: ", "It must be digits range 1 -> 4", 1, 4);
        return taskType;
    }

    private Date getDate() {
        Date date = Utility.inputDateWithFormat("Input fist date:", "Input must be in format dd-MM-yyyy", "\\d{1,2}[-]\\d{1,2}[-]\\d{1,4}");
        return date;
    }

    private String getReviewer() {
        String reviewer = Utility.getStringName("Enter reviewer: ", "Wrong", "[a-zA-Z0-9 ]+");
        return reviewer;
    }

    private String getAssignee() {
        String assignee = Utility.getStringName("Enter assignee: ", "Wrong", "[a-zA-Z0-9 ]+");
        return assignee;
    }

    private double getPlanTo(Double from) {
        double planTo = Utility.getDouble("Enter to plan: ", "Wrong", from + 0.5, 17.5);
        return planTo;
    }

    private double getPlanForm() {
        double fromTo = Utility.getDouble("Enter to from: ", "Wrong", 8, 17);
        return fromTo;
    }
}
