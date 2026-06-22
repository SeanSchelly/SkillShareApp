import java.io.*;
import java.util.ArrayList;

public class file {
    private static final String REQ_FILE = "database/request.txt";
    private static final String REV_FILE = "database/reviews.txt";

    public static void initDatabase() {
        File dir = new File("database");
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
    public static void saveRequests(ArrayList<skrequest> list) {
        initDatabase();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(REQ_FILE))) {
            for (skrequest req : list) {
                bw.write(req.getreqsender() + "," +
                        req.getreqreciever() + "," +
                        req.getstatus() + "," +
                        req.getreqid() + "," +
                        req.getskill());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving text request data: " + e.getMessage());
        }
    }

    public static ArrayList<skrequest> loadRequests() {
        ArrayList<skrequest> list = new ArrayList<>();
        File f = new File(REQ_FILE);
        if (!f.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    int id = Integer.parseInt(parts[3].trim());
                    list.add(new skrequest(parts[0], parts[1], parts[2], id, parts[4]));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading text request data: " + e.getMessage());
        }
        return list;
    }
    public static void saveReviews(ArrayList<reviews> list) {
        initDatabase();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(REV_FILE))) {
            for (reviews rev : list) {
                bw.write(rev.getrevID() + "," +
                        rev.getreviewauthor() + "," +
                        rev.getreviewtarget() + "," +
                        rev.getuserrating() + "," +
                        rev.getusercomment());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving text reviews data: " + e.getMessage());
        }
    }

    public static ArrayList<reviews> loadReviews() {
        ArrayList<reviews> list = new ArrayList<>();
        File f = new File(REV_FILE);
        if (!f.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    int id = Integer.parseInt(parts[0].trim());
                    int rating = Integer.parseInt(parts[3].trim());
                    list.add(new reviews(id, parts[1], parts[2], rating, parts[4]));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading text reviews data: " + e.getMessage());
        }
        return list;
    }
}