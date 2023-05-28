
import java.util.Scanner;

public class MiniGame {
    static int coinNum = 0;
    static boolean done;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        clrscn();
        prn("welcome to Connect four please slect a row to place your piece\n To place a coin type coin\n To move to a diffrent Collum Type collum,number\n"
                + enter());

        int[][] map = loadMap();
        String[] coins = { "0", "o", "x" };

        String sprite = "!";
        int playerCollum = 0;
            int playerRow = 0;

        while (done != true) {
            
            prn("\033[H\033[2J");

            // aiCoinInsert(map, playerRow, playerRow);
            prnMap(map, playerCollum, sprite, playerRow, coins);

            String input = in.nextLine();
            String[] inputWords = input.split(",");
            int colMove = 0;
            if (inputWords[0].equals("collum")) {
                colMove = Integer.parseInt(inputWords[1]);

            } else if (inputWords[0].equals("coin")) {
                doneCollumCheck(map, playerRow, playerRow);
                insertCion(map, playerCollum, playerRow);

            }

            if (canMove(map,colMove)) {
                playerCollum = colMove ;
            }

        }
        prn("Game over");
    }

    

    // dose the initialization of the map
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

    // prints the map.
    public static void prnMap(int[][] map, int playerCollum, String sprite, int playerRow, String[] coins) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if ((i == playerRow && j == playerCollum)) {
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
    public static void insertCion(int[][] map, int playerCollum, int playerRow) {
        int count = 0;
        for (int i = 5; i > 0; i--) {
            if (map[i][playerCollum] != 0) {
                count = 0;
            } else {
                count++;
            }
        }
        map[count][playerCollum] = 1;

    }

    public static boolean doneCollumCheck(int map[][], int playerRow, int playerCollum) {
        int j = 0;
        int i = 0;
        for (i = 0; i < map.length; i++) {

            for (j = 0; j < map[i].length; j++) {

                if (map[i][j] != 0) {
                    coinNum++;
                } else if (coinNum >= 4) {
                    done = true;
                } else {
                    coinNum = 0;
                }
            }

        }
        return done;
    }

    public static boolean canMove(int[][] map, int col) {
        int row=0;
        if (col < 0 || col >= map[row].length)
            return false;
        
        return map[row][col] == 0;
    }

    public static void aiCoinInsert(int map[][], int playerRow, int playerCollum) {
        int i = 0;
        int j = 0;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
            }
        }
        if (i > 2 || j > 2) {
            map[i][playerCollum] = 2;
        }

    }

    // print stuff
    public static <T> void prn(T stuff) {
        System.out.print(stuff);
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