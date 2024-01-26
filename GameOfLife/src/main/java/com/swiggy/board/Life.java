package com.swiggy.board;

import static com.swiggy.board.Board.COLS;
import static com.swiggy.board.Board.ROWS;

public class Life {

    public static int countNeighbors (int row, int col, Board board) {
        int count =0;
        for(int r = row -1; r <= row +1; r++) {
            for(int c = col-1; c <= col +1; c++) {
                if(r >= 0 && r < ROWS && c >= 0 && c < COLS && !(r == row && c == col) && board.getValue(r, c) == 1) {
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
                if (currentBoard.getValue(r,c) == 1 && neighborsCount < 2) {
                    nextBoard.setValue(r,c,0);
                }
                else if(currentBoard.getValue(r,c) == 1 && neighborsCount < 4) {
                    nextBoard.setValue(r,c,1);
                }
                else if(currentBoard.getValue(r,c) == 1 && neighborsCount > 3) {
                    nextBoard.setValue(r,c,0);
                }
                else if(currentBoard.getValue(r,c) == 0 && neighborsCount ==3) {
                    nextBoard.setValue(r,c,1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Board board = new Board(ROWS,COLS);
        board.initializeBoard();
        board.DisplayBoard();
    }
}
