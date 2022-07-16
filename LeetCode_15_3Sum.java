import java.util.*;

public class LeetCode_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listRes = new ArrayList<>();
        Set<Set<Integer>> setRes = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            twoSumFromIndex(nums, target, i + 1, nums[i], listRes, setRes);
        }
        return listRes;
    }

    private void twoSumFromIndex(int[] nums, int target, int fromIndex, int startNum,
            List<List<Integer>> listRet, Set<Set<Integer>> setRes) {
        Set<Integer> hashset = new HashSet<>();
        for (int i = fromIndex; i < nums.length; i++) {
            int findNum = target - nums[i];
            List<Integer> listCur = new ArrayList<>();
            Set<Integer> setCur = new HashSet<>();
            if (hashset.contains(findNum)) {
                setCur.add(startNum);
                setCur.add(nums[i]);
                setCur.add(findNum);
                // 检查是否重复
                if (!setRes.contains(setCur)) {
                    setRes.add(setCur);
                    listCur.add(startNum);
                    listCur.add(nums[i]);
                    listCur.add(findNum);
                    listRet.add(listCur);
                }
            }
            hashset.add(nums[i]);
        }
    }
}


class LeetCode_15_3Sum_Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

class LeetCode_15_3Sum_Solution2 {
    // 总时间复杂度：O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2)
            return ans;
        Arrays.sort(nums); // O(nlogn)
        // O(n^2)
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果第一个数大于 0，后面的数都比它大，肯定不成立了
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 去掉重复情况

            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1,
                    // right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;
                    right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else { // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}

