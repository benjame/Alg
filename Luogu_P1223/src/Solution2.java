import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n <= 0) {
            return;
        }
        Pair[] waitTimes = new Pair[n];


        Solution2 sol = new Solution2();
        sol.Solve(n, waitTimes, scan);

    }

    public void Solve(int n, Pair[] waitTimes, Scanner scan) {
        for (int i = 0; i < n; i++) {
            int waitTime = scan.nextInt();
            Pair p = new Pair(i + 1, waitTime);
            waitTimes[i] = p;
        }

        double avgTime = 0;
        double totalTime = 0;

        Arrays.sort(waitTimes, Pair::compareTo);
        for (int i = 0; i < waitTimes.length; i++) {
            totalTime += ((waitTimes.length - i - 1) * waitTimes[i].waitTime);
            System.out.print(waitTimes[i].indx);
            System.out.print(" ");
        }
        avgTime = (totalTime / waitTimes.length);
        System.out.printf("\n%.2f", avgTime);
    }

    public class Pair implements Comparable {
        private int indx;
        private int waitTime;

        Pair() {
            indx = 0;
            waitTime = 0;
        }

        Pair(int x, int y) {
            indx = x;
            waitTime = y;
        }


        @Override
        public int compareTo(Object o) {
            Pair other = (Pair) o;
            return Integer.compare(this.waitTime, other.waitTime);
        }
    }
}
