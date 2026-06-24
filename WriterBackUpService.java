// [Integration] Removed package declaration to put all classes in default package, accessible from Main.java

import java.io.IOException;
import java.io.PrintWriter;

public class WriterBackUpService extends FileBackUp {
    public WriterBackUpService() {

    }
    public void writerBackUp(Profile[] profiles, Profile usrProfile, Person usrData) {
        try(PrintWriter fileOut1 = new PrintWriter("ProfilesBackUp.txt")) {
            for(int i = 0; i<profiles.length; i++) {
                fileOut1.println(profiles[i]);
            }
            System.out.println("Files have been written!");
        } catch(IOException e) {
            System.out.println("Err: Error while writing back up to files.");
        }
    }
}