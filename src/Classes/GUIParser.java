package Classes;

import Interfaces.IActions;

import java.util.Scanner;

public class GUIParser implements IActions {

    // Initializes the GUI
    public void init() {}

    @Override
    public String askName() {
        return null;
    }

    @Override
    public void start(String connectionString) {

    }

    // Sets the stage to not have a frame
    private void setNoFrame() {}

    // Loads the initial scenes for the GUI
    private void loadInitialScenes() {}

    // Loads the main scene for the GUI
    private void loadMainScene() {}

    // Private constructor for the singleton pattern
    GUIParser() {}

    // Returns the current scene being displayed
    public static void getCurrentScene() {}

    // Returns the GUI Parser
    public static GUIParser getParser() {
        return null;
    }

    // Starts the GUI with the given stage
    public void start() {}

    // Restarts the GUI
    public void restart() {}

    // Starts the given age in the game
    public void startAge(int age) {}

    // Starts the given turn in the game
    public void startTurn(int turn) {}

    // Performs end of turn actions for the given turn
    public void doEndOfTurn(int turn) {}

    // Performs end of age actions for the given age
    public void doEndOfAge(int age) {}

    // Shows the game result
    public void showGameResult() {}

    // Returns a boolean indicating if the game should continue
    public boolean continueGame() {
        return false;
    }
}
