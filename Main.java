package tictactoe;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[] input = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        int turn = 1;
        printTheBoard(input, turn);
        checkinput(input, turn);
    }

    private static void printTheBoard(char[] board, int turn) {
        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println(String.format("| %c %c %c |", board[i], board[i + 1], board[i + 2]));
        }
        System.out.println("---------");
        analyzeGameState(board, turn);

    }

    private static void analyzeGameState(char[] board, int turn) {
        int xCount = 0;
        int oCount = 0;

        for (char c : board) {
            if (c == 'X')
                xCount++;
            else if (c == 'O')
                oCount++;
        }

        boolean xWins = checkWin(board, 'X');
        boolean oWins = checkWin(board, 'O');

        if (xWins && oWins || Math.abs(xCount - oCount) > 1) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
            System.exit(0);
        } else if (oWins) {
            System.out.println("O wins");
            System.exit(0);
        } else if (xCount + oCount == 9) {
            System.out.println("Draw");
            System.exit(0);
        } else {
            checkinput(board, turn);
        }
    }

    private static boolean checkWin(char[] board, char player) {
        int[][] winPositions = {
                { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, // rows
                { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // columns
                { 0, 4, 8 }, { 2, 4, 6 } // diagonals
        };

        for (int[] pos : winPositions) {
            if (board[pos[0]] == player && board[pos[1]] == player && board[pos[2]] == player) {
                return true;
            }
        }
        return false;
    }

    private static void checkinput(char[] board, int turn) {
        if (!sc.hasNextInt()) {
            System.out.println("You should enter numbers!");
            checkinput(board, turn);
        } else {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x > 3 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                checkinput(board, turn);
            } else {
                if (!(board[(x - 1) * 3 + y - 1] == ' ')) {
                    System.out.println("This cell is occupied! Choose another one!");
                    checkinput(board, turn);
                } else {
                    if (turn % 2 == 1) {
                        board[(x - 1) * 3 + y - 1] = 'X';
                        turn++;
                        printTheBoard(board, turn);
                    } else {
                        board[(x - 1) * 3 + y - 1] = 'O';
                        turn++;
                        printTheBoard(board, turn);

                    }

                }
            }
        }
    }
}