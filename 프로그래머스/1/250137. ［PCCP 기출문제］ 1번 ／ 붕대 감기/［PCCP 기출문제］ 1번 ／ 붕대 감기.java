class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int last = attacks[attacks.length - 1][0];
        int now = health;
        int cum = 0;
        int index = 0;
        
        for (int i = 1; i <= last; i++) {
            if (attacks[index][0] == i) {
                now -= attacks[index][1];
                index++;
                cum = 0;
                if (now <= 0) {
                    now = -1;
                    break;
                }
            } else {
                now += x;
                if (++cum == t) {
                    now += y;
                    cum = 0;
                }
                if (now > health)
                    now = health;
            }
        }
        
        return now;
    }
}