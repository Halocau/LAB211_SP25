/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Candidate;
import static entity.Candidate.CandidateType.Experience;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class CandidateManager {

    private ArrayList<Candidate> candidates;
    //id auto increment
    private int lastId;

    public CandidateManager() {
        candidates = new ArrayList<>();
        lastId = 0;
    }

    public CandidateManager(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Candidate addCandidate(Candidate c) {
        //validate id have exist
        c.setId(++lastId);
        candidates.add(c);
        return c;
    }

    public Candidate updateCandidate(int id, Candidate c) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.set(index, c);
        }
        throw new Exception("Id not found");
    }

    public Candidate deleteCandidateById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.remove(id);
        }
        throw new Exception("Candidate not exist");
    }

    private int searchById(int id) {
        for (int index = 0; index < candidates.size(); index++) {
            if (candidates.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public Candidate getCandidateById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.get(index);
        }
        throw new Exception("Id not found");
    }

    @Override
    public String toString() {
        String experience = "\n===========EXPERIENCE CANDIDATE============\n";
        String fresher = "\n==========FRESHER CANDIDATE==============\n";
        String intern = "\n===========INTERN CANDIDATE==============\n";
        for (Candidate c : candidates) {
            switch (c.getType()) {
                case Experience:
                    experience += c.getFistName() + " " + c.getLastName();
                    break;
                case Fresher:
                    fresher += c.getFistName() + " " + c.getLastName();
                    break;
                case Intern:
                    intern += c.getFistName() + " " + c.getLastName();
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return experience + fresher + intern;
    }

//    private HashMap<Integer, Candidate> candidates;
//    //id auto increment
//    private int lastId;
//
//    public CandidateManager() {
//        candidates = new HashMap<>();
//        lastId = 0;
//    }
//
//    public Candidate addCandidate(Candidate c) {
//        //validate id have exist
//        c.setId(++lastId);
//        return candidates.put(lastId, c);
//    }
//
//    public Candidate updateCandidate(Candidate c) {
//        return candidates.replace(c.getId(), c);
//    }
//
//    public Candidate deleteCandidateById(int id) {
//        return candidates.remove(id);
//    }
//
//    public Candidate searchById(int id) {
//        return candidates.get(id);
//    }
}
