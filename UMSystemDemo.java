// Renamed class from Main to UMSystemDemo and main() to runDemo() to avoid conflict with Main.java and allow Main.java to call it
public class UMSystemDemo {
    public static void runDemo() {

        UserManager manager = new UserManager();

        User u1 = new User(
                1,
                "Samuel",
                "samuel@gmail.com",
                "1234",
                "Teacher"
        );

        User u2 = new User(
                2,
                "John",
                "john@gmail.com",
                "5678",
                "Learner"
        );

        manager.addUser(u1);
        manager.addUser(u2);

        manager.displayUsers();

        User found = manager.findUser(1);

        if (found != null) {
            System.out.println("\nUser Found:");
            System.out.println(found);
        }
    }
}
