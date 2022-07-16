public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        nHanota(n, A, B, C);
    }

    public void nHanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        // System.out.println("nHanota:::n::" + n);
        // 从小到大且自上而下编号为0 ~ n - 1
        if (n == 1) {
            move(A, 0, C); // 将编号为0的圆盘从A移动到C
        } else {
            nHanota(n - 1, A, C, B); // 将A上的n-1个圆盘移动到B，C作为辅助塔
            move(A, n - 1, C); // 将A上的第n个圆盘，即编号为n-1圆盘，从A移动到C
            nHanota(n - 1, B, A, C); // 将B上的n-1个圆盘移动到C，A作为辅助塔
        }
    }

    public void move(List<Integer> A, Integer n, List<Integer> C) {
        A.pop(n);
        C.push(n);
    }
}
