package com.duckrace.app;

/*
 * this is the application controller. it directs the overall flow/sequence of application
 * and does all user prompting
 */

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;

public class DuckRacerApp {
    private final Board board = Board.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) {
                validInput = true;
                if ("D".equals(input)) {
                    reward = Reward.DEBIT_CARD;
                }
                else {
                    reward = Reward.PRIZES;
                }
                return reward;
            }


        }
        return reward;
    }

    private int promptForId() {
        int id = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter id of the winner [1-19]:");   // TODO: dont hard code the 19
            String input = scanner.nextLine();
            if (input.matches("\\d{1,2}")) {
                id = Integer.parseInt(input);
                if (1 <= id && id <= 19) {  // TODO dont hard code the 19
                    validInput = true;
                }
            }
        }

        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("- _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - ");
        System.out.println("W E L C O M E  T O  T H E  D U C K R A C E  A P P L I C A T I O N");
        System.out.println("- _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - ");
    }
}