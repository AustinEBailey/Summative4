import java.util.Scanner;

public class MiniGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        clrscn();
        System.out.println("welcome to Connect four pleadse slect a row to place your piece");
        int[][] map = loadMap();
        String sprite = "!";
        int pCol = 0;
        int pRow = 0;
        boolean done = false;
        while (!done) {
            System.out.print("\033[H\033[2J");
            prnMap(map, sprite, pCol, pRow);
            String input = in.nextLine();
            if (input.equals("l")) {
                pCol--;
            } else if (input.equals("r")) {
                pCol++;
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

    public static void prnMap(int[][] map, String playerSprite, int pCol, int Row) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if ((i == Row && j == pCol)) {
                    System.out.print(playerSprite);
                } else {
                    int prnMap = map[i][j];
                    System.out.print(prnMap);
                }
            }
            System.out.println();

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