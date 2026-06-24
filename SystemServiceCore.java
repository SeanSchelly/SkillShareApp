import java.util.InputMismatchException;
import java.util.Scanner;
public class SystemServiceCore{
    //Converted main() to runDashboard() so Main.java calls it as a subsystem
    public static void runDashboard() {
        //universal scanner
        Scanner input = new Scanner(System.in);

        //global vars
        String email = "";
        int startChoice = 0;

        //will be stored in db
        Skills s1 = new Skills("Chess", "intermediate");
        Skills s2 = new Skills("C# Programming", "expert");
        Skills s3 = new Skills("Studying", "beginner");
        Skills s4 = new Skills("language", "beginner");
        Skills s5 = new Skills("Python", "expert");
        Skills s6 = new Skills("SQL", "expert");
        Skills s7 = new Skills("Web developer", "beginner");
        //db simulator
        Skills[] skillArray = {s1, s2, s3, s4, s5, s6, s7};

        //will be stored in db
        //Students
        Profile profile1 = new Profile("ali@gmail.com", "Computer science student interested in Java.", "beginner", 0.0);
        Profile profile4 = new Profile("emily.smith@edu.com", "Language tutor looking to learn basic coding.", "beginner", 0.0);
        //Tutors
        Profile profile2 = new TutorProfile("sara@yahoo.com", "Professional web developer with 5 years of experience.", "expert",0.0);
        Profile profile3 = new TutorProfile("john.doe@company.com", "Data Analyst familiar with Python and SQL.", "intermediate", 0.0);
        Profile profile5 = new TutorProfile("mike.tech@gmail.com", "System architect specializing in backend logic.", "expert", 0.0);
        //db simulator
        Profile[] profileArray = {profile1, profile2, profile3, profile4, profile5};
        //usr profile
        Person newUsrData = new Person("", "");
        Profile newUsrProfile = new Profile("", "", "",0.0);

        System.out.println("SkillShare App Dashboard");
        System.out.println("Hello, user. Would you like to create an account or view in-demand skills? (1/2) -> (yes/no)");
        try {
            startChoice = input.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Incorrect data type entered.");
        }
        switch(startChoice) {
            case 1:
                System.out.println("Welcome aboard! Please enter your name and email...");
                System.out.println("name: ");
                String name = input.nextLine();
                name = input.nextLine();

                System.out.println("email: ");
                String firstEntry = input.nextLine();
                if(!(firstEntry.contains("@")) || !(firstEntry.contains(".com"))) {
                    System.out.println("Err: Incorrect email format. Please restart app and reenter.");
                } else {
                    email = firstEntry;
                    newUsrData.setMail(email);
                    newUsrData.setName(name);
                    System.out.println("Personal details set.");
                    System.out.println("Let's also create a profile for you.");
                    System.out.println("Email: (logging previously set email)");
                    newUsrProfile.setEmail(email);
                    System.out.println("Enter your bio:");
                    String bio = input.nextLine();
                    newUsrProfile.setBio(bio);
                    System.out.println("Enter your experience: ");
                    String experienceLevel = input.nextLine();
                    newUsrProfile.setExperience(experienceLevel);

                    System.out.println("Here are your profile/user details to confirm: ");
                    System.out.println(newUsrData);
                    System.out.println(newUsrProfile);

                    System.out.println("If these details aren't correct, please restart the program and reenter.");
                    System.out.println("------------------------------------------------------------");
                    System.out.println(newUsrProfile.getEmail().toUpperCase()+"'s Dashboard.");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("FEED PAGE");
                    System.out.println("Available skills:");
                    for(int i=0; i<skillArray.length; i++) {
                        System.out.println(skillArray[i]+"\n");
                    }
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Online users:");
                    for(int i=0; i<profileArray.length; i++) {
                        System.out.println(profileArray[i]+"\n");
                    }
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Proceed with Search?");
                    System.out.println("|yes| |no|");
                    String searchApprove = input.nextLine();
                    if(searchApprove.equals("yes")) {
                        SystemServices.searchFacility(newUsrProfile.getEmail(), profileArray);

                    } else {
                        System.out.println("Going back to feed...");

                    }
                    System.out.println(" ");
                    System.out.println("Feed (refreshed)");
                    System.out.println(newUsrProfile.getEmail().toUpperCase()+"'s Dashboard.");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("FEED PAGE");
                    System.out.println("Available skills:");
                    for(int i=0; i<skillArray.length; i++) {
                        System.out.println(skillArray[i]+"\n");
                    }
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Online users:");
                    for(int i=0; i<profileArray.length; i++) {
                        System.out.println(profileArray[i]+"\n");
                    }

                    //
                    System.out.println("[Backing up all user details. This will only be a second...]");
                    WriterBackUpService newBackUp = new WriterBackUpService();
                    //Extra backup to simulate abstraction and basic file io/exception handling
                    newBackUp.writerBackUp(profileArray, newUsrProfile, newUsrData);
                }
                break;

            case 2:
                System.out.println(newUsrProfile.getEmail()+"'s Personal Dashboard");
                System.out.println("------------------------------------------------------------");
                SystemServices.searchFacility(skillArray);
        }
        //Close scanner to avoid conflict when called from Main.java
        input.close();
    }
}
