import java.io.IOException;
import java.io.PrintWriter;

public class WriterBackUpService extends FileBackUp {
    public WriterBackUpService() {

    }
    public void writerBackUp(Profile[] profiles, Profile usrProfile, Person usrData) {
        try(PrintWriter fileOut1 = new PrintWriter("ProfilesBackUp.txt");
            PrintWriter fileOut2 = new PrintWriter("ProfilesBackUpUsr.txt");
            PrintWriter fileOut3 = new PrintWriter("ProfilesBackUpUsr2.txt")) {
            for(int i = 0; i<profiles.length; i++) {
                fileOut1.println(profiles[i]);
            }
            fileOut2.println(usrProfile);
            fileOut3.println(usrData);
            System.out.println("Files have been written!");
        } catch(IOException e) {
            System.out.println("Err: Error while writing back up to files.");
        }
    }
}