/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Student;
import com.sun.source.tree.ContinueTree;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    private final static Scanner sc = new Scanner(System.in);

    //check valid input Menu()
    public static int checkInputIntLimit(String msg, int min, int max) {
        //loop until user input correct
        while (true) {
            // allow user input a string 
            String inputRaw = inputString(msg);
            try {
                int result = Integer.parseInt(inputRaw);
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + "," + max + "]");
                System.out.println("Enter again: ");
            }
        }
    }

    //check valid input String msg
    public static String inputString(String msg) {
        //loop until user input correct
        while (true) {
            System.out.println(msg);
            String inputRaw = sc.nextLine();
            //input == null || length > 0
            if (inputRaw == null || inputRaw.length() == 0) {
                //error
                System.err.println("Must input a string not empty");
                System.out.println("Enter again:");
                continue;
            }
            return inputRaw;
        }
    }

    //check vaild input Id
    public static String checkDuplicateId(String msg, ArrayList<Student> list) {
        //loop until user input correct
        while (true) {
            //enter id check
            String id = inputString(msg);

            //
            int flag = 0;

            //loop use check duplicate id
            for (Student item : list) {
                if (item.getId().equals(id)) {
                    System.err.println("Id existed !Please enter again");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                continue;
            }
            return id;
        }
    }

    //check yes no
    public static boolean checkYesNo(String msg) {
        while (true) {
            String input = inputString(msg);
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Must input Y or N to select option");
                continue;
            }
        }
    }

    //check course name
    public static String checkCourseName(String msg) {
        while (true) {
            String courseName = inputString(msg);
            if (!courseName.equals("Java") || courseName.equals(".Net") || courseName.equals("C/C++")) {
                System.err.println("Course name must be one in three course below: Java, .Net, C/C++");
                continue;
            }
            return courseName;
        }
    }

    public boolean checkUpdateOrDelete(String msg) {
        while (true) {       
            String input = inputString(msg);
            if(input.equalsIgnoreCase("U")){
                return true;
            }else if(input.equalsIgnoreCase("D")){
                return false;
            }else{
                System.err.println("Must input U or D to select option");
                continue;
            }
        }
    }

  
}
