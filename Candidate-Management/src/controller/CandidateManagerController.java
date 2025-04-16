/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.CandidateInputer;
import bo.CandidateManager;
import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.ArrayList;
import utils.ValidationAndNormalizationTextUtil;

/**
 *
 * @author Admin
 */
public class CandidateManagerController {

    private CandidateInputer candidateInputer;
    private CandidateManager candidateManager;

    public CandidateManagerController() {
        candidateManager = new CandidateManager();
    }

    private Candidate inputCandidate(Candidate.CandidateType type) {
        candidateInputer = new CandidateInputer(type);
        candidateInputer.inputCandidateInformation();
        Candidate c = candidateInputer.getCandidate();
        candidateManager.addCandidate(c);
        return c;
    }

    private Experience addExperienceCandidate() {
        Experience c = (Experience) inputCandidate(Candidate.CandidateType.Experience);
        return c;
    }

    private Fresher addFresherCandidate() {
        Fresher c = (Fresher) inputCandidate(Candidate.CandidateType.Fresher);
        return c;
    }

    private Intern addInternCandidate() {
        Intern c = (Intern) inputCandidate(Candidate.CandidateType.Intern);
        return c;
    }
    // list các thằng vừa đc add
    public CandidateManager addCandidateByOptionMenu(int choice) {
        ArrayList<Candidate> ret = new ArrayList<>();
        do {
            switch (choice) {
                case 1://input experience
                    ret.add(addExperienceCandidate());
                    break;
                case 2://input fresher
                    ret.add(addFresherCandidate());
                    break;
                case 3://input intern
                    ret.add(addInternCandidate());
                    break;
            }
        } while (ValidationAndNormalizationTextUtil.pressYNtoContinue("Do you want to continue (Y/N)"));
        return new CandidateManager(ret);
    }
}
