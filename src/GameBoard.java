import java.util.Arrays;

class GameBoard {
    final char[][] gameboard;
    final char[][] chessboard;
    static final int n = 3;

    GameBoard() {
        gameboard = new char[2*n-1][2*n-1];
        chessboard = new char[n][n];

        for (char[] c : chessboard) Arrays.fill(c, ' ');

        for (int i = 1; i < 2*n-1; i+=2) {
            for (int j = 0; j < gameboard[0].length; j++) {
                gameboard[i][j] = '-';
            }
        }

        for (int i = 0; i < 2*n-1; i+=2) {
            for (int j = 1; j < gameboard[0].length; j+=2) {
                gameboard[i][j] = '|';
            }
            for (int j = 0; j < gameboard[0].length; j+=2) {
                gameboard[i][j] = ' ';
            }
        }
    }
}
