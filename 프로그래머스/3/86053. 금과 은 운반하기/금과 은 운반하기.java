class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long max = (long) (10e9 * 2 * 10e5 * 2);
        int city = g.length;
        
        long start = 0; 
        long end = max;
        
        long answer = Long.MAX_VALUE;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long gold = 0;
            long silver = 0;
            long total = 0;
            
            for (int i = 0; i < city; i++) {
                int nowGold = g[i];
                int nowSilver = s[i];
                int nowWeight = w[i];
                int nowTime = t[i];
                
                long count = mid / (nowTime * 2);
                if (mid % (nowTime * 2) >= t[i]) // 마지막은 왕복 안 해도 되니까 편도 시간있으면 한번 더 이송 가능
                    count++;
                
                gold += Math.min(nowGold, nowWeight * count);
                silver += Math.min(nowSilver, nowWeight * count);
                total += Math.min(nowGold + nowSilver, nowWeight * count);
            }
            
            if (a <= gold && b <= silver && a + b <= total) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}