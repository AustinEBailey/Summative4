import java.util.Scanner;

public class MiniGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        clrscn();
        System.out.println("welcome to Connect four pleadse slect a row to place your piece");
        int[][] map = loadMap();
        enter();
        prnMap(map);
        enter();
        prnMap(map);

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

    public static void prnMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int prnMap = map[i][j];
                System.out.print(prnMap);
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

    //press enter to continue
    public static void enter() {
        Scanner in = new Scanner(System.in);
        prn("Press Enter To Continue");
        String user = in.nextLine();
    }

}