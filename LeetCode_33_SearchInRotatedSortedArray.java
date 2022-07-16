class LeetCode_33_SearchInRotatedSortedArray_Solution1 {
    public int search(int[] nums, int target) {
       for (int i = 0; i < nums.length; i++) {
           if (nums[i] == target)
            return i;
       }
       return -1;
    }
}


class LeetCode_33_SearchInRotatedSortedArray_Solution2 {
    public int[] searchRange(int[] nums, int target) {
       
    }
}