/**
 * 从低位到高位逐位进行求和，使用int变量carry表示进位与否
 */
class LeetCode_getOffer_002 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int digitB = (j >= 0) ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        //最后carry位为1，进1
        if (carry == 1) {
            result.append(1);
        }
        //最终结果需要反向
        return result.reverse().toString();
    }
}

