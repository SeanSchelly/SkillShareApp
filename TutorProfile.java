public class TutorProfile extends Profile{
    final private boolean hasLicense = true;
    public TutorProfile(String email, String bio, String experience, double rating){
        super(email, bio, experience, rating);
    }

    public boolean getLicense() {return hasLicense;}

}