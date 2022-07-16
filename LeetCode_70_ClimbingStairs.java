import java.util.Arrays;

public class Solution {
    private int[] numOfMethods = new int[200];
    private boolean isFirstExec = true;

    public int climbStairs(int n) {
        if (n == 0){
            numOfMethods[0] = 0;
            return numOfMethods[0];
        }
        if (n == 1) {
            numOfMethods[1] = 1;
            return numOfMethods[1];
        }
        if (n == 2) {
            numOfMethods[2] = 2;
            return numOfMethods[2];
        }
        if (isFirstExec) {
            Arrays.fill(numOfMethods, -1);
            isFirstExec = false;
        }
        if (numOfMethods[n] != -1) {
            return numOfMethods[n];
        }
        numOfMethods[n - 1] = climbStairs(n - 1);
        numOfMethods[n - 2] = climbStairs(n - 2);
        return numOfMethods[n - 1] + numOfMethods[n - 2];
    }
}
