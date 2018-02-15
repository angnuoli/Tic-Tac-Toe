import java.util.Scanner;

class Tic_Tac_Toe_Game {
    public static void main(String args[]) {
        Tic_Tac_Toe_Game tic_tac_toe_game = new Tic_Tac_Toe_Game();
        tic_tac_toe_game.run();
    }

    private void run() {
        Tic_Tac_Toe tic_tac_toe = new Tic_Tac_Toe();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String play = scanner.nextLine();

            if (play.equals("New Game")) {
                tic_tac_toe = new Tic_Tac_Toe();
            } else {
                Scanner scanner1 = new Scanner(play);
                int x, y;
                if (scanner1.hasNextInt()) x = scanner1.nextInt();
                else {
                    System.out.println("Invalid Input.");
                    System.out.println("Play again: ");
                    continue;
                }
                if (scanner1.hasNextInt()) y = scanner1.nextInt();
                else {
                    System.out.println("Invalid Input.");
                    System.out.println("Play again: ");
                    continue;
                }

                if (tic_tac_toe.play(x, y)) return;
            }
        }
    }
}
