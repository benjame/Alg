/**
 * 思路：根据行
 */
class LeetCode_42_TrappingRainWater_Solution1 {
    public int trap(int[] height) {
        int totalRainsTraped = 0;
        // 首先获取height数组中的最大值确定层数
        int maxFloor = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxFloor)
                maxFloor = height[i];
        }

        for (int i = 1; i <= maxFloor; i++) {
            int temp = 0;
            boolean updateFlag = false;
            for (int j = 0; j < height.length; j++) {
                if (height[j] < i && updateFlag) {
                    temp += 1;
                }
                if (height[j] >= i) {
                    totalRainsTraped += temp;
                    temp = 0;
                    updateFlag = true;
                }
            }
        }
        return totalRainsTraped;
    }
}


/**
 * 动态规划 思路：对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值， 下标 i 处能接的雨水量等于下标 i处的水能到达的最大高度减去 height[i]
 * 
 */

class LeetCode_42_TrappingRainWater_Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}


/**
 * 单调栈
 * 
 */
class LeetCode_42_TrappingRainWater_Solution3 {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}

/**
 * 双指针
 * 
 */
class LeetCode_42_TrappingRainWater_Solution4 {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
