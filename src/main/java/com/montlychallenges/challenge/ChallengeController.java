package com.montlychallenges.challenge;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class ChallengeController {
   

    private  ChallengeService challengeService;
     ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

   
@GetMapping("/getChallenges")
 public List<Challenge> getChallenges() {
       return  challengeService.getAllChallenges();
   }
  @PostMapping("/postChallenges")
  public String postChallenges(@RequestBody Challenge challenge) {
      
        boolean res = challengeService.postChallenges(challenge);
        if(res == false) {
            return "Failed to add challenge!";
        }

        return "Challenge added successfully!";

  }
  @GetMapping("/getChallenge/{month}")    
  public Challenge getChallenge(@PathVariable String month) {
      return  challengeService.getChallenge(month);
  }
  
}
