class Solution {
    public int numRabbits(int[] cs) {
        Arrays.sort(cs);
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = cs[i];
            ans += cnt + 1;
            // 跳过「数值 cnt」后面的 cnt 个「数值 cnt」 
            int k = cnt;
            while (k-- > 0 && i + 1 < n && cs[i] == cs[i + 1]) i++;
        }
        return ans;
    }
}

class Solution2 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            //这里(x + y) / (y + 1) * (y + 1)很巧妙
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }
}

