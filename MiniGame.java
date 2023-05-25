import java.util.Scanner;

public class MiniGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        clrscn();
        prn("welcome to Connect four please slect a row to place your piece");

        int[][] map = loadMap();
        String[] coins = { "0", "o" };

        String sprite = "!";
        int pCollum = 0;
        int pRow = 0;

        boolean done = false;
        while (!done) {

            prn("\033[H\033[2J");
            prnMap(map, pCollum, sprite, pRow, coins);
            String input = in.nextLine();

            if (input.equals("l")) {
                pCollum--;
            } else if (input.equals("r")) {
                pCollum++;
            } else if (input.equals("c")) {
                coin(map, pCollum);
            }

        }
    }

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
    public static void prnMap(int[][] map, int pCollum, String sprite, int pRow, String[] coins) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if ((i == pRow && j == pCollum)) {
                    prn(sprite);
                } else {
                    int prnMap = map[i][j];
                    System.out.print(coins[prnMap]);
                }
            }
            System.out.println();
        }
    }

    public static int[][] coin(int[][] map, int pCollum) {
        map[3][pCollum] = 1;
        return map;
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