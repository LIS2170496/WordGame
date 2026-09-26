public class MultipleLettersException extends Exception {
    
    //Requirement 5a - Override getMessage mathod to custom message
    public String getMessage() {
        return "More than one letter was entered";
    }
}
