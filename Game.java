import java.util.Scanner;

class Game {

    String wordToGuess;
    String wordToDisplay = "";
    int numberOfTries = 8;
    private boolean won = false;

    public Game(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        for(int i = 0; i < wordToGuess.length(); i++) {
            wordToDisplay += "_";
        }
    }

    public void run() {

        System.out.println(wordToDisplay);
        while(won != true & numberOfTries != 0) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.equals("")) {
                continue;
            }
            char letter = input.charAt(0);
            updateLettersIfAnyGuessed(letter);
            won = checkIfWordIsGuessed();
            System.out.println("You have " + numberOfTries + " tries left!");
            System.out.println(wordToDisplay);
        }
        if(won != true) {
            System.out.println(wordToGuess);
        }
    }

    private void updateLettersIfAnyGuessed(char userGuess) {
        boolean userGuessedLetter = false;
        for(int i = 0; i < wordToGuess.length(); i++) {
           if(userGuess == wordToGuess.charAt(i)) {
               wordToDisplay = wordToDisplay.substring(0, i) + String.valueOf(userGuess) + wordToDisplay.substring(i + 1);
               userGuessedLetter = true;
           }
        }
        if(userGuessedLetter == false) {
            numberOfTries--;
        }
    }

    private boolean checkIfWordIsGuessed() {

        if(wordToGuess.equals(wordToDisplay)) {
            return true;
        }
        return false;

    }

    public boolean userGuessed() {
        return won;
    }
}