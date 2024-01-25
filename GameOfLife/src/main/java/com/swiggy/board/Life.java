package com.swiggy.board;

public class Life {
    private static final int ROWS = 20;
    private static final int COLS = 80;

    private static final double probabilityOfLife = 0.2;

    public static void initializeBoard(Board board) {
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                double chance = Math.random();
                if(chance < probabilityOfLife) board.set(r,c,1);
            }
        }
    }


    public static int countNeighbors (int row, int col, Board board) {
        int count =0;
        for(int r = row -1; r <= row +1; r++) {
            for(int c = col-1; c <= col +1; c++) {
                if(r >= 0 && r < ROWS && c >= 0 && c < COLS && !(r == row && c == col) && board.get(r, c) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void calculateNextGeneration(Board currentBoard, Board nextBoard) {
        for (int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                int neighborsCount = countNeighbors(r,c,currentBoard);
                if (currentBoard.get(r,c) == 1 && neighborsCount < 2) {
                    nextBoard.set(r,c,0);
                }
                else if(currentBoard.get(r,c) == 1 && neighborsCount < 4) {
                    nextBoard.set(r,c,1);
                }
                else if(currentBoard.get(r,c) == 1 && neighborsCount > 3) {
                    nextBoard.set(r,c,0);
                }
                else if(currentBoard.get(r,c) == 0 && neighborsCount ==3) {
                    nextBoard.set(r,c,1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Board board = new Board(ROWS,COLS);
        initializeBoard(board);
        board.DisplayBoard();
    }
}
