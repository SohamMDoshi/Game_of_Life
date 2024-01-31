package com.swiggy.board;
public class Game {

    public static void clearConsole() {
        System.out.print("\u000C");
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder("clear");
//            Process startProcess = processBuilder.inheritIO().start();
//            startProcess.waitFor();
//        }catch (Exception e) {
//            System.out.print(e.getMessage());
//        }
    }

    public static void slow() {
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Board board = new Board(3,5,0.50);
        board.initializeBoard();
        int generation = 0;
        while (board.getCountOfAliveCells() > 0) {
            clearConsole();
            board.DisplayBoard();
            slow();
            System.out.println("Generation : " + ++generation);
            board.nextGeneration();
        }
    }
}
