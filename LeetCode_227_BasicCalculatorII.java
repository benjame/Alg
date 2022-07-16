public class LeetCode_227_BasicCalculatorII {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            /**
             * 计算数字的数值 等于（前一个数字 * 10 + 当前的数字）
             *  这样可以获取连续数字字符构成的数字 (11 = 1 * 10 + 1,111 = 11 * 10 + 1 * 1, 8 = 0 * 10 + 8)
             */
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 如果位置i处的符号不是数字与空字符(也就是运算符 '+'、'-'、'*'、'\')或者是最后一位的字符
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
