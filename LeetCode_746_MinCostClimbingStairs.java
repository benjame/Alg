import java.util.Arrays;

class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int[] minCostStore = new int[cost.length + 1];
        Arrays.fill(minCostStore, -1);
        minCostStore[0] = minCostClimbingStairsFromX(cost, 0, minCostStore);
        minCostStore[1] = minCostClimbingStairsFromX(cost, 1, minCostStore);
        return Math.min(minCostStore[0], minCostStore[1]);
    }

    private int minCostClimbingStairsFromX(int[] cost, int start, int[] minCostStore) {
        int lastIndex = cost.length;
        if (start >= lastIndex) {
            return 0;
        }
        if (start == lastIndex - 1) {
            minCostStore[lastIndex - 1] = cost[lastIndex - 1];
            return minCostStore[lastIndex - 1];
        }
        if (start == lastIndex - 2) {
            minCostStore[lastIndex - 2] = cost[lastIndex - 2];
            return minCostStore[lastIndex - 2];
        } else {
            if (minCostStore[start] != -1) {
                return minCostStore[start];
            } else {
                minCostStore[start] = Math.min(
                        minCostClimbingStairsFromX(cost, start + 1, minCostStore) + cost[start],
                        minCostClimbingStairsFromX(cost, start + 2, minCostStore) + cost[start]);
                return minCostStore[start];
            }
        }
    }
}
