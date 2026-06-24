import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String email;

    public Person(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName(){ return name; }
    public String getEmail(){ return email; }

    public void setName(String newName) {this.name = newName;}
    public void setMail(String newMail) {this.email = newMail;}


    @Override
    public String toString(){
        return "NAME: " + name + " | EMAIL: " + email;
    }

}