// [Integration] Moved from User Management System/ to root, accessible from Main.java
import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully!");
    }

    public User findUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // [Integration] Added getter so Main.java can iterate users for database persistence
    public ArrayList<User> getUsers() {
        return users;
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        for (User user : users) {
            System.out.println(user);
            System.out.println("-------------------");
        }
    }

    public boolean deleteUser(int id) {
        User user = findUser(id);

        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }
}
