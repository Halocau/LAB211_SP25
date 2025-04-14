/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    private final static Scanner sc = new Scanner(System.in);

    public static String inputString(String msg) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine().trim();
            if (input == null || input.isEmpty() || input.length() == 0) {
                System.err.println("input cannot be empty");
                System.out.println("Enter again: ");
                continue;
            }
            return input;
        }
    }

    public static int checkInputIntLimit(String msg, int min, int max) {
        while (true) {
            String inputString = inputString(msg);
            try {

                int number = Integer.parseInt(inputString);
                if (number < min || number > max) {
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.println("Input invalid. Input must be within range [" + min + " -> " + max + "]");
                System.out.println("Enter again: ");
            }
        }
    }

    public static String checkIdExit(String msg, ArrayList<Employee> list) {

        while (true) {
            int flag = 0;
            String input = inputString(msg);
            for (Employee emp : list) {
                if (emp.getId().equals(input)) {
                    System.err.println("This id already exist in the system");
                    System.out.println("Enter again: ");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                continue;
            }
            return input;
        }
    }

    public static String inputStringName(String msg) {
        while (true) {
            String validName = "[a-zA-Z ]+|$";// only contain letter and space
            String input = inputString(msg);
            if (!input.matches(validName)) {
                System.err.println("Please use only letters");
                System.out.println("Enter again: ");
                continue;
            }
            return input;
        }
    }

    public static String inputPhone(String msg) {
        while (true) {
            String validPhone = "[0-9]+|$";
            String input = inputString(msg);
            if (!input.matches(validPhone)) {
                System.err.println("Please use only number");
                System.out.println("Enter again: ");
                continue;
            }
            return input;
        }
    }

    public static String inputEmail(String msg) {
        while (true) {
            String validPhone = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            String input = inputString(msg);
            if (!input.matches(validPhone)) {
                System.err.println("\"Please enter valid email!");
                System.out.println("Enter again: ");
                continue;
            }
            return input;
        }
    }

    public static Date inputDate(String msg) {
        while (true) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            while (true) {
                try {
                    String input = inputString(msg);
                    date = dateFormat.parse(input);
                    return date;
                } catch (ParseException e) {
                    System.err.println("Invalid date format. Please use the format dd/MM/yyyy.");
                    System.out.println("Enter again: ");
                }
            }

        }
    }

    public static Double inputSalary(String msg) {
        while (true) {
            String input = inputString(msg);
            double salary;
            try {
                salary = Double.parseDouble(input);
                if (salary < 0) {
                    throw new NumberFormatException();
                }
                return salary;
            } catch (NumberFormatException e) {
                System.err.println("Please enter an double number!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String inputSex(String msg) {
        while (true) {
            System.out.println(msg);
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. Other");
            int choice = checkInputIntLimit("Your choice", 1, 3);
            if (choice == 1) {
                return "Male";
            } else if (choice == 2) {
                return "Female";
            } else if (choice == 3) {
                return "Other";
            } else {
                System.err.println("Input invalid. Input must be within range [ 1 -> 3]");
                System.out.println("Enter again: ");
                continue;
            }
        }
    }

}
