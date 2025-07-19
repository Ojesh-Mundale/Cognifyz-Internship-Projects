import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            char currentPlayer = 'X';
            boolean gameWon = false;

            for (int turn = 1; turn <= 9; turn++) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + ", enter row and column (1-3): ");
                int row = scanner.nextInt() - 1, col = scanner.nextInt() - 1;

                if (board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    if (checkWinner(board, currentPlayer)) {
                        printBoard(board);
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameWon = true;
                        break;
                    }
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Invalid move, try again.");
                    turn--;  
                }
            }

            if (!gameWon) {
                printBoard(board);
                System.out.println("It's a draw!");
            }

            System.out.print("Play again? (y/n): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Function to print the game board
    public static void printBoard(char[][] board) {
        System.out.println("-----");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    
    public static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || 
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
