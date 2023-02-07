package su.doku;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.imageio.ImageIO;

public class BoardHandler {

    /**
     * function to read a board from a txt file
     * 
     * @return Board - a Board object of the board in the txt
     * @throws IOException
     */
    public static Board readBoard(String filePath) throws IOException {

        // reads the txt
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        // length of the board
        int length = 0;
        // width of the board
        int width = 0;
        // all of numbers in the board
        String numbers = "";
        while ((st = br.readLine()) != null) {
            // System.out.println(st);
            numbers += st;
            width = st.length();
            length++;
        }

        numbers = numbers.replaceAll("\\s", "0"); // replace all spaces with 0

        // fill the numbers from the txt into a 2D array
        int[][] board = new int[width][length];
        int numIndex = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {

                board[j][i] = Character.getNumericValue(numbers.charAt(numIndex));
                numIndex++;

            }
        }
        // create the cell id's for the grid

        // returns the sudoku board
        return Board.newBoard(board, createCellId());
    }

    /**
     * function to check if a given number is in at least the given grid, row, or
     * column
     * 
     * @param b         - the board to search
     * @param x         - the column to check
     * @param y         - the row to check
     * @param searchNum - the number to check for
     * @return boolean - true if the number is found, false otherwise
     */
    public static boolean searchBoard(Board b, int x, int y, int searchNum) {

        boolean found = false;

        // search row
        for (int i = 0; i < b.getBoard()[0].length; i++) {
            if (b.getBoard()[i][y] == searchNum) {
                found = true;
                return found;
            }
        }

        // search column
        for (int i = 0; i < b.getBoard()[0].length; i++) {
            if (b.getBoard()[x][i] == searchNum) {
                found = true;
                return found;
            }
        }

        // search square
        int square = 0;

        // gets which square the given cell is in
        for (int i = 0; i < b.getCellId().length; i++) {

            if ((x >= b.getCellId()[i].getX()) && (x <= b.getCellId()[i].getX() + 2) && (y >= b.getCellId()[i].getY())
                    && (y <= b.getCellId()[i].getY() + 2)) {
                square = i;
                break;
            }

        }
        // gets all the numbers in the square
        int[] numsInSquare = getSquareNums(b, square);

        // compares all the numbers in the square to the number that we are looking for
        for (int i = 0; i < numsInSquare.length; i++) {
            if (numsInSquare[i] == searchNum) {

                found = true;
                break;
            }

        }

        return found;
    }

    /**
     * function to return all the numbers inside a given square
     * 
     * @param b      - the board to get the square from
     * @param square - the square to get
     * @return int[] - an array of all the numbers in the given square in the given
     *         board
     */
    private static int[] getSquareNums(Board b, int square) {

        int[] nums = new int[9];

        int cell = 0;

        // loops through each cell in that square and adds it's value to an array to be
        // returned
        for (int x = b.getCellId()[square].getX(); x < b.getCellId()[square].getX() + 3; x++) {
            for (int y = b.getCellId()[square].getY(); y < b.getCellId()[square].getY() + 3; y++) {

                nums[cell] = b.getBoard()[x][y];
                cell++;
            }

        }

        return nums;

    }

    // creates the id's of each square (the coordinate of the top right cell of each
    // square)

    /**
     * function to generate all the CellId's of each square (the top left cell of
     * each square)
     * 
     * @return CellId[] an array of all the cell id's
     */
    private static CellId[] createCellId() {

        CellId[] cellId = new CellId[9];

        cellId[0] = new CellId(0, 0);
        cellId[1] = new CellId(3, 0);
        cellId[2] = new CellId(6, 0);
        cellId[3] = new CellId(0, 3);
        cellId[4] = new CellId(3, 3);
        cellId[5] = new CellId(6, 3);
        cellId[6] = new CellId(0, 6);
        cellId[7] = new CellId(3, 6);
        cellId[8] = new CellId(6, 6);

        return cellId;

    }

    /**
     * function to write the solution to a file
     * 
     * @param b - the board to write
     * @throws IOException
     */
    public static void wrightSolution(Board b, String filePath) throws IOException {

        // Specify the file name and path here
        File file = new File("solution.txt");
        BufferedWriter bw = null;
        /*
         * This logic will make sure that the file
         * gets created if it is not present at the
         * specified location
         */
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);

        // wrights the solution to the txt
        for (int i = 0; i < b.getBoard().length; i++) {
            for (int j = 0; j < b.getBoard()[0].length; j++) {

                bw.write(String.valueOf(b.getBoard()[j][i]));

            }
            bw.newLine();
        }
        bw.close();

    }

}
