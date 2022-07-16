class Solution {
    /**
     * 对string num1与num2 逐个字符进行遍历
     * 
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder resStr = new StringBuilder();
        // 排除所有非正常情况
        if (num1.isEmpty() || num2.isEmpty()) {
            return resStr.toString();
        }
        if (num1.length() == 0 && num2.length() != 0) {
            return num2;
        }
        if (num2.length() == 0 && num1.length() != 0) {
            return num1;
        }
        if (num1.length() == 0 && num2.length() == 0) {
            return resStr.toString();
        }
        // 当num1与num2都非空
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            resStr.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }
        // 将结果反转过来
        resStr.reverse();
        return resStr.toString();
    }
}