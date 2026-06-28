import java.util.Scanner;

public class SystemServicesSupport {
    protected static void emailSearch(Profile[] profs, Scanner scannerInput) {
        System.out.println("EMAIL SEARCH:");
        scannerInput.next();
        String emailString = scannerInput.nextLine();
        System.out.println("looking...");

        for(int i=0; i<profs.length; i++) {
            if(profs[i].getEmail().contains(emailString)) {
                System.out.println(profs[i]);
            }
        }
        SystemServicesMinor.searchActions(scannerInput, profs);
    }
    protected static void skillSearch(Profile[] profs, Scanner scannerInput) {
        System.out.println("SKILL SEARCH:");
        scannerInput.next();
        String skillString = scannerInput.nextLine();
        for(int i=0; i< profs.length; i++) {
            if(profs[i].getBio().contains(skillString)) {
                System.out.println(profs[i]);
            }
        }
        SystemServicesMinor.searchActions(scannerInput, profs);
    }
    protected static void experienceSearch(Profile[] profs, Scanner scannerInput) {
        System.out.println("EXPERIENCE SEARCH (beginner | intermediate | expert):");
        scannerInput.next();
        String experienceString = scannerInput.nextLine();
        for(int i=0; i< profs.length; i++) {
            if(profs[i].getExperience().contains(experienceString)) {
                System.out.println(profs[i]);
                break;
            }
        }
        SystemServicesMinor.searchActions(scannerInput, profs);

    }
}
