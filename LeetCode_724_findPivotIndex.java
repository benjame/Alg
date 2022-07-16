public class LeetCode_724_findPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int LeftPlusRight = (totalSum - nums[i]);
            rightSum = LeftPlusRight - leftSum;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
