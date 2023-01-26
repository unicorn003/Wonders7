package Interfaces;

public interface IActions {
    // Initializes the GUI
    public void init();
    public String askName();
    // Starts the GUI with the given stage
    public void start(String connectionString);

    // Restarts the GUI
    public void restart();

    // Starts the given age in the game
    public void startAge(int age);

    // Starts the given turn in the game
    public void startTurn(int turn);

    // Performs end of turn actions for the given turn
    public void doEndOfTurn(int turn);

    // Performs end of age actions for the given age
    public void doEndOfAge(int age);

    // Shows the game result
    public void showGameResult();

    // Returns a boolean indicating if the game should continue
    public boolean continueGame();

}


