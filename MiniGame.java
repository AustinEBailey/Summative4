public class MiniGame {

    public static void main(String[] args) {
        System.out.println("welcome to Connect four pleadse slect a row to place your piece");

    }

    public static int[][] Map() {
        for(int i = 0;  ){
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
    public static void enter(){
        Scanner in = new Scanner(System.in);
        prn("Press Enter To Continue");
        String user = in.nextLine();
       }

}