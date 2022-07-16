import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return ans;
        Arrays.sort(nums); // O(nlogn)
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target)
                continue;
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 去掉重复情况
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue; // 去掉重复情况
                int findNum = -(nums[i] + nums[j]) + target;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == findNum) {
                        ans.add(new ArrayList<>(
                                Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--; // 首先无论如何先要进行加减操作
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else if (nums[left] + nums[right] < findNum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}