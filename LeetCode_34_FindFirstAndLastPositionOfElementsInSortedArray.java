class LeetCode_34_FindFirstAndLastPositionOfElementsInSortedArray_Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] == target) {
                first = i;
            }
            if (i > 0 && nums[i] == target && nums[i - 1] != target) {
                first = i;
            }
            if (i < nums.length - 1 && nums[i] == target && nums[i + 1] != target) {
                last = i;
            }
            if (i == nums.length - 1 && nums[i] == target) {
                last = i;
            }
        }
        return new int[] { first, last };
    }
}

/** 关于区间的二分查找 */
class LeetCode_34_FindFirstAndLastPositionOfElementsInSortedArray_Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] { -1, -1 };
        ans[0] = binarySearch(nums, target, true); // 查找左边界
        ans[1] = binarySearch(nums, target, false); // 查找右边界

        return ans;
    }

    /**
     * @param leftRight 为true寻找左边界，为false则寻找右边界
     */
    public int binarySearch(int[] nums, int target, boolean leftRight) {
        int ans = -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (leftRight)
                    right = mid - 1; // 寻找左边界，则在mid左边继续找
                else
                    left = mid + 1; // 寻找右边界，则在mid右边继续找
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return ans;
    }
}

/**
 * 二分法查找目标值，然后朝2个方向搜索上下界，最差时间复杂度O(n)
 */
class LeetCode_34_FindFirstAndLastPositionOfElementsInSortedArray_Solution3 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int leftIdx = -1, rightIdx = -1;
            if (nums[mid] == target) {
                // return mid;
                leftIdx = mid;
                rightIdx = mid;
                while (leftIdx - 1 >= 0 && nums[leftIdx - 1] == target) {
                    leftIdx--;
                }
                while (rightIdx + 1 < nums.length && nums[rightIdx + 1] == target) {
                    rightIdx++;
                }
                return new int[] { leftIdx, rightIdx };
            } else if (nums[mid] < target) {
                // 这里需要注意，移动左指针
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 这里需要注意，移动右指针
                right = mid - 1;
            }
        }
        return new int[] { -1, -1 };
    }
}