import java.util.Scanner;

public class Player2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        int size = in.nextInt();

        while (true) {
            for (int i=0; i < size; i++) {
                String row = in.next();
                System.err.println(row);
            }
            String hand1 = in.next();
            String hand2 = in.next();
            String lastOpponentMove = in.next();
            int movesSize = in.nextInt();
            String action = "random";
            for (int i=0; i < movesSize; i++) {
                String move = in.next();
                if (move.equalsIgnoreCase("1514")) action = move;
                if (move.equalsIgnoreCase("1415")) action = move;
                if (move.equalsIgnoreCase("5152")) action = move;
                if (move.equalsIgnoreCase("5251")) action = move;
            }
            System.out.println(action+" Take this!");
        }
    }
}
