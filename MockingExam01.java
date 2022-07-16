class MockingExam01_P1 {
    public int maxA(int n) {
        int maxARes = n;
        if (n <= 6)
            return n;
        if (n > 6) {
            for (int i = 3; i < n; i++) {
                maxARes = Math.max(maxA(n - i) * (i - 1), maxARes);
            }
            return maxARes;
        }
        return maxARes;
    }
}


class MockingExam01_P2 {
    public int tupleSameProduct(int[] nums) {
        
    }
}


class MockingExam01_P3 {
    public int[] maximizeXor(int[] nums, int[][] queries) {

    }
}
