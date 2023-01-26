package Classes;

import Interfaces.IActions;

import java.util.Scanner;

public class GUIParser implements IActions {

    @Override
    public void init() {

    }

    public String askName() {
        System.out.println("What's your name ?");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        return name;
    }

    @Override
    public void start(String connectionString) {

    }

    @Override
    public void restart() {

    }

    @Override
    public void startAge(int age) {

    }

    @Override
    public void startTurn(int turn) {

    }

    @Override
    public void doEndOfTurn(int turn) {

    }

    @Override
    public void doEndOfAge(int age) {

    }

    @Override
    public void showGameResult() {

    }

    @Override
    public boolean continueGame() {
        return false;
    }
}
