class LeetCode_224_BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}


/**
 * 双栈解决通用版 "表达式计算问题" 我们使用两个栈存放nums和ops nums: 存放所有的数字 ops: 存放所有的数字以外的操作，+/- 也看做是一种操作
 */
class LeetCode_224_BasicCalculator_Solution {
    public int calculate(String s) {
        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        nums.addLast(0);
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        // 存放所有的操作，包括 +/-
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    char op = ops.peekLast();
                    if (op != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNum(c)) {
                    int u = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (j < n && isNum(cs[j]))
                        u = u * 10 + (int) (cs[j++] - '0');
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    while (!ops.isEmpty() && ops.peekLast() != '(')
                        calc(nums, ops);
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty())
            calc(nums, ops);
        return nums.peekLast();
    }

    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2)
            return;
        if (ops.isEmpty())
            return;
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);
    }

    boolean isNum(char c) {
        return Character.isDigit(c);
    }
}


/**
 * 双栈 高效版本
 */

class LeetCode_224_BasicCalculator_Solution2 {
    public int calculate(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        int len = str.length;
        Stack<Integer> st_num = new Stack<>();
        Stack<Integer> st_signs = new Stack<>();
        int sign = 1;// 正负号,运算符号
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ')
                continue;
            if (str[i] == '+' || str[i] == '-')
                sign = str[i] == '+' ? 1 : -1;
            else if (str[i] >= '0' && str[i] <= '9') {// 数字
                int num = str[i] - '0';
                while (i < len - 1 && str[i + 1] >= '0' && str[i + 1] <= '9') {// 将这个数字找完
                    num = num * 10 + (str[++i] - '0');
                }
                ans += sign * num;
            } else if (str[i] == '(') {// 左括号，暂存结果
                st_num.push(ans);
                st_signs.push(sign);
                ans = 0;
                sign = 1;
            } else
                ans = st_num.pop() + ans * st_signs.pop();// 右括号更新结果
        }
        return ans;
    }
}
