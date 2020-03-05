import java.util.*;

public class Gameplay {
    int turns_wo_check;
    Board board;
    Scanner scanner;

    Gameplay(int dimension) {
        turns_wo_check = dimension + dimension - 2;
        board = new Board(dimension);
        scanner = new Scanner(System.in);
    }

    void take_turn(char current_player) {
        int row = -1, col = -1;
        do {
            try {
            System.out.println("Please enter the row: ");
            row = Integer.parseInt(scanner.nextLine());
            System.out.println("Please enter the column: ");
            col = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid row/column"); 
            }
        } while (row > -1 && col > -1 && row < board.dimension && col < board.dimension);
        
        if (!board.place_piece(row, col, current_player)) {
            System.out.println("Please enter in an empty spot.");
            take_turn(current_player);
        }
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in); 
        String dimension;
        int col = 0;
        do {
            System.out.println("Please enter integer value of rows/columns: ");
            dimension = sc.nextLine();
            try {
                col = Integer.parseInt(dimension);
            }
            catch (NumberFormatException e) {
                System.out.println("You did not enter an integer.");
            }
        } while (col < 1);

        Gameplay current = new Gameplay(col);
        sc.close();
    }
}