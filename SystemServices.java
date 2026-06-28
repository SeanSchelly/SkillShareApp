import java.util.Scanner;

public class SystemServices {
    //static method for class-level operations
    public static void searchFacility(String email, Profile[] profiles, Scanner scannerInput) {
        //scanner inherited from SystemServiceCore
        System.out.println(email.toUpperCase()+"'s Dashboard.");
        System.out.println("------------------------Welcome To Search-------------------------");
        System.out.println("-Search is very sensitive, please be as specific as possible-");
        System.out.println("Are you searching by |1. email| |2. skill| |3. experience|");
        switch(scannerInput.nextInt()) {
            //Calling remote methods to perform search based on experience, skill, or email
            case 1:
                SystemServicesSupport.emailSearch(profiles, scannerInput);
                break;
            case 2:
                SystemServicesSupport.skillSearch(profiles, scannerInput);
                break;
            case 3:
                SystemServicesSupport.experienceSearch(profiles, scannerInput);
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