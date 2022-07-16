class LeetCode_713_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int retNum = 0;
        /**
         * 如何定义子数组？ 用nums + startIndex + endIndex表示一个唯一的子数组
         */
        for (int endIndex = 0; endIndex < nums.length; endIndex++) {
            for (int startIndex = 0; startIndex <= endIndex; startIndex++) {
                int continuousProduct = 1;
                for (int i = startIndex; i <= endIndex; i++) {
                    continuousProduct *= nums[i];
                }
                if (continuousProduct < k)
                    retNum += 1;
            }
        }
        return retNum;
    }
}

class LeetCode_713_SubarrayProductLessThanK_Solution1 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0)
            return 0;
        double logk = Math.log(k);
        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + Math.log(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            int lo = i + 1, hi = prefix.length;
            while (lo < hi) {
                //二分法 查找满足prefix[j + 1] - prefix[i]小于logK的最大j
                int mi = lo + (hi - lo) / 2;
                if (prefix[mi] < prefix[i] + logk - 1e-9)
                    lo = mi + 1;
                else
                    hi = mi;
            }
            ans += lo - i - 1;
        }
        return ans;
    }
}

class LeetCode_713_SubarrayProductLessThanK_Solution2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k)
                prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
