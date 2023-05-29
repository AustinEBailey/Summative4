
import java.util.Scanner;

public class MiniGame {
    static int coinNum = 0;
    static boolean done;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        clrscn();
        Text(done);
        int[][] map = loadMap();
        String[] coins = { "0", "o", "x" };

        String sprite = "!";
        int playerCol = 0;
        int playerRow = 0;

        while (done != true) {

            clrscn();
            // aiCoinInsert(map, playerRow, playerRow);
            prnMap(map, playerCol, sprite, playerRow, coins);

            String input = in.nextLine();
            String[] inputWords = input.split(",");
            int colMove = 0;

            if (inputWords[0].equals("col")) {
                colMove = Integer.parseInt(inputWords[1]);

            } else if (inputWords[0].equals("coin")) {

                insertCion(map, playerCol, playerRow);
                doneCheck(map, playerRow, playerRow);
            }

            if (canMove(map, colMove)) {
                playerCol = colMove;
            }

        }
        prn("Game over!");

    }

    // dose the initialization of the map
    public static int[][] loadMap() {
        int[][] map = {
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 2, 0, 0, 0 },
                { 0, 0, 2, 2, 0, 0, 0 },
                { 0, 2, 2, 2, 0, 0, 0 }
        };

        return map;
    }

    // prints the map.
    public static void prnMap(int[][] map, int playerCol, String sprite, int playerRow, String[] coins) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if ((i == playerRow && j == playerCol)) {
                    prn(sprite);

                } else {
                    int prnMap = map[i][j];
                    prn(coins[prnMap]);
                }
            }
            System.out.println();
        }
    }

    // prints coins where ever the sprite is when "c" is entered
    public static void insertCion(int[][] map, int playerCol, int playerRow) {
        int count = 0;
        for (int i = 5; i > 0; i--) {
            if (map[i][playerCol] != 0) {
                count = 0;
            } else {
                count++;
            }
        }
        map[count][playerCol] = 1;

    }

    // checks if there is four or more then one coin in a line
    public static boolean doneCheck(int map[][], int playerRow, int playerCol) {

        // cheks collums and rows for "1" and if there are four "1"'s in a row it ends
        // the game
        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {
                // collums
                if (j < map[i].length - 3 && map[i][j] == 1 && map[i][j + 1] == 1 && map[i][j + 2] == 1
                        && map[i][j + 3] == 1) {
                    done = true;
                }
                // rows
                if (i < map[i].length - 4 && map[i][j] == 1 && map[i + 1][j] == 1 && map[i + 2][j] == 1
                        && map[i + 3][j] == 1) {
                    done = true;
                }
                // diaganal left
                if (i < map[i].length - 4 && map[i][j] == 1 && map[i + 1][j + 1] == 1 && map[i + 2][j + 2] == 1
                        && map[i + 3][j + 3] == 1) {
                    done = true;
                }
                // diagnal right
                if (i < map[i].length - 4 && map[i][j] == 1 && map[i + 5][j + 1] == 1 && map[i + 4][j + 2] == 1
                        && map[i + 3][j + 3] == 1) {
                    done = true;
                }
            }

        }
        return done;

    }

    // checks if the players move is legal
    public static boolean canMove(int[][] map, int col) {
        int row = 0;
        if (col < 0 || col >= map[row].length)
            return false;

        return map[row][col] == 0;
    }

    // dose nothing right now
    public static void aiCoinInsert(int map[][], int playerRow, int playerCol) {
        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {
                // collums
                if (j < map[i].length - 3 && map[i][j] == 1 && map[i][j + 1] == 1 && map[i][j + 2] == 1) {
                    done = true;
                }
                // rows
                if (i < map[i].length - 4 && map[i][j] == 1 && map[i + 1][j] == 1 && map[i + 2][j] == 1
                        && map[i + 3][j] == 1) {
                    done = true;
                }
                // diaganal left
                if (i < map[i].length - 4 && map[i][j] == 1 && map[i + 1][j + 1] == 1 && map[i + 2][j + 2] == 1
                        && map[i + 3][j + 3] == 1) {
                    done = true;
                }
            }
        }

    }

    // holds the instrutions and other information for the user
    public static void Text(boolean done) {
        prn("welcome to Connect four, please slect a row to place your piece\nTo place a coin type \"coin\"\nTo move to a diffrent Collum Type \"col,number\"\nYour sprit is \"!\"\n");
        enter();
        if (done == true) {
            prn("Game over!");
        }

    }

    // print stuff
    public static <T> void prn(Object object) {
        System.out.print(object);
    }

    // clear screen
    public static void clrscn() {
        prn("\033[2J");
    }

    // press enter to continue
    public static String enter() {
        Scanner in = new Scanner(System.in);
        prn("Press Enter To Continue");
        String user = in.nextLine();
        return user;
    }

}