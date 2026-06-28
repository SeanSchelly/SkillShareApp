import java.util.Scanner;

public class SystemServicesSupport {
    public static void emailSearch(Profile[] profs, Scanner scannerInput) {
        System.out.println("EMAIL SEARCH:");
        String emailString = scannerInput.nextLine();
        emailString = scannerInput.nextLine();
        System.out.println("looking...");
        for(int i=0; i<profs.length; i++) {
            if(profs[i].getEmail().contains(emailString)) {
                System.out.println(profs[i]);
            }
        }
        SystemServicesMinor.searchActions(scannerInput, profs);
    }
    public static void skillSearch(Profile[] profs, Scanner scannerInput) {
        System.out.println("SKILL SEARCH:");
        String skillString = scannerInput.nextLine();
        skillString = scannerInput.nextLine();
        for(int i=0; i< profs.length; i++) {
            if(profs[i].getBio().contains(skillString)) {
                System.out.println(profs[i]);
            }
        }
        SystemServicesMinor.searchActions(scannerInput, profs);
    }
    public static void experienceSearch(Profile[] profs, Scanner scannerInput) {
        System.out.println("EXPERIENCE SEARCH (beginner | intermediate | expert):");
        String experienceString = scannerInput.nextLine();
        experienceString = scannerInput.nextLine();
        for(int i=0; i< profs.length; i++) {
            if(profs[i].getExperience().contains(experienceString)) {
                System.out.println(profs[i]);
                break;
            }
        }
        SystemServicesMinor.searchActions(scannerInput, profs);

    }
}
