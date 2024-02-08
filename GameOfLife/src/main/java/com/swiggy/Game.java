package com.swiggy;

public class Game {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        int rows = consoleInput.getRowsInput();
        int column = consoleInput.getColumnsInput();
        double percentage = consoleInput.getPercentageInput();

        Board board = new Board(rows,column,percentage);

        if (!board.canEvolve()) System.out.println("Board is in stable state, Game ended!");

        while (board.canEvolve()) {
            board.display();
            board.nextGeneration();
        }
    }
}
