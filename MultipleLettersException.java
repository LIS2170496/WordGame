public class MultipleLettersException extends Exception {

    public MultipleLettersException() {
        super("More than one letter was entered");
    }
    
    //Override getMessage mathod to custom message
    public String getMessage() {
        return "More than one letter was entered";
    }
}
