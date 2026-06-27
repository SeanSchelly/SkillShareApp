import java.util.Scanner;

public class SystemServices {
    //static method for class-level operations
    public static void searchFacility(String email, Profile[] profiles) {
        System.out.println(email.toUpperCase()+"'s Dashboard.");
        System.out.println("------------------------Welcome To Search-------------------------");
        System.out.println("Are you searching by |1. email| |2. skill| |3. experience|");
        //global scanner
        Scanner searchChoice = new Scanner(System.in);
        //
        switch(searchChoice.nextInt()) {
            case 1:
                while(true) {
                    System.out.println("Email search");
                    String emailString = searchChoice.nextLine();
                    emailString = searchChoice.nextLine();
                    System.out.println("looking...");

                    for(int i=0; i<profiles.length; i++) {
                        if(profiles[i].getEmail().contains(emailString)) {
                            System.out.println(profiles[i]);
                        }
                    }
                    System.out.println("From the search results, please type in the full email you were looking for so we can log for selection.");
                    String emailConfirm = searchChoice.nextLine();
                    Profile selectedProfile = new TutorProfile("", "", "", 0.0);
                    for(int i=0; i<profiles.length; i++) {
                        if(profiles[i].getEmail().contains(emailConfirm)) {
                            selectedProfile = profiles[i];
                        }
                    }
                    System.out.println("Reading profile details...Done.");
                    System.out.println("What would you like to do with the selected profile?");
                    System.out.println("1. Make tuition req | 2. view profile | 3. exit program");
                    int actionChoice = searchChoice.nextInt();
                    switch(actionChoice) {
                        case 1:
                            System.out.println("Sending req...");
                            for(int i = 0; i< profiles.length; i++) {
                                if(profiles[i].equals(selectedProfile)) {
                                    System.out.println(profiles[i].getEmail()+" has accepted your request!");
                                    System.out.println("Go ahead and upskill yourself!");
                                    System.out.println("---------------------------------------");
                                    System.out.println("Please rate the tutor if you've benefitted from their course: ");
                                    double firstRating = searchChoice.nextDouble();
                                    if(firstRating < 0 || firstRating > 5) {
                                        System.out.println("Err: Invalid rating. Not logged.");
                                    } else {
                                        profiles[i].setRating(firstRating);
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
                            String skillChoice = searchChoice.nextLine();
                            skillChoice = searchChoice.nextLine();
                            if(skillChoice.equals("yes")) {
                                Skills newSkill = new Skills("","");
                                System.out.println("What skill would you like to add?");
                                System.out.println("skill name:");
                                String skillChoiceName = searchChoice.nextLine();
                                newSkill.setSkillName(skillChoiceName);
                                System.out.println("minimum experience level required:");
                                String skillChoiceExperience = searchChoice.nextLine();
                                newSkill.setExperienceLevelRequired(skillChoiceExperience);

                                System.out.println("Set! Our team will review your request.");
                            }
                            break;
                    }
                    break;
                }
                break;

            case 2:
                System.out.println("Skill search");
                String skillString = searchChoice.nextLine();
                skillString = searchChoice.nextLine();
                for(int i=0; i< profiles.length; i++) {
                    if(profiles[i].getBio().contains(skillString)) {
                        System.out.println(profiles[i]);
                    }
                }
                System.out.println("From the search results, please type in the full email you were looking for so we can log for selection.");
                String emailConfirm = searchChoice.nextLine();
                Profile selectedProfile = new Profile("", "", "", 0.0);
                for(int i=0; i<profiles.length; i++) {
                    if(profiles[i].getEmail().contains(emailConfirm)) {
                        selectedProfile = profiles[i];
                        break;
                    }
                }
                System.out.println("Reading profile details...Done.");
                System.out.println("What would you like to do with the selected profile?");
                System.out.println("1. Make tuition req | 2. view profile | 3. exit ");
                int actionChoice = searchChoice.nextInt();
                switch(actionChoice) {
                    case 1:
                        System.out.println("Sending req...");
                        for(int i = 0; i< profiles.length; i++) {
                            if(profiles[i].equals(selectedProfile)) {
                                System.out.println(profiles[i].getEmail()+" has accepted your request!");
                                System.out.println("Go ahead and upskill yourself!");
                                System.out.println("---------------------------------------");
                                System.out.println("Please rate the tutor if you've benefitted from their course: ");
                                double firstRating = searchChoice.nextDouble();
                                if(firstRating < 0 || firstRating > 5) {
                                    System.out.println("Err: Invalid rating. Not logged.");
                                } else {
                                    profiles[i].setRating(firstRating);
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
                        String skillChoice = searchChoice.nextLine();
                        skillChoice = searchChoice.nextLine();
                        if(skillChoice.equals("yes")) {
                            Skills newSkill = new Skills("","");
                            System.out.println("What skill would you like to add?");
                            System.out.println("skill name:");
                            String skillChoiceName = searchChoice.nextLine();
                            newSkill.setSkillName(skillChoiceName);
                            System.out.println("minimum experience level required:");
                            String skillChoiceExperience = searchChoice.nextLine();
                            newSkill.setExperienceLevelRequired(skillChoiceExperience);
                            System.out.println("Set! Our team will review your request.");
                        }
                        break;
                }
                break;
            case 3:
                System.out.println("experience search (beginner | intermediate | expert)");
                String experienceString = searchChoice.nextLine();
                experienceString = searchChoice.nextLine();
                for(int i=0; i< profiles.length; i++) {
                    if(profiles[i].getExperience().contains(experienceString)) {
                        System.out.println(profiles[i]);
                        break;
                    }
                }
                System.out.println("From the search results, please type in the full email you were looking for so we can log for selection.");
                emailConfirm = searchChoice.nextLine();
                selectedProfile = new Profile("", "", "", 0.0);
                for(int i=0; i<profiles.length; i++) {
                    if(profiles[i].getEmail().contains(emailConfirm)) {
                        selectedProfile = profiles[i];
                        break;
                    }
                }
                System.out.println("Reading profile details...Done.");
                System.out.println("What would you like to do with the selected profile?");
                System.out.println("1. Make tuition req | 2. view profile | 3. exit");
                actionChoice = searchChoice.nextInt();
                switch(actionChoice) {
                    case 1:
                        System.out.println("Sending req...");
                        for(int i = 0; i< profiles.length; i++) {
                            if(profiles[i].equals(selectedProfile)) {
                                System.out.println(profiles[i].getEmail()+" has accepted your request!");
                                System.out.println("Go ahead and upskill yourself!");
                                System.out.println("---------------------------------------");
                                System.out.println("Please rate the tutor if you've benefitted from their course: ");
                                double firstRating = searchChoice.nextDouble();
                                if(firstRating < 0 || firstRating > 5) {
                                    System.out.println("Err: Invalid rating. Not logged.");
                                } else {
                                    profiles[i].setRating(firstRating);
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
                        String skillChoice = searchChoice.nextLine();
                        skillChoice = searchChoice.nextLine();
                        if(skillChoice.equals("yes")) {
                            Skills newSkill = new Skills("","");
                            System.out.println("What skill would you like to add?");
                            System.out.println("skill name:");
                            String skillChoiceName = searchChoice.nextLine();
                            newSkill.setSkillName(skillChoiceName);
                            System.out.println("minimum experience level required:");
                            String skillChoiceExperience = searchChoice.nextLine();
                            newSkill.setExperienceLevelRequired(skillChoiceExperience);
                            System.out.println("Set! Our team will review your request.");
                        }
                        break;
                }
                break;
        }
    }
    //static method for class-level operations
    //overloaded method
    public static void searchFacility(Skills[] skill) {
        System.out.println("Until you create a new account, you can simply view all skills. ");
        System.out.println("All Skills:");
        for(int i=0; i< skill.length; i++) {
            System.out.println(skill[i]);
        }
    }
}