/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        UiTask uiTask = new UiTask();
        while (true) {
            int choice = UiTask.displayMenu();
            switch (choice) {
                case 1:
                    uiTask.addTask();
                    break;
                case 2:
                    uiTask.deleteTask();
                    break;
                case 3:
                    uiTask.displayTask();
                    break;
                case 4:
                    return;
            }
        }
    }
}
