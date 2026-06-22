import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        requesthandlersys requestSystem = new requesthandlersys();
        reviewservicesys reviewSystem = new reviewservicesys();

        file.initDatabase();

        try {
            ArrayList<skrequest> textReqs = file.loadRequests();
            for (skrequest r : textReqs) {
                requestSystem.sendrequest(r);
            }
            ArrayList<reviews> textRevs = file.loadReviews();
            for (reviews r : textRevs) {
                reviewSystem.Addrev(r);
            }
        } catch (Exception e) {
            System.err.println("Could not load initial text data: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n SKILL SHARING PLATFORM SYSTEM ");
            System.out.println("1. Send a Skill Request");
            System.out.println("2. View All Requests");
            System.out.println("3. Accept a Request");
            System.out.println("4. Reject a Request");
            System.out.println("5. Add a Review/Rating");
            System.out.println("6. View Average Rating for a User");
            System.out.println("7. Save Data to Text Files");
            System.out.println("8. Run Serialization Backup");
            System.out.println("9. Restore Data from Serialization Backup");
            System.out.println("10. Save Data to Database");
            System.out.println("11. Load Data from Database");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Sender Email: ");
                String sender = scanner.nextLine();
                System.out.print("Enter Receiver Email: ");
                String receiver = scanner.nextLine();
                System.out.print("Enter Request ID (Integer): ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Skill Requested: ");
                String skill = scanner.nextLine();

                skrequest req = new skrequest(sender, receiver, "PENDING", id, skill);
                requestSystem.sendrequest(req);
                System.out.println("Request added to active memory loop.");

            } else if (choice == 2) {
                System.out.println("\n Current Requests ");
                for (skrequest r : requestSystem.getrequests()) {
                    System.out.println("ID: " + r.getreqid() + " | From: " + r.getreqsender() + " | To: " + r.getreqreciever() + " | Skill: " + r.getskill() + " | Status: " + r.getstatus());
                }

            } else if (choice == 3) {
                System.out.print("Enter Request ID to Accept: ");
                int id = scanner.nextInt();
                requestSystem.acceptreq(id);
                System.out.println("Status updated if ID existed.");

            } else if (choice == 4) {
                System.out.print("Enter Request ID to Reject: ");
                int id = scanner.nextInt();
                requestSystem.rejectreq(id);
                System.out.println("Status updated if ID existed.");

            } else if (choice == 5) {
                System.out.print("Enter Review ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Author Email: ");
                String author = scanner.nextLine();
                System.out.print("Enter Target Email: ");
                String target = scanner.nextLine();
                System.out.print("Enter Rating (1-5): ");
                int rating = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Comment: ");
                String comment = scanner.nextLine();

                reviews rev = new reviews(id, author, target, rating, comment);
                reviewSystem.Addrev(rev);
                System.out.println("Review added to active memory loop.");

            } else if (choice == 6) {
                System.out.print("Enter User Email: ");
                String email = scanner.nextLine();
                double avg = reviewSystem.getavgrating(email);
                System.out.println("Average Rating for " + email + ": " + avg);

            } else if (choice == 7) {
                file.saveRequests(new ArrayList<>(requestSystem.getrequests()));
                file.saveReviews(new ArrayList<>(reviewSystem.getrev()));
                System.out.println("Data flushed to plain text logs successfully.");

            } else if (choice == 8) {
                backuprecord.backupRequests(new ArrayList<>(requestSystem.getrequests()));
                backuprecord.backupReviews(new ArrayList<>(reviewSystem.getrev()));

            } else if (choice == 9) {
                ArrayList<skrequest> restoredReqs = backuprecord.restoreRequests();
                ArrayList<reviews> restoredRevs = backuprecord.restoreReviews();

                for (skrequest r : restoredReqs) {
                    requestSystem.sendrequest(r);
                }
                for (reviews r : restoredRevs) {
                    reviewSystem.Addrev(r);
                }
                System.out.println("Binary arrays re-injected into active handler systems.");

            } else if (choice == 10) {
                for (skrequest r : requestSystem.getrequests()) {
                    dbconnection.saveRequest(r);
                }
                for (reviews r : reviewSystem.getrev()) {
                    dbconnection.saveReview(r);
                }
                System.out.println("JDBC pipeline transaction commit processing finished.");

            } else if (choice == 11) {
                ArrayList<skrequest> dbReqs = dbconnection.loadRequests();
                ArrayList<reviews> dbRevs = dbconnection.loadReviews();

                for (skrequest r : dbReqs) {
                    requestSystem.sendrequest(r);
                }
                for (reviews r : dbRevs) {
                    reviewSystem.Addrev(r);
                }
                System.out.println("Active instance updated with query results from database server.");

            } else if (choice == 12) {
                System.out.println("Exiting System execution context.");
                break;
            } else {
                System.out.println("Invalid option index tracking exception.");
            }
        }
        scanner.close();
    }
}