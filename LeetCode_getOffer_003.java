class LeetCode_getOffer_003 {
    public int[] countBits(int n) {
        int[] resArray = new int[n + 1];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = countOnes(i);
        }
        return resArray;
    }

    private int countOnes(int n) {
        int countOnes = 0;
        int num = n;
        while (num > 0) {
            if (num % 2 != 0) {
                countOnes++;
            }
            num /= 2;
        }
        return countOnes;
    }
}


class LeetCode_getOffer_003_Solution {
    public int[] countBits(int n) {
        int[] resArray = new int[n + 1];
        for (int i = 0; i < resArray.length; i++) {
            if ((i & 1) == 0) { // 偶数
                resArray[i] = resArray[i >> 1];
            } else { // 奇数
                resArray[i] = resArray[i - 1] + 1;
            }
        }
        return resArray;
    }
}


