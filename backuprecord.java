import java.io.*;
import java.util.ArrayList;

public class backuprecord {
    private static final String BACKUP_REQ = "database/request.bin";
    private static final String BACKUP_REV = "database/reviews.bin";

    public static void backupRequests(ArrayList<skrequest> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BACKUP_REQ))) {
            oos.writeObject(list);
            System.out.println("System Backup: Requests serialized successfully.");
        } catch (IOException e) {
            System.err.println("Serialization Error: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<skrequest> restoreRequests() {
        File f = new File(BACKUP_REQ);
        if (!f.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (ArrayList<skrequest>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void backupReviews(ArrayList<reviews> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BACKUP_REV))) {
            oos.writeObject(list);
            System.out.println("System Backup: Reviews serialized successfully.");
        } catch (IOException e) {
            System.err.println("Serialization Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<reviews> restoreReviews() {
        File f = new File(BACKUP_REV);
        if (!f.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (ArrayList<reviews>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}