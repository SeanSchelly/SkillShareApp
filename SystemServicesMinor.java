import java.util.Scanner;

public class SystemServicesMinor {
    public static void searchActions (Scanner scannerInput, Profile[] profs) {
        System.out.println("From the search results, please type in the full email you were looking for so we can log for selection.");
        String emailConfirm = scannerInput.nextLine();
        Profile selectedProfile = new TutorProfile("", "", "", 0.0);
        for(int i=0; i<profs.length; i++) {
            if(profs[i].getEmail().contains(emailConfirm)) {
                selectedProfile = profs[i];
            }
        }
        System.out.println("Reading profile details...Done.");
        System.out.println("What would you like to do with the selected profile?");
        System.out.println("1. Make tuition req | 2. view profile | 3. exit program");
        int actionChoice = scannerInput.nextInt();
        switch(actionChoice) {
            case 1:
                System.out.println("Sending req...");
                for(int i = 0; i< profs.length; i++) {
                    if(profs[i].equals(selectedProfile)) {
                        System.out.println(profs[i].getEmail()+" has accepted your request!");
                        System.out.println("Go ahead and upskill yourself!");
                        System.out.println("---------------------------------------");
                        System.out.println("Please rate the tutor if you've benefitted from their course: ");
                        double firstRating = scannerInput.nextDouble();
                        if(firstRating < 0 || firstRating > 5) {
                            System.out.println("Err: Invalid rating. Not logged.");
                        } else {
                            profs[i].setRating(firstRating);
                            System.out.println("Set.");
                            break;
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Profile details of "+ selectedProfile.getEmail());
                System.out.println(selectedProfile);
                break;
            case 3:
                System.out.println("Exited Search.");
                System.out.println("Would you like to teach a skill in the future?");
                System.out.println(" |yes| |No|");
                scannerInput.next();
                String skillChoice = scannerInput.nextLine();
                if(skillChoice.equals("yes")) {
                    Skills newSkill = new Skills("","");
                    System.out.println("What skill would you like to add?");
                    System.out.println("skill name:");
                    String skillChoiceName = scannerInput.nextLine();
                    newSkill.setSkillName(skillChoiceName);
                    System.out.println("minimum experience level required:");
                    String skillChoiceExperience = scannerInput.nextLine();
                    newSkill.setExperienceLevelRequired(skillChoiceExperience);

                    System.out.println("Set! Our team will review your request.");
                }
                break;
        }
    }
}
