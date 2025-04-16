/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Candidate {

    //enum: là 1 collection giống class nhưng mà trong đấy có các giá trị mặc định.
    //Kiểu dữ liệu này chỉ có thể nhận được 1 trong số giá trị này thôi (1 mảng tĩnh)
    //trong enum thì cái đầu tiên có giá trị là 0
    public enum CandidateType {
        Experience, Intern, Fresher;

        //0         1           2
        public int getIntValue() {
            switch (this) {
                case Experience:
                    return 0;
                case Intern:
                    return 1;
                case Fresher:
                    return 2;
                default:
                    throw new AssertionError();
            }
        }
    }
    private int id;
    private String fistName;
    private String lastName;
    private int yob;//Birth Date
    private String address;
    private String phone;
    private String email;
    private CandidateType type;

    public Candidate(int id, String fistName, String lastName, int yob, String address, String phone, String email, CandidateType type) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.yob = yob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public Candidate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) throws Exception {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (yob < 1900 || yob > currentYear) {
            throw new Exception("YOB Out Of Range");
        }
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CandidateType getType() {
        return type;
    }

    public void setType(CandidateType type) {
        this.type = type;
    }

}
