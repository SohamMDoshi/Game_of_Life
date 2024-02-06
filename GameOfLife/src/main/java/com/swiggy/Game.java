package com.swiggy;

public class Game {
    public static void main(String[] args) {
        InputTaking inputTaking = new InputTaking();
        int rows = inputTaking.getRowsInput();
        int column = inputTaking.getColumnsInput();
        double percentage = inputTaking.getPercentageInput();

        Board board = new Board(rows,column,percentage);
        board.initializeBoard();

        LifeSimulation simulation = new LifeSimulation(board);
        while (simulation.liveCellCount() > 0) {
            simulation.nextGeneration();
        }
    }
}
