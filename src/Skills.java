package src;

import java.io.Serializable;

public class Skills implements Serializable {
    private String skillName;
    private String experienceLevelRequired;

    public Skills(String skillName, String experienceLevelRequired) {
        this.skillName = skillName;
        this.experienceLevelRequired = experienceLevelRequired;
    }

    public String getSkillName() { return skillName; }
    public String getExperienceLevelRequired() { return experienceLevelRequired; }
    public void setSkillName(String newSkillName) { this.skillName = newSkillName; }
    public void setExperienceLevelRequired(String newExperienceLevelRequired) { this.experienceLevelRequired = experienceLevelRequired; }

    @Override
    public String toString() {
        return "SKILL: " + skillName + " | LEVEL REQUIRED: " + experienceLevelRequired;
    }
}