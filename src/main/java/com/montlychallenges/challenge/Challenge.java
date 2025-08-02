package com.montlychallenges.challenge;

public class Challenge {
   private long id; 
   private String  month ;
   private String  description;

   public Challenge(long id, String month, String description) {
       this.id = id;
       this.month = month;
       this.description = description;
   }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return this.description;
    }
//setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    
    
   
}
