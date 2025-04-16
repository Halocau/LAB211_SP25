/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import utils.ValidationAndNormalizationTextUtil;

/**
 *
 * @author Admin
 */
public class Intern extends Candidate {

    private String majors;
    private int semester;
    private String universityName;

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = ValidationAndNormalizationTextUtil.normalFormStringAfterDot(majors);
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = ValidationAndNormalizationTextUtil.removeUnnecessaryBlank(universityName.toUpperCase());
    }

    

}
