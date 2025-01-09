package leetcode_challenges.mapsandheaps;

import java.util.HashSet;
import java.util.Set;

/**
 * Sudoku are:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 sub-boxes (3x3 grids) must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * The Sudoku board might be partially filled, so empty cells are represented by the character '.'.
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '5', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board)); // Output: false
    }

    private static boolean isValidSudoku(char[][] board) {
        // Use sets to track seen numbers
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] boxSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        // iterate through each cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];

                if (value == '.') continue;

                if (rowSet[i].contains(value)) return false;

                if (colSet[i].contains(value)) return false;

                // calculate the bx number that value belongs to
                // using formula boxIndex = (i/3) * 3 + (j/3)

                int boxIndex = (i / 3) * 3 + (j / 3);

                if (boxSet[boxIndex].contains(value)) return false;

                boxSet[boxIndex].add(value);
                colSet[i].add(value);
                rowSet[i].add(value);
            }

        }

        return true;
    }
}
