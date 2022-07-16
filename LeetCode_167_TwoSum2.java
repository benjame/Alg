public class LeetCode_167_TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int findNum = target - numbers[i];
            if (numbers[i + 1] > findNum) {
                continue;
            }
            if (numbers[i + 1] == findNum) {
                return new int[] {i + 1, i + 2};
            } else {
                for (int j = i + 2; j < numbers.length && numbers[j] <= findNum; j++) {
                    if (numbers[j] == findNum) {
                        return new int[] {i + 1, j + 1};
                    }
                    if (numbers[j] > findNum) {
                        break;
                    }
                }
            }
        }
        return new int[] {};
    }
}


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int findNum = target - numbers[i];
            if (twoSumFromindex(numbers, findNum, i + 1) != -1) {
                return new int[] {i + 1, twoSumFromindex(numbers, findNum, i + 1) + 1};
            } else {
                continue;
            }
        }
        return new int[] {};
    }

    /** 根据目标target，在数组numbers中从indexFrom开始查找值为target的元素，并返回对应的索引index */
    private int twoSumFromindex(int[] numbers, int target, int indexFrom) {
        if (indexFrom >= numbers.length)
            return -1;
        if (numbers[indexFrom] == target) {
            return indexFrom;
        }
        if (numbers[indexFrom] > target) {
            return -1;
        }
        return twoSumFromindex(numbers, target, indexFrom + 1);
    }
}


class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int findNum = target - numbers[i];
            if (twoSumFromindex(numbers, findNum, i + 1) != -1) {
                return new int[] {i + 1, twoSumFromindex(numbers, findNum, i + 1) + 1};
            } else {
                continue;
            }
        }
        return new int[] {};
    }

    /**
     * 根据目标target，在数组numbers中从indexFrom开始查找值为target的元素，并返回对应的索引index，如果没找到返回-1
     */
    private int twoSumFromindex(int[] numbers, int target, int indexFrom) {
        for (int i = indexFrom; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
            if (numbers[i] > target) {
                return -1;
            }
        }
        return -1;
    }
}

/**
 * 二分查找
 */

class Solution3 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}

/**
 * 双指针
 */
class Solution4 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}
