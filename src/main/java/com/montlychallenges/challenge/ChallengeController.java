package com.montlychallenges.challenge;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
public class ChallengeController {
   

    private  ChallengeService challengeService;
     ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

   
@GetMapping("/getChallenges")
 public ResponseEntity<List<Challenge>> getChallenges() {
    if(challengeService.getAllChallenges().isEmpty()) {
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
       return  new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
   }
  @PostMapping("/postChallenges")
  public  ResponseEntity<String> postChallenges(@RequestBody Challenge challenge) {
       boolean res = challengeService.postChallenges(challenge);
        if(res == false) {
            return  new ResponseEntity<>("Failed to add challenge!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Challenge added successfully!", HttpStatus.CREATED);
       

  }
  @GetMapping("/getChallenge/{month}")    
  public ResponseEntity<List<Challenge>>getChallenge(@PathVariable String month) {
    if(challengeService.getChallenge(month) == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    if(challengeService.getChallenge(month).isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
      return  new ResponseEntity<List<Challenge>>(challengeService.getChallenge(month), HttpStatus.OK);
  }
      @PutMapping("/updateChallenge/{id}")
      public ResponseEntity<String> putMethodName(@PathVariable long id, @RequestBody Challenge challenge) {
          return new ResponseEntity<>(challengeService.updateChallenge(id, challenge) , HttpStatus.OK);
      }
      @DeleteMapping("/deleteChallenge/{id}")
      public ResponseEntity<String> deleteChallenge(@PathVariable long id) {
          if(challengeService.deleteChallenge(id)) {
              return new ResponseEntity<>("Challenge deleted successfully!", HttpStatus.OK);
          }
          return new ResponseEntity<>("Challenge not found!", HttpStatus.NOT_FOUND);
      }
      @DeleteMapping("/deleteAllChallenges")
        public ResponseEntity<String> deleteAllChallenges() {
            boolean check =  challengeService.deleteAllChallenges();
        if(check == false) {
            return new ResponseEntity<>("No challenges to delete!", HttpStatus.NOT_FOUND);
        }
                return new ResponseEntity<>("All challenges deleted successfully!", HttpStatus.OK);

        }
      
}
