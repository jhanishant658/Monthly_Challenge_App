package com.montlychallenges.challenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
    
      private List<Challenge> challenges = new ArrayList<>(); 
      private long nextid = 1L;
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
}
