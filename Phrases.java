public class Phrases {
    //Requirement 6a - String gamePhrase which is set on instantiation
    String gamePhrase = new String();

    //Requirement 6b - String playingPhrase sets letters as underscores to mask
    String playingPhrase = new String();

    //This would be better than a String
    StringBuilder playingPhraseStringBuilder;

    //Requirement 6. - New Phrases class can throw MultipleLettersException
    public Phrases(String phrase) throws MultipleLettersException {
        gamePhrase = phrase;

        //FIXME - figure out how to replace any isLetter=true with underscore
        // maybe have to loop through len of string?
        playingPhraseStringBuilder = gamePhrase.replace('a','_');
        playingPhrase = playingPhraseStringBuilder.toString();
    }

    //Requirement 6. - Set up Phrases to function similarly to Numbers.java
    //               - compare guess to answer then return statement and boolean
    //FIXME - finish this method later
    public boolean compareCharacter(char guess) {
        return true;
    }


    
}
