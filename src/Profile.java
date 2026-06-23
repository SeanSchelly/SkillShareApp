package src;

import java.io.Serializable;

public class Profile implements Serializable {
    private String email;
    private String bio;
    private String experience; // beginner, intermediate, expert
    private double rating;


    public Profile(String email, String bio, String experience, double rating){
        this.email = email;
        this.bio = bio;
        this.experience = experience;
        this.rating = rating;
    }

    public String getEmail(){ return email; }
    public String getBio(){ return bio; }
    public String getExperience(){ return experience; }
    public double getRating() {return rating;}


    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public void setBio(String newBio) {
        this.bio = newBio;
    }
    public void setExperience(String newExperience) {
        this.experience = newExperience;
    }
    public void setRating(double newRating) {this.rating = newRating;}

    @Override
    public String toString(){
        return "EMAIL: " + email +
                " | BIO: " + bio +
                " | EXPERIENCE: " + experience;
    }
}