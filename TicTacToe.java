import java.util.Scanner;

public class TicTacToe 
{
    private static final char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        initializeBoard();

        boolean gameOver = false;
        while (!gameOver) 
        {
            displayBoard();
            System.out.print("Player " + currentPlayer + ", enter your move (row [0-2] and column [0-2]): ");
            int row = input.nextInt();
            int col = input.nextInt();

            if (isValidMove(row, col)) 
            {
                board[row][col] = currentPlayer;

                if (checkWin(row, col)) 
                {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } 
                else if (isBoardFull()) 
                {
                    displayBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } 
                else 
                {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch players
                }
            } 
            else 
            {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void initializeBoard() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() 
    {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) 
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isValidMove(int row, int col) 
    {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean checkWin(int row, int col) 
    {
        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) 
        {
            return true;
        }
        if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) 
        {
            return true;
        }
        if (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) 
        {
            return true;
        }
        if (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) 
        {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (board[i][j] == ' ') 
                {
                    return false;
                }
            }
        }
        return true;
    }
}