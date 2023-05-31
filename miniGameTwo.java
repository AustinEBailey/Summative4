import java.util.Scanner;

public class miniGameTwo {
    static int coinNum = 0;
    static boolean done;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        clrscn();

    }

    /*
     * loads and up dates game map
     */
    public static int[][] loadMap() {
        int[][] map = {
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0 },
                { 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }
        };

        return map;
    }

    public static void prnMap(int map[][]) {
        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j]==1){
                
                }
            }
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

}
