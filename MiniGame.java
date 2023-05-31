
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
            aiCoinInsert(map, playerRow, playerRow);
            prnMap(map, playerCol, sprite, playerRow, coins);

            String input = in.nextLine();
            String[] inputWords = input.split(",");
            int colMove = 0;

            if (inputWords[0].equals("col")) {
                colMove = Integer.parseInt(inputWords[1]);

            } else if (inputWords[0].equals("coin")) {

                insertCion(map, playerCol, playerRow);
                doneCheck(map);
            }

            if (canMove(map, colMove)) {
                playerCol = colMove;
            }

        }
        Text(done);

    }

    /*
     * loads and up dates game map
     */
    public static int[][] loadMap() {
        int[][] map = {
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 }
        };

        return map;
    }

    /*
     * prints the map and refreshes of location player and coins
     * PlayerCol and PlayerRow are used to print cocation of sprite,
     * coins is used to print o where ever there is a one on the map
     * map is used to display every thing like coins and the player sprite
     */

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

    /*
     * prints coins and stacks them on top of each other where ever the sprite is
     * when "coin" is entered
     * uses playerCol and PlayerRow is to locate coin on map
     * map is used to store a 1 where ever the coin is placed by the player
     */
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

    /*
     * checks if there is four or more then 4 coins in a line
     * map is used to cheque cordnats [i][j] to see if they =1
     */

    public static boolean doneCheck(int map[][]) {

        // checks columns and rows for "1". if there are four "1"'s in a row it ends
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
                // diaganal top left to bottom right
                if (i <= 2 && j < map[i].length - 3 && map[i][j] == 1 && map[i + 1][j + 1] == 1
                        && map[i + 2][j + 2] == 1
                        && map[i + 3][j + 3] == 1) {
                    done = true;
                }
                // diagnal bottom left to top right
                if (i >= 3 && j < map[i].length - 3 && map[i][j] == 1 && map[i - 1][j + 1] == 1
                        && map[i - 2][j + 2] == 1
                        && map[i - 3][j + 3] == 1) {
                    done = true;
                }
            }
        }
        return done;

    }

    /*
     * checks if the players move is legal
     * map is used to see if move is with in bouds
     * col is used to see where the player wants to move
     */
    public static boolean canMove(int[][] map, int col) {
        int row = 0;
        if (col < 0 || col >= map[row].length)
            return false;

        return map[row][col] == 0;
    }

    // AI is now unbeatble but still dose not work properly
    public static void aiCoinInsert(int map[][], int playerCol, int playerRow) {
        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {
                // collums
                if (j < map[i].length - 3 && map[i][j] == 1 && map[i][j + 1] == 1 && map[i][j + 2] == 1
                        && map[i][j + 3] == 1) {
                    map[i][j] = 2;

                }
                // rows
                if (i < map[i].length - 4 && map[i][j] == 1 && map[i + 1][j] == 1 && map[i + 2][j] == 1
                        && map[i + 3][j] == 1) {
                    map[i][j] = 2;
                }
                // diaganal top left to bottom right
                if (i <= 2 && j < map[i].length - 3 && map[i][j] == 1 && map[i + 1][j + 1] == 1
                        && map[i + 2][j + 2] == 1
                        && map[i + 3][j + 3] == 1) {
                    map[i][j] = 2;
                }
                // diagnal bottom left to top right
                if (i >= 3 && j < map[i].length - 3 && map[i][j] == 1 && map[i - 1][j + 1] == 1
                        && map[i - 2][j + 2] == 1
                        && map[i - 3][j + 3] == 1) {
                    map[i][j] = 2;
                }
            }

        }
       
    }

    /*
     * holds the instrutions and other information for the user
     * done is used to print game over
     */
    public static void Text(boolean done) {
        if (done == true) {
            prn("Game over! You wone");
        }else{
        prn("welcome to Connect four, please slect a row to place your piece\nTo place a coin type \"coin\"\nTo move to a diffrent column Type \"col,number\"\nYour sprit is \"!\"\n");
        enter();
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