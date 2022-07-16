class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;

        // 判断是否相同符号，同号则结果为正数
        boolean flag = false;
        if ((a < 0 && b < 0) || ((a > 0) && (b > 0))) {
            flag = true;
        }

        // 定义被除数dividend 与除数divisor (long类型)，将a、b转换为long类型后取绝对值
        long dividend = Math.abs((long) a);
        long divisor = Math.abs((long) b);
        if (dividend < divisor) {
            return 0;
        }
        /*
         * 计算 结果的绝对值
         */
        int result = 0;
        int shift = 31;
        while (dividend >= divisor) {
            while (dividend < divisor << shift) {
                shift--;
            }
            dividend -= divisor << shift;
            result += 1 << shift;
        }

        return flag ? result : -result;

    }
}
