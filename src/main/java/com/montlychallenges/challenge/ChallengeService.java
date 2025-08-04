package com.montlychallenges.challenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
    private List<Challenge> challenges;
    private int nextid;
    ChallengeService() {
        this.challenges = new ArrayList<>();
        this.nextid = 1;
    }
   
 
      public List<Challenge> getAllChallenges() {

        return challenges;
    }
    public Boolean postChallenges( Challenge challenge) {
        if(challenge==null) return false ; 
        challenge.setId(nextid++);
        challenges.add(challenge);
        return true;

  }
    public Challenge getChallenge(String month) {
        if(challenges.isEmpty()) return null;
        for(Challenge challenge : challenges) {
            if(challenge.getMonth().equals(month)) {
                return challenge;
            }
        }
       return null;
    }


    public String updateChallenge(Long id, Challenge challenge) {
        for (Challenge existingChallenge : challenges) {
            if (existingChallenge.getId() == id) {
                existingChallenge.setMonth(challenge.getMonth());
                existingChallenge.setDescription(challenge.getDescription());
                return "Challenge updated successfully!";
            }
        }
        return "Challenge not found!";
    }


    public boolean deleteChallenge(long id) {
        for (Challenge challenge : challenges) {
            if (challenge.getId() == id) {
                challenges.remove(challenge);
                return true; // Challenge found and removed
            }
        }
        return false; // Challenge not found
    }
}
