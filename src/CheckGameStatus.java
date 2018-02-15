class CheckGameStatus {
    private final GameBoard gameBoard;

    CheckGameStatus(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean isValidPlay(int x, int y) {
        return x >= 0 && x < gameBoard.n && y >= 0 && y < gameBoard.n && gameBoard.chessboard[x][y] == ' ';
    }

    public boolean isWin(int x, int y) {
        return isRowWin(x, y) || isColWin(x, y) || isDiagWin(x, y) || isBackDiagWin(x, y);
    }

    private boolean isRowWin(int x, int y) {
        for (int j = 0; j < gameBoard.n; j++) {
            if (gameBoard.chessboard[x][j] != gameBoard.chessboard[x][y]) return false;
        }
        return true;
    }

    private boolean isColWin(int x, int y) {
        for (int i = 0; i < gameBoard.n; i++) {
            if (gameBoard.chessboard[i][y] != gameBoard.chessboard[x][y]) return false;
        }
        return true;
    }

    private boolean isDiagWin(int x, int y) {
        int count = 0;
        for (int i = x, j = y; i < gameBoard.n && j < gameBoard.n; i++, j++) {
            if (gameBoard.chessboard[x][y] == gameBoard.chessboard[i][j]) count++;
        }

        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (gameBoard.chessboard[x][y] == gameBoard.chessboard[i][j]) count++;
        }

        return count - 1 == gameBoard.n;
    }

    private boolean isBackDiagWin(int x, int y) {
        int count = 0;
        for (int i = x, j = y; i >= 0 && j < gameBoard.n; i--, j++) {
            if (gameBoard.chessboard[x][y] == gameBoard.chessboard[i][j]) count++;
        }

        for (int i = x, j = y; i < gameBoard.n && j >= 0; i++, j--) {
            if (gameBoard.chessboard[x][y] == gameBoard.chessboard[i][j]) count++;
        }

        return count - 1 == gameBoard.n;
    }
}
