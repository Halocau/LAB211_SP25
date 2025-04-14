/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    //Ensure input is not null and empty
    public String inputStringValid(String msg) {
        while (true) {
            System.out.println(msg);
            String inputRaw = sc.nextLine();
            if (inputRaw == null || inputRaw.length() == 0) {
                System.err.println("Input cannot be null or empty !!!");
                System.out.print("Enter again: ");
                continue;
            }

            return inputRaw;
        }
    }

    //Check input have valid 
    public int checkLimitInt(String msg, int min, int max) {
        while (true) {
            String inputString = inputStringValid(msg);
            try {
                int inputChoice = Integer.parseInt(inputString);
                if (inputChoice < min || inputChoice > max) {
                    throw new NumberFormatException();
                }
                return inputChoice;
            } catch (NumberFormatException e) {
                System.err.println("Input invalid. Input must be within range [" + min + "->" + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check id exist
    public String inputIdValid(String msg, ArrayList<Student> listStudent) {
        //check duplicate
        while (true) {
            int flag = 0;
            String inputId = inputStringValid(msg);
            for (Student item : listStudent) {
                //Test input id exist
                if (item.getId().equals(inputId)) {
                    System.err.println("Input must does not exist");
                    System.out.print("Enter again: ");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                continue;
            }
            return inputId;
        }
    }

    public String inputSemesterValid(String msg) {
        while (true) {
            String input = inputStringValid(msg);
            if (!input.equalsIgnoreCase("Java")
                    || input.equals(".Net")
                    || input.equals("C/C++")) {
                System.err.println("Course name must be one in three course below: Java, .Net, C/C++");
                System.out.print("Enter again: ");
                continue;
            }
            return input;
        }
    }

    public boolean checkYesNo(String msg) {
        while (true) {
            String input = inputStringValid(msg);
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Input must Y or N");
                System.out.println("Enter again:");
                continue;
            }
        }
    }

    public boolean checkUpdateOrDelete(String msg) {
        while (true) {
            String input = inputStringValid(msg);
            if (input.equalsIgnoreCase("U")) {
                return true;
            } else if (input.equalsIgnoreCase("D")) {
                return false;
            } else {
                System.out.println("Input must U or D");
                System.out.println("Enter again:");
                continue;
            }
        }
    }

}
