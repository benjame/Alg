/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num = 16
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num = 14
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * Related Topics 数学 二分查找 👍 326 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean isPerfectSquare(int num) {
    int left = 0, right = num;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      long square = (long) mid * mid;
      if (square < num) {
        left = mid + 1;
      } else if (square > num) {
        right = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
