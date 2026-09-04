//Requirement 3a - new Person class
public class Person {

    
    //Requirement 3b - two private instance variables
    private String firstName;
    private String lastName;


    //Requirement 3d - two overloaded constructors
    public Person(String first) {
        firstName = first;
        lastName = "";
    }
    public Person(String first, String last) {
        firstName = first;
        lastName = last;
    }


    //Requirement 3c - public getters and setters for first/last name
    public void setFirstName(String fn) {
        firstName = fn;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String ln) {
        lastName = ln;
    }
    public String getLastName() {
        return lastName;
    }



    public String getFullName() {
        if (lastName.equals("")) {
            return firstName;
        }
        else {
            return firstName + " " + lastName;
        }
    }


}