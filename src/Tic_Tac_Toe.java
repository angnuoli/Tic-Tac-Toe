class Tic_Tac_Toe {
    private final GameBoard gameBoard = new GameBoard();
    private final CheckGameStatus checkGameStatus;
    private int playTurn;
    private static final char[] chess = new char[]{'X', 'O'};
    private int playcount = 0;

    Tic_Tac_Toe() {
        this.checkGameStatus = new CheckGameStatus(this.gameBoard);
        playTurn = 0;
        System.out.println("New Game, have fun!");
        printGameBoard();
        System.out.print("First play: ");
    }

    boolean play(int x, int y) {
        if (!checkGameStatus.isValidPlay(x, y)) {
            System.out.println("Invalid play!");
            System.out.println("Play again: ");
            return false;
        }

        gameBoard.gameboard[2*x][2*y] = chess[playTurn];
        gameBoard.chessboard[x][y] = chess[playTurn];
        playcount++;
        printGameBoard();
        if (checkGameStatus.isWin(x, y)) {
            if (playTurn == 0) System.out.println("You win!");
            else System.out.println("You lose.");
            return true;
        } else {
            if (playcount == 9) {
                System.out.println("Game over. No winner.");
                return true;
            }
            System.out.print("Next play: ");
        }
        playTurn = (playTurn+1) % 2;
        return false;
    }

    private void printGameBoard() {
        for (int i = 0; i < gameBoard.gameboard.length;i++) {
            System.out.println(new String(gameBoard.gameboard[i]));
        }
    }
}
