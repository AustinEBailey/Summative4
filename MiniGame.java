import java.util.Scanner;

public class MiniGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        clrscn();
        prn("welcome to Connect four please slect a row to place your piece");

        int[][] map = loadMap();
        String[] coins = { "0", "o" };

        String sprite = "!";
        int playerCollum = 0;
        int playerRow = 0;

        boolean done = false;
        while (!done) {
            int row = 0;
            int collum = 0;
            prn("\033[H\033[2J");
            prnMap(map, playerCollum, sprite, playerRow, coins);
            String input = in.nextLine();
            String[] inputWords = input.split(",");
            if(inputWords[0].equals("collum")) {
                playerCollum  = Integer.parseInt(inputWords[1]);
            }else if (inputWords[0].equals("coin")) {
                insertCion(map, playerCollum, playerRow);
            }

        }
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
                    System.out.print(coins[prnMap]);
                }
            }
            System.out.println();
        }
    }

    // prints coins where ever the sprite is when "c" is entered
    public static void insertCion(int[][] map, int playerCollum, int playerRow) {

        if (map[playerRow][playerCollum] != 0) {
            // it dose nothing exep prevent coins from being placed in the same place.
        } else {
            map[playerRow][playerCollum] = 1;
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
    public static void enter() {
        Scanner in = new Scanner(System.in);
        prn("Press Enter To Continue");
        String user = in.nextLine();
    }

}