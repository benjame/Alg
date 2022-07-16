import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Pair> timeArray = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            Pair p = new Pair(i, num);
            timeArray.add(p);
        }
        Collections.sort(timeArray);
        int SumOfTime = 0;
        for (Pair pair : timeArray) {
            int curTimeWait = SumOfTime + pair.timeWait;
            SumOfTime += curTimeWait;
            System.out.print(pair.index);
            System.out.print(' ');
        }
        System.out.println(((double) SumOfTime) / ((double) N));

    }

    public class Pair implements Comparable<Pair> {
        int index;
        int timeWait;

        public Pair(int idx, int tW) {
            this.index = idx;
            this.timeWait = tW;
        }

        public int compareTo(Pair other) {
            return Integer.compare(timeWait, other.timeWait);
        }
    }
}
