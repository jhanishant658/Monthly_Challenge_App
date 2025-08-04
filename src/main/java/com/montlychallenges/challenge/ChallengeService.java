package com.montlychallenges.challenge;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
    @Autowired
     ChallengeRepository challengeRepository;
   
  

    
      public List<Challenge> getAllChallenges() {

        return challengeRepository.findAll();
    }
   public boolean postChallenges(Challenge challenge) {
    if (challenge == null) return false;
    challengeRepository.save(challenge);
    return true;
}
    public List<Challenge>getChallenge(String month) {
        return challengeRepository.findByMonth(month);
    }


    public String updateChallenge(Long id, Challenge challenge) {
         if(challengeRepository.findById(id).isPresent()) {
            Challenge existingChallenge = challengeRepository.findById(id).get();
            existingChallenge.setMonth(challenge.getMonth());
            existingChallenge.setDescription(challenge.getDescription());
            challengeRepository.save(existingChallenge);
            return "Challenge updated successfully!";
        }
        return "Challenge not found!";
    }


    public boolean deleteChallenge(long id) {
        if(!challengeRepository.existsById(id)) {
            return false; // Challenge not found
        }
           challengeRepository.deleteById(id);
        return true; // Challenge deleted successfully
    }
}
