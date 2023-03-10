import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    initializeBoard(board);

    Scanner scanner = new Scanner(System.in);
    char currentPlayer = 'X';

    while (true) {
      printBoard(board);

      System.out.println("Player " + currentPlayer + ", please enter your move (row[1-3] column[1-3]):");
      int row = scanner.nextInt() - 1;
      int col = scanner.nextInt() - 1;

      if (isValidMove(board, row, col)) {
        board[row][col] = currentPlayer;

        if (isWinner(board, currentPlayer)) {
          printBoard(board);
          System.out.println("Player " + currentPlayer + " wins!");
          break;
        }

        if (isTie(board)) {
          printBoard(board);
          System.out.println("It's a tie!");
          break;
        }

        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
      } else {
        System.out.println("Invalid move. Please try again.");
      }
    }
  }

  private static void initializeBoard(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = '-';
      }
    }
  }

  private static void printBoard(char[][] board) {
    System.out.println("   1 2 3");
    for (int i = 0; i < board.length; i++) {
      System.out.print((i + 1) + " ");
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static boolean isValidMove(char[][] board, int row, int col) {
    if (row < 0 || row > 2 || col < 0 || col > 2) {
      return false;
    }
    return board[row][col] == '-';
  }

  private static boolean isWinner(char[][] board, char player) {
    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
        return true;
      }
      if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
        return true;
      }
    }
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
    return false;
  }

  private static boolean isTie(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '-') {
          return false;
        }
      }
    }
    return true;
  }
}
