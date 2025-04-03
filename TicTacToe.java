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
            int column = input.nextInt();

            if (isValidMove(row, column)) 
            {
                board[row][column] = currentPlayer;

                if (checkWin(row, column)) 
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
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
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

    private static boolean isValidMove(int row, int column) 
    {
        return row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] == ' ';
    }

    private static boolean checkWin(int row, int column) 
    {
        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) 
        {
            return true;
        }
        if (board[0][column] == currentPlayer && board[1][column] == currentPlayer && board[2][column] == currentPlayer) 
        {
            return true;
        }
        if (row == column && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) 
        {
            return true;
        }
        if (row + column == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) 
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
