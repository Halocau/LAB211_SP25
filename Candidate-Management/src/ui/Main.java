/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import bo.CandidateManager;
import controller.CandidateManagerController;
import entity.Candidate;
import utils.ValidationAndNormalizationTextUtil;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        CandidateManagerController candidateManagerController = new CandidateManagerController();
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        String menu = ("1. Experience\n"
                + "2. Fresher\n"
                + "3. Internship\n"
                + "4. Searching\n"
                + "5. Exit\n"
                + "(Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program).\n"
                + "Your choice: ");
        int choice = ValidationAndNormalizationTextUtil.getInt(menu, "Must input an integer number!", "Must input an integer in range 1 -> 5", 1, 5);
        switch (choice) {
            case 1:
            case 2:
            case 3:
                CandidateManager cmng = candidateManagerController.addCandidateByOptionMenu(choice);
                System.out.println("List of candidate ");
                System.out.println(cmng);
                break;
            case 4:

                break;
            case 5:

                break;
            default:
                throw new AssertionError();
        }
    }
}
