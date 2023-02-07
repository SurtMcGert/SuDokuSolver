/*This is a sudoku solver, it reads the board from a txt file
 * and uses a backtracking algorithm to solve the puzzle
 * 
 * 
 */
package su.doku;

import java.io.IOException;

public class SuDoku {

    String boardFile = "board.txt"; // the file name of the board to load
    String solutionFile = "solution.txt"; // the file name of the solution file
    Board board; // the sudoku board

    // main method
    public static void main(String[] args) throws IOException {
        // runs constructor
        new SuDoku();

    }

    /**
     * constructor
     * 
     * @throws IOException
     */
    public SuDoku() throws IOException {

        // reads the board
        this.board = BoardHandler.readBoard(this.boardFile);
        // puts the board through a backtracking algorithm
        System.out.println(backTrack(board));
        // saves solution to a txt
        BoardHandler.wrightSolution(board, this.solutionFile);

        System.out.println("solved");

    }

    // recursive function running a back tracking algorithm

    /**
     * function to recursively find a solution to the sudoku
     * 
     * @param b - the board to solve
     * @return int - 1 if a solution was found, 0 if no solution was found
     */
    private int backTrack(Board b) {

        int currentNum = 1; // the current number we are tying to add to the cell

        // finds the next empty cell in the grid
        for (int i = 0; i < b.getBoard().length; i++) {
            for (int j = 0; j < b.getBoard()[0].length; j++) {

                // if the cell is empty
                if (b.getBoard()[i][j] == 0) {

                    // loops through each possible number that could go in this cell
                    while (currentNum <= 9) {

                        // if the number that we are trying to add isnt already in the cells roe, column
                        // or square then set the value of the cell to that number
                        if (BoardHandler.searchBoard(b, i, j, currentNum) == false) {

                            b.getBoard()[i][j] = currentNum;
                            // if the next cell returns completed, return completed
                            if (backTrack(b) == 0) {

                                return 0;

                                // otherwise try a new number in this cell
                            } else {

                                currentNum++;

                            }

                        } else {
                            currentNum++;
                        }

                    }
                    // if no numbers 1-9 will fit in this cell, set the cell to 0 so it can be found
                    // again and return 1 to indicate an error
                    b.getBoard()[i][j] = 0;
                    return 1;

                }

            }

        }
        board = b;
        return 0;
    }

}
