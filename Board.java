import java.util.Arrays;

public class Board {

    // values
    char [][] board;
    int dimension;
    BoardChecker board_check;

    // constructor
    Board (int n) {
        board = new char[n][n];
        for (char[] row : board) 
            Arrays.fill(row, ' '); 
        dimension = n;
        board_check = new BoardChecker();
    }

    // methods
    public void print_board() {
        // print row and col values
        System.out.print(" ");
        for (int i = 0; i < dimension; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < dimension; i++) {
            System.out.print(i);
            for (int j = 0; j < dimension; j++) {
                System.out.print(" " + board[i][j]);
            }
        System.out.println();
        }
    }

    public boolean place_piece(int row, int col, char y) {
        if (board[row][col] == ' ') {
            board[row][col] = y;
            return true;
        }
        return false;
    }

    public class BoardChecker {

        BoardChecker() {
            array = new int[dimension];
            Arrays.fill(array, ' ');
        }
        // index = column, value at index = row
        int [] array;

        public boolean win_cond_helper(char character, int column) { 
            if (column == dimension) { 
                return true; // have not failed in any column
            }
            // look at each value: is the row full? If not, add exactly one value from the column
            // to the array with index = row of origin
            for (int i = 0; i < dimension; i++) { 
                if (array[i] == ' ' && board[i][column] == character) {
                    array[i] = column;
                    if (win_cond_helper(character, (column + 1))) {
                        return true;
                    }
                    else {
                        array[i] = ' ';
                    }
                }
            }
            return false;
        }

        // only returns true when we are on the last column
        // char x is the value we are looking for (true = X or false = O)
        public boolean win_condition_check(char x) {
            return win_cond_helper(x, 0);
            }
        }
    
    public static void main(String[] args) {
        Board current_board = new Board(5);
        current_board.print_board();
    }
}