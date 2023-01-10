package Game;


import java.util.Random;

    /*
     * Henning Wigforss
     * Rola Abou Hachem
     */


public class GameBean {
    private int secretNumber;
    private int numberOfGuesses;
    private int lastGuess;
    private boolean gameFinished;
    private String response;

    public GameBean(){
        this.secretNumber = generateNumber();
        this.numberOfGuesses = 0;
        this.gameFinished = false;
        this.response = "Start";
    }


    private int generateNumber() {
        Random rand = new Random();
        int sec = rand.nextInt(100);
        sec = sec + 1;
       return sec;
    }

    public void checkGuess(int guess) {
        this.lastGuess = guess;
        
        if(guess <1 || guess >100){
            this.response = "Out of bounds";
            return;
        }

        if (guess == secretNumber) {
            numberOfGuesses++;
            this.gameFinished = true;
            this.response = "Correct";
            return;
        }
        if (guess < secretNumber) {
            numberOfGuesses++;
            this.response = "Lower";
            return;
        }
        if (guess > secretNumber) {
            numberOfGuesses++;
            this.response = "Higher";
            return;
        }

    }

    public void resetGame() {
        this.secretNumber = generateNumber();
        this.numberOfGuesses = 0;
        this.gameFinished = false;
        this.response = "Start";
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public boolean getGameFinished() {
        return gameFinished;
    }

    public int getLastGuess() {
        return this.lastGuess;
    }

    public String getResponse() {
        return this.response;
    }
    
    public int getSecret(){
        return this.secretNumber;
    }
    
}
