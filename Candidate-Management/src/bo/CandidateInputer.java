/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Candidate;
import static entity.Candidate.CandidateType.Experience;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.time.LocalDateTime;
import utils.ValidationAndNormalizationTextUtil;

/**
 * Enter validate data input
 *
 * @author Admin
 */
public class CandidateInputer {

    private Candidate c;

    public Candidate getCandidate() {
        return c;
    }

    // khi nào gọi hàm tạo thì mới new mới 1 hàm candidate
    public CandidateInputer(Candidate.CandidateType type) {
        // c = new Candidate();
        switch (type) {
            case Experience:
                c = new Experience();
                break;
            case Fresher:
                c = new Fresher();
                break;
            case Intern:
                c = new Intern();
                break;
            default:
                throw new AssertionError();
        }
        c.setType(type);
    }

    private void inputCommonInformation() {
        c.setFistName(ValidationAndNormalizationTextUtil.getStringByRegex("Enter fist name: ",
                "Please enter character only!", "[a-zA-Z ]+"));
        c.setLastName(ValidationAndNormalizationTextUtil.getStringByRegex("Enter last name: ",
                "Please enter character only!", "[a-zA-Z ]+"));
        try {
            c.setYob(ValidationAndNormalizationTextUtil.getInt("Enter Birth Date: ", "Input number only!",
                    "It must be >= 1900 and <= " + LocalDateTime.now().getYear(), 1900, LocalDateTime.now().getYear()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        c.setAddress(ValidationAndNormalizationTextUtil.getNonEmptyString("Enter address: "));
        c.setPhone(ValidationAndNormalizationTextUtil.getPhone(10, "Enter phone"));
        c.setEmail(ValidationAndNormalizationTextUtil.getEmail("Enter email: "));
    }

    // enter type private
    private void inputFresherInformation() {
        inputCommonInformation();
        // Graduation date
        ((Fresher) c).setGraduationDate(ValidationAndNormalizationTextUtil.getInt("Enter graduation date: ",
                "Number only!", "Out of range", 1900, Integer.MAX_VALUE));

        // education
        ((Fresher) c).setEducation(ValidationAndNormalizationTextUtil.getNonEmptyString("Enter university name: "));

        // graduation rank
        int rank = ValidationAndNormalizationTextUtil.getInt("Enter rank (1- Excellence, 2- Good,3- Fair, 4- Poor):",
                "Input number only!", "Must be range 1 to 4", 1, 4);
        ((Fresher) c).setGraduationRank(Fresher.GraduationRank.getTypeByInt(rank));
    }

    private void inputExperienceInformation() {
        inputCommonInformation();
        while (true) {
            // exprienceYear
            try {
                ((Experience) c).setExpInYear(ValidationAndNormalizationTextUtil.getInt("Enter exprience year: ",
                        "Number only!", "Out of Range", 0, 100));
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            // proSkill
            ((Experience) c).setProSkill(ValidationAndNormalizationTextUtil.getNonEmptyString("Enter pro skill: "));
        }
    }

    private void inputInternInformation() {
        inputCommonInformation();
        ((Intern) c).setMajors(ValidationAndNormalizationTextUtil.getNonEmptyString("Enter major: "));
        ((Intern) c).setSemester(
                ValidationAndNormalizationTextUtil.getInt("Enter semester: ", "Number only!", "Out of Range", 1, 20));
        ((Intern) c).setUniversityName(ValidationAndNormalizationTextUtil.getNonEmptyString("Enter university: "));
    }

    public Candidate inputCandidateInformation() {
        switch (c.getType()) {
            case Experience:
                inputExperienceInformation();
                break;
            case Fresher:
                inputFresherInformation();
                break;
            case Intern:
                inputInternInformation();
                break;
            default:
                throw new AssertionError();
        }
        return c;
    }
}
