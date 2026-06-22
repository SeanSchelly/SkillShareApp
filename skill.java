import java.io.Serializable;
import java.util.List;

public class skill implements Serializable {
    private static final long serialVersionUID = 1L;

    private String skillName;
    private String category;
    private String experienceLevel; 
    private String ownerEmail;
    private double avgRating;
    private int ratingCount;
    
    private transient double totalRatingPoints; 

    public skill(String skillName, String category, String experienceLevel, String ownerEmail) {
        if (skillName == null || skillName.trim().isEmpty()) {
            throw new IllegalArgumentException("Validation Error: Skill name cannot be empty.");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Validation Error: Category cannot be empty.");
        }
        if (ownerEmail == null || ownerEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("Validation Error: Owner email cannot be empty.");
        }

        if (!experienceLevel.equalsIgnoreCase("Beginner") && 
            !experienceLevel.equalsIgnoreCase("Intermediate") && 
            !experienceLevel.equalsIgnoreCase("Expert")) {
            throw new IllegalArgumentException("Validation Error: Level must be Beginner, Intermediate, or Expert.");
        }

        this.skillName = skillName.trim();
        this.category = category.trim();
        this.experienceLevel = experienceLevel.trim();
        this.ownerEmail = ownerEmail.trim();
        this.avgRating = 0.0;
        this.ratingCount = 0;
        this.totalRatingPoints = 0.0;
    }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getExperienceLevel() { return experienceLevel; }
    public String getOwnerEmail() { return ownerEmail; }
    public double getAvgRating() { return avgRating; }
    public int getRatingCount() { return ratingCount; }

    public void addRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Validation Error: Rating must be between 1 and 5 stars (inclusive).");
        }

        if (this.totalRatingPoints == 0.0 && this.ratingCount > 0) {
            this.totalRatingPoints = this.avgRating * this.ratingCount;
        }

        this.ratingCount++;
        this.totalRatingPoints += rating;
        this.avgRating = this.totalRatingPoints / this.ratingCount;
    }

    public static void matchSkills(List<skill> skillList, String targetLevel) {
        System.out.println("\n===============================================");
        System.out.println("  MATCH RESULTS FOR LEVEL: [" + targetLevel.toUpperCase() + "]  ");
        System.out.println("===============================================");
        boolean matchFound = false;
        
        for (skill s : skillList) {
            if (s.getExperienceLevel().equalsIgnoreCase(targetLevel)) {
                System.out.println(s.toString());
                matchFound = true;
            }
        }
        
        if (!matchFound) {
            System.out.println("No matching student tutors found for " + targetLevel + " level.");
        }
        System.out.println("===============================================");
    }

    public static void viewAllSkills(List<skill> skillList) {
        System.out.println("\n========= PUBLIC SKILLS DISCOVERY FEED =========");
        if (skillList.isEmpty()) {
            System.out.println(" The feed is currently empty. Check back later!");
            System.out.println("===============================================");
            return;
        }
        for (skill s : skillList) {
            System.out.println(s.toString());
        }
        System.out.println("===============================================");
    }

    @Override
    public String toString() {
        return String.format("  [%s] %s \n     Tutor: %s |  Rating: %.1f/5.0 (%d reviews)", 
                experienceLevel, skillName, ownerEmail, avgRating, ratingCount);
    }
}