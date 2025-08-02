package com.montlychallenges.challenge;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ChallengeController {
   private List<Challenge> challenges = new ArrayList<>(); 

  
   
@GetMapping("/getChallenges")
 public List<Challenge> getChallenges() {
       return challenges;
   }
  @PostMapping("/postChallenges")
  public String postChallenges(@RequestBody Challenge challenge) {
      
        challenges.add(challenge);
        return "Challenge added successfully!";

  }
  
}
