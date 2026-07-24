import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap();
        int n = friends.length;
        
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }
        
        int[][] gift = new int[n][n];
        int[][] count = new int[n][3]; // 준 선물, 받은 선물, 선물 지수
        
        StringTokenizer st;
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            String A = st.nextToken();
            int a = map.get(A);
            String B = st.nextToken();
            int b = map.get(B);
            
            gift[a][b]++;
            count[a][0]++;
            count[b][1]++;
        }
        
        for (int i = 0; i < n; i++) {
            count[i][2] = count[i][0] - count[i][1];
        }
        
        int[] extra = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gift[i][j] > gift[j][i]) {
                    extra[i]++;
                } else if (gift[i][j] < gift[j][i]) {
                    extra[j]++;
                } else {
                    if (count[i][2] > count[j][2])
                        extra[i]++;
                    else if (count[i][2] < count[j][2])
                        extra[j]++;
                }
            }
        }
        
        int max = 0;
        for (int a : extra) {
            max = Math.max(a, max);
        }
        
        return max;
    }
}