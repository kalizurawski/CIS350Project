/**************************************************
 * This class is used for all universal game
 * functions.
 **************************************************/
public class Game {

    /** time in seconds that the minigame lasts **/
    private static final int TOTAL_TIME = 5;

    /** time in seconds that the bomb starts counting down at **/
    private static final int BOMB_TIME = 3;

    /** number of attempts user has **/
    private static final int ATTEMPTS_REM = 3;

    /** holds status of game **/
    private boolean gameOver;

    /** word that begins the game **/
    private String gameStartWord;

    /** number of remaining attempts at game **/
    private int attemptsRemaining;

    /***********************************************
     * Initializes object of the Game class.
     *
     * @param word used at the start of the game
     **********************************************/
    void Game(final String word) {
        setGameStartWord(word);
        setAttemptsRemaining(ATTEMPTS_REM);
    }

    /***********************************************
     * Gets the word that starts the game.
     *
     * @return word shown at the start of the game
     **********************************************/
    public String getGameStartWord() {
        return gameStartWord;
    }

    /***********************************************
     * Sets the word that starts the game.
     *
     * @param word shown at start of the game
     **********************************************/
    private void setGameStartWord(final String word) {
        this.gameStartWord = word;
    }

    /***********************************************
     * Gets the number of attempts the user has
     * remaining at the game.
     *
     * @return remaining attempts
     **********************************************/
    private int getAttemptsRemaining() {
        return attemptsRemaining;
    }

    /***********************************************
     * Sets attempts remaining at game.
     *
     * @param rem remaining game attempts
     **********************************************/
    private void setAttemptsRemaining(final int rem) {
        this.attemptsRemaining = rem;
    }

    /***********************************************
     * Decreases the remaining number of attempts
     * on the games.
     **********************************************/
    public void decreaseAttemptsRemaining() {
        int numLeft = getAttemptsRemaining();

        // If user has no attempts left, game ends
        if (numLeft == 0) {
            setGameOver(true);
        } else {
            setAttemptsRemaining(numLeft - 1);
        }
    }

    /***********************************************
     * Sets the gameOver variable.
     *
     * @param over boolean as to whether or not
     *                 the game is over
     **********************************************/
    private void setGameOver(final boolean over) {
        this.gameOver = over;
    }

    /***********************************************
     * Starts the game.
     **********************************************/
    public void startGame() {
        setGameOver(false);
        // TODO: insert game start functions
    }

    //TODO: Finish class
}
