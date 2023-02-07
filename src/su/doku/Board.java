/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.doku;

//data structure to store my board and the cell id's

public class Board {
    private static int[][] board; // board
    private static CellId[] cellId; // the cell id's
    private static Board boardInstance = null;

    /**
     * constructor
     * 
     * @param b
     * @param id
     */
    private Board(int[][] b, CellId[] id) {

        board = b;
        cellId = id;

    }

    /**
     * function to create a new board
     * 
     * @param b
     * @param id
     * @return Board - the board instance
     */
    public static Board newBoard(int[][] b, CellId[] id) {

        if (boardInstance == null) {

            boardInstance = new Board(b, id);

        }

        return boardInstance;
    }

    /**
     * function to get the board
     * 
     * @return int[][] - the board
     */
    public int[][] getBoard() {

        return board;

    }

    /**
     * function to get the cell ID's
     * 
     * @return CellId[] - the cell id's
     */
    public CellId[] getCellId() {

        return cellId;

    }
}
